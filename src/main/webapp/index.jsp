<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>nRoll</title>
        <c:url value="style/style.css" var="styleUrl"/>
        <link rel="stylesheet" type="text/css" href="${styleUrl}">
        <c:url value="script/index.js" var="indexScriptUrl"/>
        <c:url value="script/login.js" var="loginScriptUrl"/>
        <script src="${indexScriptUrl}"></script>
        <script src="${loginScriptUrl}"></script>
    </head>
<body>
<div class="loginbox content" id="loginDiv">
    <img src="img/avatar.png" class="avatar">
    <h1>nRoll v0.3 login</h1>
    <form id="login-form">
        <input type="text" name="email" placeholder="Email" id="login-email">
        <input type="password" name="password" placeholder="Password" id="login-password">
    </form>
    <button class="login-button" id="login-button"><span>Login </span></button>
</div>

<div class="hidden content" id="mainDiv">
    <p>test</p>
</div>
</body>
</html>
