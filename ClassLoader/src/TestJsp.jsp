<%@page import="java.lang.*" %>
<%@page import="java.io.*" %>
<%@page import="*" %>
<%
    InputStream is = new FileInputStream("F:/Project/JVM/out/production/ClassLoader/ClassLoaderTest.class");
    byte[] b = new byte[is.available()];
    is.read(b);
    is.close();
    System.out.println("<textarea style='width:1000;height=800'>");
    System.out.println(JavaclassExecuter.execute(b));
    System.out.println("</textarea>");
%>
