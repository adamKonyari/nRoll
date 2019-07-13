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
    let institution = document.getElementById('profileInstitutionInput').value;
    let major = document.getElementById('profileMajorInput').value;
    let studentId = document.getElementById('profileStudentIdInput').value;
    let socialSecurityNumber = document.getElementById('profileSocialSecurityInput').value;
    let taxNumber = document.getElementById('profileTaxNumberInput').value;
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
    params.append('institution', institution);
    params.append('major', major);
    params.append('studentId', studentId);
    params.append('socialSecurityNumber', socialSecurityNumber);
    params.append('taxNumber', taxNumber);
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