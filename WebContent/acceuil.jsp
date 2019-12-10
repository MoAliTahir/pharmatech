<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:view>
		<h1>Page d'acceuil</h1>
		<h:form>
			<h:outputText value="Welcome ... #{ loginBean.userName }"></h:outputText><br>
			
			<h:commandLink action="#{loginBean.logout }" value="Logout"></h:commandLink>
		</h:form>
	</f:view>
	
</body>
</html>