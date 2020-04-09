<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<% Calendar calendar = new GregorianCalendar();
    calendar.add(Calendar.MONTH, 1);
    int day = calendar.get(calendar.DAY_OF_MONTH);
    int year = calendar.get(calendar.YEAR);
    int month = calendar.get(calendar.MONTH);
%>
<p>Copyright: <%= month %>/<%= day %>/<%= year %></p>
    </body>
</html>
