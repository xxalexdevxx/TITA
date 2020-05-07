package alex.business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import alex.data.UserDB;
import java.util.List;
import alex.bll.authentication.User;
import java.io.*;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class RequestSpreadsheet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Registered Users");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("All Registered Users");
        
        List<User> users = UserDB.selectUsers();
        Iterator<User> userIterator = users.iterator();

        String firstName = "";
        String lastName = "";
        int i = 2;
        for (User user : users) {
            firstName = user.getFirstName();
            lastName = user.getLastName();

            while (userIterator.hasNext()) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(firstName);
                row.createCell(1).setCellValue(lastName);
                userIterator.next();
                i++;
                break;
            }
        }

        response.setHeader("content-disposition", "attachment; filename=users.xls");
        response.setHeader("cache-control", "no-cache");

        OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.close();         
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
    }
}
