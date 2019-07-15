function onSearchButtonClicked() {
    let searchString = document.getElementById('searchInput').value;
    if (searchString !== '') {
        let params = new URLSearchParams();
        params.append('searchString', searchString);
        postAsync('protected/search', params)
            .then((data) => {
                let activeProfileList = data;
                console.log(data);
                document.getElementById("defaultOpen").click();
                createProfileTable(activeProfileList);
            })
            .catch((error) => {
                console.log(error);
            });
    }
}
