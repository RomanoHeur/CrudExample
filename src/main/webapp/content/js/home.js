const bewerken = document.getElementById('bewerken');

bewerken.addEventListener('show.bs.modal', function (Event) {

    let button = event.relatedTarget;

    let id = button.getAttribute('data-bs-id');
    let naam = button.getAttribute('data-bs-naam');
    let prijs = button.getAttribute('data-bs-prijs');
    let beschrijving = button.getAttribute('data-bs-beschrijving');
    let hoeveelheid = button.getAttribute('data-bs-hoeveelheid');

    let idInput = document.getElementById('bewerken-id');
    let naamInput = document.getElementById('bewerken-naam');
    let prijsInput = document.getElementById('bewerken-prijs');
    let beschrijvingInput = document.getElementById('bewerken-beschrijving');
    let hoeveelheidInput = document.getElementById('bewerken-hoeveelheid');

    idInput.value = id;
    naamInput.value = naam;
    prijsInput.value = prijs;
    beschrijvingInput.value = beschrijving;
    hoeveelheidInput.value = hoeveelheid;
});

function verwijderProductId(productId) {
    document.getElementById('verwijderen-id').value = productId;
}
