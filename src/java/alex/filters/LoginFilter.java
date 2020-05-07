package alex.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.List;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

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

public class LoginFilter implements Filter {

    private FilterConfig filterConfiguration = null;

    @Override
    public void init(FilterConfig filterConfiguration) {
        this.filterConfiguration = filterConfiguration;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        ServletContext servletContext = filterConfiguration.getServletContext();

        String logRequest = filterConfiguration.getFilterName() + " " + httpRequest.getServletPath() + ":  A login attempt was made";
 
        servletContext.log(logRequest);
        chain.doFilter(httpRequest, response);

        // makes a file outside tomcat, if this is required.
//      makeLogFile(logRequest);

    }
    @Override
    public void destroy() {
        filterConfiguration = null;
    }

    protected void makeLogFile(String logRequest) throws ServletException, IOException {

        String excelFile = "C:/Users/Alex/Desktop/loginlog.xls";

        OutputStream out = new FileOutputStream(excelFile);

        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Login Servlet Log");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Login Servlet Log");
        row = sheet.createRow(2);
        row.createCell(0).setCellValue(logRequest);

        workbook.write(out);
        out.close();
    }
}
