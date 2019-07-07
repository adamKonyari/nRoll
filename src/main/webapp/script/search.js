function onSearchButtonClicked() {
    let searchString = document.getElementById('searchInput').value;
    if (searchString !== '') {
        let params = new URLSearchParams();
        params.append('searchString', searchString);
        postAsync('protected/search', params)
            .then((data) => {
                let profileList = data;
                document.getElementById("defaultOpen").click();
            })
            .catch((error) => {
                console.log(error);
            });
    }
}
