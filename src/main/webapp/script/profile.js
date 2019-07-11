function onMiddleNameChecked() {
    if (this.checked) {
        document.getElementById('profileMiddleNameInput').removeAttribute('disabled');
    } else {
        document.getElementById('profileMiddleNameInput').setAttribute('disabled', 'true');
    }
}