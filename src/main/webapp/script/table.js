function sortTable(table, cellIndex, isAscending) {
    sortElements([].slice.call(table.rows, 1), function (r1, r2) {
        return compareRows(cellIndex, isAscending, r1, r2);
    });
}

function sortElements(elements, sortFn) {
    if (!elements instanceof Array) {
        elements = toArray(elements);
    }
    let parent = elements[0].parentNode;
    elements = elements.sort(sortFn);
    for (let i = 0; i < elements.length; i++) {
        parent.appendChild(elements[i]);
    }
}

function compareRows(cellIndex, isAscending, r1, r2) {
    let sortOperator = isAscending ? 1 : -1;
    let s1 = getText(r1.cells[cellIndex]).toLowerCase();
    let s2 = getText(r2.cells[cellIndex]).toLowerCase();
    let n1 = parseFloat(s1);
    let n2 = parseFloat(s2);
    let d1 = new Date(s1);
    let d2 = new Date(s2);
    if (!isNaN(d1) && !isNaN(d2)) {
        s1 = d1.valueOf();
        s2 = d2.valueOf();
    } else if (!isNaN(n1) && !isNaN(n2)) {
        s1 = n1;
        s2 = n2;
    }
    let result = s1 > s2 ? 1 : s1 < s2 ? -1 : 0;
    return sortOperator * result;
}

function toArray(list) {
    if (list instanceof Array) return list;
    let a = [];
    for (let i = 0; i < list.length; i++) {
        a.push(list[i]);
    }
    return a;
}

function getText(el) {
    let text = "";
    for (let i = 0; el && el.childNodes && i < el.childNodes.length; i++) {
        let node = el.childNodes[i];
        text += node.nodeType == 3 ? node.data : getText(node);
    }
    return text;
}

function createProfileTable(profileList) {
    document.getElementById('searchResultDiv').style.display = 'block';
    document.getElementById('profileDisplayDiv').style.display = 'none';
    let searchDivEl = document.getElementById("searchResultDiv");
    searchDivEl.removeChild(searchDivEl.firstChild);
    let table = document.createElement("table");
    table.setAttribute("id", "profileResultTable");
    let thead = document.createElement("thead");
    let tr = thead.insertRow(-1);
    const tableHeaderTitles = [
        "First name",
        "Last name",
        "Email",
        "Date of birth",
        "Tax number",
        "Gender"
    ];
    for (let i = 0; i < tableHeaderTitles.length; i++) {
        var th = document.createElement("th");
        th.innerHTML = tableHeaderTitles[i];
        tr.appendChild(th);
    }
    let tbody = document.createElement("tbody");
    profileList.forEach(forEachProfile);

    function forEachProfile(profile) {
        tr = tbody.insertRow(-1);
        let firstName = tr.insertCell(-1);
        firstName.innerHTML = profile.firstName;
        let lastName = tr.insertCell(-1);
        lastName.innerHTML = profile.lastName;
        let email = tr.insertCell(-1);
        email.innerHTML = profile.email;
        let dateOfBirth = tr.insertCell(-1);
        let dob = profile.dateOfBirth;
        dateOfBirth.innerHTML = dob;
        let taxNumber = tr.insertCell(-1);
        taxNumber.innerHTML = profile.taxNumber;
        let gender = tr.insertCell(-1);
        gender.innerHTML = profile.gender;
        tr.setAttribute('profile', JSON.stringify(profile));
        tr.addEventListener('click', onProfileClicked);
        tbody.appendChild(tr);
    }

    table.appendChild(thead);
    table.appendChild(tbody);
    table.rows[0].onclick = e => {
        e = e || window.event;
        let target = e.target || e.srcElement;
        target.sortDir = target.sortDir == "a" ? "d" : "a";
        sortTable(table, target.cellIndex, target.sortDir == "a");
    };
    let divContainer = document.getElementById("searchResultDiv");
    divContainer.appendChild(table);
}
