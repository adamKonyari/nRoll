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
    <c:url value="script/table.js" var="tableScriptUrl"/>
    <c:url value="script/profile.js" var="profileScriptUrl"/>
    <script src="${indexScriptUrl}"></script>
    <script src="${loginScriptUrl}"></script>
    <script src="${tabScriptUrl}"></script>
    <script src="${searchScriptUrl}"></script>
    <script src="${tableScriptUrl}"></script>
    <script src="${profileScriptUrl}"></script>
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
        <div id="searchResultDivEl">
        </div>
    </div>
    <div id="profiles" class="tabContent">
        <div id="profileFromDiv" class="profileFromDiv">
            <h1>New Profile<span>Fill the form in order to create a new profile!</span></h1>
            <form>
                <div class="section"><span>1</span>Personal info</div>
                <div class="inner-wrap">
                    <input type="text" name="firstNameField" id="profileFirstNameInput" placeholder="First name">
                    <input type="text" name="middleNameField" id="profileMiddleNameInput" placeholder="Middle name" disabled>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="middleNameCheckbox">
                        <label class="onoffswitch-label" for="middleNameCheckbox"></label>
                    </div>
                    <input type="text" name="lastNameField" id="profileLastNameInput" placeholder="Last name">
                    <div id="dateOfBirthInputDiv">
                        <input type="date" id="profileDateOfBirthInput">
                    </div>
                    <div>
                        <input type="radio" name="male" value="MALE" id="profileGenderMaleInput"> Male<br>
                        <input type="radio" name="female" value="FEMALE" id="profileGenderFemaleInput"> Female<br>
                    </div>
                </div>

                <div class="section"><span>2</span>Contact info</div>
                <div class="inner-wrap" id="contactInfoWrapper">
                    <input type="email" name="field3" placeholder="Email" id="profileEmailInput">
                    <input type="text" name="field4" placeholder="Phone" id="profilePhoneNumberInput">
                </div>

                <div class="section"><span>3</span>Passwords</div>
                <div class="inner-wrap">
                    <label>Password <input type="password" name="field5"/></label>
                    <label>Confirm Password <input type="password" name="field6"/></label>
                </div>
                <div class="button-section">
                    <input type="submit" name="Sign Up"/>
                    <span class="privacy-policy">
     <input type="checkbox" name="field7">You agree to our Terms and Policy.
     </span>
                </div>
            </form>
        </div>
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
