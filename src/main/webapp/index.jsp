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
        <button class="tabLinks" onclick="openTab(event, 'search')" id="searchTab">Search</button>
        <button class="tabLinks" onclick="openTab(event, 'profiles')" id="profileTabButton">Create</button>
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
        <div id="searchResultDiv">
        </div>
        <div id="profileDisplayDiv" style="display: none">

            <div class="profileFromDiv" onsubmit="return false;">
                <div>
                    <button id="backToSearchResultButton">Back</button>
                    <h1 id="profileNameDisplayH1" style="color: #ff8a00"></h1>
                </div>
                <form id="profileDisplyForm">
                    <div class="section"><span>1</span>Personal info</div>
                    <div class="inner-wrap">
                        <input type="text" name="firstNameField" id="profileFirstNameDisplay" placeholder="First name">
                        <input type="text" name="middleNameField" id="profileMiddleNameDisplay" class="middleNameField"
                               placeholder="Middle name"
                               disabled>
                        <div class="onoffswitch">
                            <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
                                   id="middleNameDisplayCheckbox">
                            <label class="onoffswitch-label" for="middleNameDisplayCheckbox"></label>
                        </div>
                        <input type="text" name="lastNameField" id="profileLastNameDisplay" placeholder="Last name">
                        <div id="dateOfBirthDisplayDiv">
                            <i class="material-icons" style="float:left">cake</i>
                            <input type="text" name="yearField" id="profileYearDisplay" placeholder="YYYY"
                                   maxlength="4">
                            <input type="text" name="monthField" id="profileMonthDisplay" placeholder="MM"
                                   maxlength="2">
                            <input type="text" name="dayField" id="profileDayDisplay" placeholder="DD" maxlength="2">
                        </div>
                        <div style="padding-top: 7px">
                            <input type="radio" name="gender" value="MALE" id="profileMaleDisplay"> Male ♂
                            <input type="radio" name="gender" value="FEMALE" id="profileFemaleDisplay"> Female ♀
                        </div>
                    </div>
                    <div class="section"><span>2</span>Contact info</div>
                    <div class="inner-wrap">
                        <input type="email" name="emailField" placeholder="Email" id="profileEmailDisplay"><br>
                        <input type="text" name="phoneField" placeholder="Phone e.g. +36201234567"
                               id="profilePhoneDisplay"><br>
                        <input type="text" name="countryField" placeholder="Country" id="countryDisplay">
                        <input type="text" name="zipField" placeholder="Zip code" id="profileZipDisplay">
                        <input type="text" name="cityField" placeholder="City" id="profileCityDisplay">
                        <input type="text" name="addressField" placeholder="Address" id="profileAddressDisplay">
                    </div>

                    <div class="section"><span>3</span>Studies</div>
                    <div class="inner-wrap">
                        <select id="profileInstitutionDisplay">
                            <option default value="1">Institution</option>
                        </select>
                        <select id="profileMajorDisplay">
                            <option default value="1">Major</option>
                        </select>
                    </div>
                    <div class="section"><span>4</span>Serial numbers</div>
                    <div class="inner-wrap">
                        <input type="text" name="studentIdField" placeholder="Student ID" id="profileStudentIdDisplay">
                        <input type="text" name="socialSecurityNumberField" placeholder="Social security number"
                               id="profileSocialSecurityDisplay">
                        <input type="text" name="taxNumberField" placeholder="Tax number" id="profileTaxNumberDisplay">
                    </div>
                    <div class="inner-wrap">
                        <div style="text-align: center; padding-bottom: 15px">
                            <input type="radio" name="profileStatus" value="ACTIVE" id="profileActiveDisplay"> ACTIVE
                            <input type="radio" name="profileStatus" value="PASSIVE" id="profilePassiveDisplay"> PASSIVE
                        </div>
                        <button class="saveButton" id="updateProfileButton"><span>Save profile</span></button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div id="profiles" class="tabContent">
        <div id="profileFromDiv" class="profileFromDiv" onsubmit="return false;">
            <h1>New Profile</h1>
            <form id="newProfileForm">
                <div class="section"><span>1</span>Personal info</div>
                <div class="inner-wrap">
                    <input type="text" name="firstNameField" id="profileFirstNameInput" placeholder="First name">
                    <input type="text" name="middleNameField" class="middleNameField" id="profileMiddleNameInput"
                           placeholder="Middle name"
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
                        <input type="radio" name="gender" value="MALE" id="profileMaleInput"> Male ♂
                        <input type="radio" name="gender" value="FEMALE" id="profileFemaleInput"> Female ♀
                    </div>
                </div>
                <div class="section"><span>2</span>Contact info</div>
                <div class="inner-wrap" id="contactInfoWrapper">
                    <input type="email" name="emailField" placeholder="Email" id="profileEmailInput"><br>
                    <input type="text" name="phoneField" placeholder="Phone e.g. +36201234567"
                           id="profilePhoneInput"><br>
                    <input type="text" name="countryField" placeholder="Country" id="countryInput">
                    <input type="text" name="zipField" placeholder="Zip code" id="profileZipInput">
                    <input type="text" name="cityField" placeholder="City" id="profileCityInput">
                    <input type="text" name="addressField" placeholder="Address" id="profileAddressInput">
                </div>

                <div class="section"><span>3</span>Studies</div>
                <div class="inner-wrap">
                    <select id="profileInstitutionInput">
                        <option default value="1">Institution</option>
                    </select>
                    <select id="profileMajorInput">
                        <option default value="1">Major</option>
                    </select>
                </div>
                <div class="section"><span>4</span>Serial numbers</div>
                <div class="inner-wrap">
                    <input type="text" name="studentIdField" placeholder="Student ID" id="profileStudentIdInput">
                    <input type="text" name="socialSecurityNumberField" placeholder="Social security number"
                           id="profileSocialSecurityInput">
                    <input type="text" name="taxNumberField" placeholder="Tax number" id="profileTaxNumberInput">
                </div>
                <div class="inner-wrap">
                    <div style="text-align: center; padding-bottom: 15px">
                        <input type="radio" name="profileStatus" value="ACTIVE" id="profileActiveInput"> ACTIVE
                        <input type="radio" name="profileStatus" value="PASSIVE" id="profilePassiveInput"> PASSIVE
                    </div>
                    <button class="saveButton" id="saveProfileButton"><span>Save profile</span></button>
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
