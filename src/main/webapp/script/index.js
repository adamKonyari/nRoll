const OK = 200;
const BAD_REQUEST = 400;
const UNAUTHORIZED = 401;
const NOT_FOUND = 404;
const INTERNAL_SERVER_ERROR = 500;

let activeUser;
let loginDivEl;


function newMessage(targetEl, cssClass, message) {
    clearMessages();

    const pEl = document.createElement('p');
    pEl.classList.add('message');
    pEl.classList.add(cssClass);
    pEl.textContent = message;

    targetEl.appendChild(pEl);
}

function clearMessages() {
    const messageEls = document.getElementsByClassName('message');
    for (let i = 0; i < messageEls.length; i++) {
        const messageEl = messageEls[i];
        messageEl.remove();
    }
}

function showContents(ids) {
    const contentEls = document.getElementsByClassName('content');
    for (let i = 0; i < contentEls.length; i++) {
        const contentEl = contentEls[i];
        if (ids.includes(contentEl.id)) {
            contentEl.classList.remove('hidden');
        } else {
            contentEl.classList.add('hidden');
        }
    }
}

async function postAsync(url, params) {
    let response = await fetch(url, {
        method: 'post',
        body: params
    });
    if (!response.ok) {
        let data = await response.json();
        throw Error(data.message);
    }
    return await response.json();
}


document.addEventListener('DOMContentLoaded', () => {
    loginDivEl = document.getElementById('loginDiv');
    document.getElementById('login-button').addEventListener('click', onLoginButtonClicked);
    document.getElementById('searchButton').addEventListener('click', onSearchButtonClicked);
    document.getElementById('middleNameCheckbox').addEventListener('change', onMiddleNameChecked);
});