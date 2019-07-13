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
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
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
    <button class="loginButton" id="login-button"><span>Login </span></button>
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
                    <input type="text" name="middleNameField" id="profileMiddleNameInput" placeholder="Middle name"
                           disabled>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="middleNameCheckbox">
                        <label class="onoffswitch-label" for="middleNameCheckbox"></label>
                    </div>
                    <input type="text" name="lastNameField" id="profileLastNameInput" placeholder="Last name">
                    <div id="dateOfBirthInputDiv">
                        <i class="material-icons" style="float:left">cake</i>
                        <input type="text" name="yearField" id="profileYearInput" placeholder="YYYY" maxlength="4">
                        <input type="text" name="monthField" id="profileMonthInput" placeholder="MM" maxlength="2">
                        <input type="text" name="dayField" id="profileDayInput" placeholder="DD" maxlength="2">
                    </div>
                    <div style="padding-top: 7px">
                        <input type="radio" name="gender" value="MALE" id="profileGenderMaleInput"> Male ♂
                        <input type="radio" name="gender" value="FEMALE" id="profileGenderFemaleInput"> Female ♀
                    </div>
                </div>
                <div class="section"><span>2</span>Contact info</div>
                <div class="inner-wrap" id="contactInfoWrapper">
                    <input type="email" name="emailField" placeholder="Email" id="profileEmailInput"><br>
                    <input type="text" name="phoneField" placeholder="Phone e.g. +36201234567" id="profilePhoneNumberInput"><br>
                    <input type="text" name="countryField" placeholder="Country" id="countryInputField">
                    <input type="text" name="zipField" placeholder="Zip code" id="profileZipInputField">
                    <input type="text" name="cityField" placeholder="City" id="profileCityInputField">
                    <input type="text" name="addressField" placeholder="Address" id="profileAddressInputField">
                </div>

                <div class="section"><span>3</span>Studies</div>
                <div class="inner-wrap">
                    <select id="institutionSelect">
                        <option default>Institution</option>
                    </select>
                    <select id="majorSelect">
                        <option default>Major</option>
                    </select>
                </div>
                <div class="section"><span>4</span>Serial numbers</div>
                <div class="inner-wrap">
                    <input type="text" name="studentIdField" placeholder="Student ID" id="profileStudentIdInputField">
                    <input type="text" name="socialSecurityNumberField" placeholder="Social security number" id="profileSocialSecurityInputField">
                    <input type="text" name="taxNumberField" placeholder="Tax number" id="profileTaxNumberInputField">
                </div>
                <div class="inner-wrap">
                    <button class="saveButton" id="saveProfileButton"><span>Save</span></button>
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
