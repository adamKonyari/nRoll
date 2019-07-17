function onProfileClicked() {
    document.getElementById('profileDisplayDiv').addEventListener('keyup', (e) => {
        if(e.key === 'Escape') {
            backToSearchResults()
        }
    });
    document.getElementById('backToSearchResultButton').addEventListener('click', backToSearchResults);
    let activeProfile = JSON.parse(this.getAttribute('profile'));
    document.getElementById('profileNameDisplayH1').innerHTML = activeProfile.firstName + ' ' + activeProfile.lastName;
    document.getElementById('profileFirstNameDisplay').value = activeProfile.firstName;
    document.getElementById('profileMiddleNameDisplay').value = activeProfile.middleName;
    document.getElementById('profileLastNameDisplay').value = activeProfile.lastName;
    document.getElementById('profileYearDisplay').value = activeProfile.dateOfBirth.slice(0,4);
    document.getElementById('profileMonthDisplay').value = activeProfile.dateOfBirth.slice(5,7);
    document.getElementById('profileDayDisplay').value = activeProfile.dateOfBirth.slice(8,10);
    if(activeProfile.gender === "MALE") {
        document.getElementById('profileMaleDisplay').click();
    }else if(activeProfile.gender === "FEMALE") {
        document.getElementById('profileFemaleDisplay').click();
    }
    document.getElementById('profileEmailDisplay').value = activeProfile.email;
    document.getElementById('profilePhoneDisplay').value = activeProfile.phone;
    document.getElementById('countryDisplay').value = activeProfile.country;
    document.getElementById('profileZipDisplay').value = activeProfile.zip;
    document.getElementById('profileCityDisplay').value = activeProfile.city;
    document.getElementById('profileAddressDisplay').value = activeProfile.address;
    document.getElementById('profileStudentIdDisplay').value = activeProfile.studentId;
    document.getElementById('profileSocialSecurityDisplay').value = activeProfile.socialSecurityNumber;
    document.getElementById('profileTaxNumberDisplay').value = activeProfile.taxNumber;
    if(activeProfile.profileStatus === 'ACTIVE') {
        document.getElementById('profileActiveDisplay').click();
    } else if(activeProfile.profileStatus === 'PASSIVE') {
        document.getElementById('profilePassiveDisplay').click();
    }
    document.getElementById('searchResultDiv').style.display = 'none';
    document.getElementById('profileDisplayDiv').style.display = 'block';
}

function onSaveProfileButtonClicked() {
    let firstName = document.getElementById('profileFirstNameInput').value;
    let middleName = document.getElementById('profileMiddleNameInput').value;
    let lastName = document.getElementById('profileLastNameInput').value;
    let year = document.getElementById('profileYearInput').value;
    let month = document.getElementById('profileMonthInput').value;
    let day = document.getElementById('profileDayInput').value;
    let dateOfBirth = year + "-" + month + "-" + day;
    let gender;
    if (document.getElementById('profileMaleInput').checked) {
        gender = 'MALE';
    } else if (document.getElementById('profileFemaleInput').checked) {
        gender = 'FEMALE';
    }
    let email = document.getElementById('profileEmailInput').value;
    let phone = document.getElementById('profilePhoneInput').value;
    let country = document.getElementById('countryInput').value;
    let zip = document.getElementById('profileZipInput').value;
    let city = document.getElementById('profileCityInput').value;
    let address = document.getElementById('profileAddressInput').value;
    let institutionId = document.getElementById('profileInstitutionInput').value;
    let majorId = document.getElementById('profileMajorInput').value;
    let studentId = document.getElementById('profileStudentIdInput').value;
    let socialSecurityNumber = document.getElementById('profileSocialSecurityInput').value;
    let taxNumber = document.getElementById('profileTaxNumberInput').value;
    let profileStatus;
    if (document.getElementById("profileActiveInput").checked) {
        profileStatus = 'ACTIVE';
    } else if (document.getElementById("profilePassiveInput").checked) {
        profileStatus = 'PASSIVE';
    }
    let params = new URLSearchParams();
    params.append('firstName', firstName);
    params.append('middleName', middleName);
    params.append('lastName', lastName);
    params.append('dateOfBirth', dateOfBirth);
    params.append('gender', gender);
    params.append('email', email);
    params.append('phone', phone);
    params.append('country', country);
    params.append('zip', zip);
    params.append('city', city);
    params.append('address', address);
    params.append('institutionId', institutionId);
    params.append('majorId', majorId);
    params.append('studentId', studentId);
    params.append('socialSecurityNumber', socialSecurityNumber);
    params.append('taxNumber', taxNumber);
    params.append('profileStatus', profileStatus);
    postAsync('protected/profile', params)
        .then((message) => {
            console.log(message);
            document.getElementById('newProfileForm').reset();
        });
}

function onMiddleNameInputChecked() {
    if (this.checked) {
        document.getElementById('profileMiddleNameInput').removeAttribute('disabled');
    } else {
        document.getElementById('profileMiddleNameInput').setAttribute('disabled', 'true');
    }
}

function onMiddleNameDisplayChecked() {
    if (this.checked) {
        document.getElementById('profileMiddleNameDisplay').removeAttribute('disabled');
    } else {
        document.getElementById('profileMiddleNameDisplay').setAttribute('disabled', 'true');
    }
}

function backToSearchResults() {
    document.getElementById('searchResultDiv').style.display = 'block';
    document.getElementById('profileDisplayDiv').style.display = 'none';
}