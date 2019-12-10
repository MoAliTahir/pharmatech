	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>

<head>
<meta charset="ISO-8859-1">
<title>Bienvenue</title>
</head>
<body>
	<f:view>
		<h1>Trois balises HTML</h1>
		
		<!-- div ng-app="">
		  <p>NG bind Test: <input type="text" ng-model="name"></p>
		  <p ng-bind="name"></p>
		</div>-->
		
			
		<h:form>
		<h:outputText value="Connectez-vous "></h:outputText><br><br>
		<h:outputLabel value="Username: " />
	
			<h:inputText value="#{loginBean.userName}" required="true" requiredMessage="Nom d'utilisateur obligatoir" id="username" /><br><br>
			<h:message for="username" errorClass="error_message" ></h:message>
			
			<h:outputLabel value="Password: " />
			<h:inputSecret value="#{loginBean.password}" required="true" requiredMessage="Mot de passe obligatoir" id="pass"/><br>
			 <h:message for="pass" errorClass="error_message" ></h:message>
			 
			<h:commandButton value="Login" action="#{loginBean.login}" />
		</h:form>
		
		</f:view>
</body>
</html>