<%--Vad kunden ser som inloggad--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Avklarad städning</title>
<style>
	label {
		display: inline-block;
		width: 200px;
		margin: 5px;
		text-align: left;
	}

	input[type=radio] {
		display: inline-block;
		margin-left: 45px;
	}
	input[type=checkbox] {
		display: inline-block;
		margin-right: 190px;
	}	
	
	button {
		padding: 10px;
		margin: 10px;
	}
</style>
</head>
<body>
	<div align="center">
		<h2>Senast utförd städning</h2>
		<%--Skapar upp en knapp för godkänd städning, går sedan till "godkand"--%>
		<form:form action="godkand_stadning" method="post" modelAttribute="user">


			<form:label path="betyg">Hur nöjd var du med städningen?</form:label>
			<form:radiobutton path="betyg" value="Inte nöjd"/>Inte nöjd
			<form:radiobutton path="betyg" value="Nöjd"/>Nöjd
			<form:radiobutton path="betyg" value="Mycket nöjd"/>Mycket nöjd<br/>

			<form:label path="typ">Typ av städning:</form:label>
			<form:select path="typ" items="${typAvStadning}" /><br/>


			<form:label path="kommentar">Kommentar:</form:label>
			<form:textarea path="kommentar" cols="25" rows="5"/><br/>

			<form:button>Godkänn städning</form:button>

		</form:form>

		<%--Skapar upp en knapp för ej godkänd städning, går sedan till "ej_godkand"--%>
		<form:form action="ej_godkand" method="post" modelAttribute="user">
			<form:button>Jag godkänner inte städningen</form:button>
		</form:form>
	</div>
</body>
</html>