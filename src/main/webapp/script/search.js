function onSearchButtonClicked() {
    let searchString = document.getElementById('searchInput').value;
    if (searchString !== '') {
        let params = new URLSearchParams();
        params.append('searchString', searchString);
        postAsync('protected/search', params)
            .then((data) => {
                let profileList = data;
                console.log(data);
                document.getElementById("defaultOpen").click();
                createProfileTable(profileList);
            })
            .catch((error) => {
                console.log(error);
            });
    }
}
