function onProfileClicked() {
    let activeProfile = JSON.parse(this.getAttribute('profile'));
    document.getElementById('profileFirstNameInput').value = activeProfile.firstName;
    document.getElementById('profileMiddleNameInput').value = activeProfile.middleName;
    document.getElementById('profileLastNameInput').value = activeProfile.lastName;
    document.getElementById('profileYearInput').value = activeProfile.dateOfBirth.slice(0,4);
    document.getElementById('profileMonthInput').value = activeProfile.dateOfBirth.slice(5,7);
    document.getElementById('profileDayInput').value = activeProfile.dateOfBirth.slice(8,10);
    if(activeProfile.gender === "MALE") {
        document.getElementById('profileMaleInput').click();
    }else if(activeProfile.gender === "FEMALE") {
        document.getElementById('profileFemaleInput').click();
    }
    document.getElementById('profileEmailInput').value = activeProfile.email;
    document.getElementById('profilePhoneInput').value = activeProfile.phone;
    document.getElementById('countryInput').value = activeProfile.country;
    document.getElementById('profileZipInput').value = activeProfile.zip;
    document.getElementById('profileCityInput').value = activeProfile.city;
    document.getElementById('profileAddressInput').value = activeProfile.address;
    document.getElementById('profileStudentIdInput').value = activeProfile.studentId;
    document.getElementById('profileSocialSecurityInput').value = activeProfile.socialSecurityNumber;
    document.getElementById('profileTaxNumberInput').value = activeProfile.taxNumber;
    document.getElementById('profileTabButton').click();
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
        });
}

function onMiddleNameChecked() {
    if (this.checked) {
        document.getElementById('profileMiddleNameInput').removeAttribute('disabled');
    } else {
        document.getElementById('profileMiddleNameInput').setAttribute('disabled', 'true');
    }
}