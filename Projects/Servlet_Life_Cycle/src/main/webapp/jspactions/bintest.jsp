
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bean Test</title>
</head>
<body>

<jsp:useBean id="MyBeanObj" class="com.aryanlanghanoja.useBeanTest.MyBean" />
<jsp:getProperty name="MyBeanObj" property="msg"/>
<br/>
<jsp:setProperty name="MyBeanObj" property="msg" value="Hii , There" />
<jsp:getProperty name="MyBeanObj" property="msg"/>
</body>
</html>