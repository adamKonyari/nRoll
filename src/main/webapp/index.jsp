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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <c:url value="script/index.js" var="indexScriptUrl"/>
    <c:url value="script/login.js" var="loginScriptUrl"/>
    <c:url value="script/tab.js" var="tabScriptUrl"/>
    <c:url value="script/search.js" var="searchScriptUrl"/>
    <script src="${indexScriptUrl}"></script>
    <script src="${loginScriptUrl}"></script>
    <script src="${tabScriptUrl}"></script>
    <script src="${searchScriptUrl}"></script>
</head>
<body>
<div class="loginBox content" id="loginDiv">
    <img src="img/avatar.png" class="avatar">
    <h1>nRoll v0.3 login</h1>
    <form id="login-form">
        <input type="text" name="email" placeholder="Email" id="login-email">
        <input type="password" name="password" placeholder="Password" id="login-password">
    </form>
    <button class="login-button" id="login-button"><span>Login </span></button>
</div>

<div class="hidden content wrapper" id="mainDiv">
    <div class="topNav">
        <button class="tabLinks" onclick="openTab(event, 'search')" id="defaultOpen">Search</button>
        <button class="tabLinks" onclick="openTab(event, 'profiles')">Profiles</button>
        <button class="tabLinks" onclick="openTab(event, 'companies')">Companies</button>
        <button class="tabLinks" onclick="openTab(event, 'positions')">Positions</button>
        <div class="search-container">
        <form id="searchForm" onsubmit="return false;">
            <input type="text" placeholder="Search..." name="search" id="searchInput">
            <button id="searchButton"><i class="fa fa-search"></i></button>
        </form>
        </div>
    </div>
    <div id="search" class="tabContent">
        <p>search content</p>
    </div>
    <div id="profiles" class="tabContent">
        <p>Profiles content</p>
    </div>
    <div id="companies" class="tabContent">
        <p>Companies content</p>
    </div>
    <div id="positions" class="tabContent">
        <p>Positions content</p>
    </div>
</div>
</body>
</html>
