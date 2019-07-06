function onLoginButtonClicked() {
    let emailInputEl = document.getElementById('login-email');
    let passwordInputEl = document.getElementById('login-password');
    let email = emailInputEl.value;
    let password = passwordInputEl.value;
    if (email === '' && password === '') {
        emailInputEl.style.borderBottom = "2px solid red";
        passwordInputEl.style.borderBottom = "2px solid red";
    } else if (email === '') {
        emailInputEl.style.borderBottom = "2px solid red";
        passwordInputEl.style.borderBottom = "1px solid white";
    } else if (password === '') {
        emailInputEl.style.borderBottom = "1px solid white";
        passwordInputEl.style.borderBottom = "2px solid red";
    } else {
        emailInputEl.style.borderBottom = "1px solid white";
        passwordInputEl.style.borderBottom = "1px solid white";
        const params = new URLSearchParams();
        params.append('email', email);
        params.append('password', password);
        getUserAsync(params)
            .then(data => activeUser = data)
            .catch((error) => {
                console.log(error);
            });
        console.log(activeUser);
    }
}

async function getUserAsync(params) {
    let response = await fetch('login', {
        method: 'post',
        body: params
    });
    if (!response.ok) {
        let data = await response.json();
        throw Error(data.message);
    }
    return await response.json();
}