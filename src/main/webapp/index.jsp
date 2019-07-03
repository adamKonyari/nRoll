<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>nRoll</title>
        <c:url value="style/style.css" var="styleUrl"/>
        <c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" var="jqueryUrl"/>
        <c:url value="script/index.js" var="indexScriptUrl"/>
        <link rel="stylesheet" type="text/css" href="${styleUrl}">
        <script src="${jqueryUrl}"></script>
        <script src="${indexScriptUrl}"></script>
    </head>
<body>
<div class="loginbox">
    <img src="img/avatar.png" class="avatar">
    <h1>nRoll v0.3 login</h1>
    <form>
        <input type="text" name="" placeholder="Email">
        <input type="password" name="" placeholder="Password">
    </form>
    <button class="login-button"><span>Login </span></button>
</div>
</body>
</html>
