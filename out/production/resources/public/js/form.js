const HOMEPAGE = "http://localhost:8080/beerlist";
const form = document.getElementById("edit-beer");
const deleteButton = document.getElementById("deleteBeer");

deleteButton.addEventListener("click", (ev) => {
    fetch(form.action, {
    method: "DELETE"
}).then(() => {
    window.location = HOMEPAGE;
});
});

form.addEventListener("submit", (ev) => {
    ev.preventDefault();
console.log(ev.target.method, ev.target.action);

const inputs = ev.target.getElementsByTagName("input");
const name = inputs[0].value;
const abv = inputs[1].value;
const beer = {name, abv};
const body = JSON.stringify(beer);

fetch(ev.target.action, {
    method: ev.target.getAttribute("method"),
    body: body
}).then(() => {
    window.location = HOMEPAGE;
});
})