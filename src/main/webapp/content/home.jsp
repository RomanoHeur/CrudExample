<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>

    <jsp:attribute name="title">
        Home | CRUDExample
    </jsp:attribute>

    <jsp:attribute name="css">
        <link rel="stylesheet" href="<s:url value="/content/css/home.css" />"
    </jsp:attribute>

    <jsp:attribute name="content">

        <div class="container position-absolute translate-middle top-50 start-50">
            <div class="row">
                <div class="col"></div>

                <div class="col text-center">
                    <h1>Producten</h1>
                </div>

                <div class="col text-center">
                    <button class="btn btn-aanmaken" data-bs-toggle="modal" data-bs-target="#toevoegen">Product aanmaken</button>
                </div>
            </div>

            <div class="row text-center mt-3">
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th>Naam</th>
                            <th>Prijs</th>
                            <th>Beschrijving</th>
                            <th>Hoeveelheid</th>
                            <th>Acties</th>
                        </tr>
                    </thead>

                    <tbody>
                        <s:iterator value="products" var="product">
                            <tr class="table-row">
                                <td><s:property value="naam" /></td>
                                <td><s:property value="prijs" /></td>
                                <td><s:property value="beschrijving" /></td>
                                <td><s:property value="hoeveelheid" /></td>

                                <td class="text-center">
                                    <button class="btn btn-actie" data-bs-toggle="modal" data-bs-target="#bewerken" data-bs-id="<s:property value="id" />" data-bs-naam="<s:property value="naam" />" data-bs-prijs="<s:property value="prijs" />" data-bs-beschrijving="<s:property value="beschrijving" />" data-bs-hoeveelheid="<s:property value="hoeveelheid" />"><i class="bi bi-pencil-square"></i></button>
                                    <button class="btn btn-actie" data-bs-toggle="modal" data-bs-target="#verwijderen" onclick="verwijderProductId(<s:property value="id"/>)"><i class="bi bi-trash"></i></button>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Modal voor het aanmaken van een product -->
        <div class="modal generic-modal" tabindex="-1" id="toevoegen">
            <div class="modal-dialog">
                <div class="modal-content">

                    <form action="toevoegen" method="post">

                        <div class="modal-header">
                            <div class="col"></div>

                            <div class="col">
                                <h1>Toevoegen</h1>
                            </div>

                            <div class="col d-flex justify-content-end">
                                <button type="button"data-bs-dismiss="modal">
                                    X
                                </button>
                            </div>
                        </div>

                        <div class="modal-body">

                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="naam" id="naam" placeholder="Naam" required>
                                <label for="naam">naam</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="number" class="form-control" name="prijs" id="prijs" placeholder="Prijs" required>
                                <label for="prijs">Prijs</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="beschrijving" id="beschrijving" placeholder="Beschrijving" required>
                                <label for="beschrijving">Beschrijving</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="number" class="form-control" name="hoeveelheid" id="hoeveelheid" placeholder="Hoeveelheid" required>
                                <label for="hoeveelheid">Hoeveelheid</label>
                            </div>

                        </div>

                        <div class="modal-footer d-flex justify-content-center">
                            <button type="submit" class="btn mx-auto">
                                Aanmaken
                            </button>
                        </div>

                    </form>

                </div>
            </div>
        </div>

        <!-- Modal voor het bewerken van een product -->
        <div class="modal generic-modal" tabindex="-1" id="bewerken">
            <div class="modal-dialog">
                <div class="modal-content">

                    <form action="bewerken" method="post">

                        <div class="modal-header">
                            <div class="col"></div>

                            <div class="col">
                                <h1>Bewerken</h1>
                            </div>

                            <div class="col d-flex justify-content-end">
                                <button type="button"data-bs-dismiss="modal">
                                    X
                                </button>
                            </div>
                        </div>

                        <div class="modal-body">

                            <input type="hidden" name="id" id="bewerken-id">

                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="naam" id="bewerken-naam" placeholder="Naam" required>
                                <label for="bewerken-naam">naam</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="number" class="form-control" name="prijs" id="bewerken-prijs" placeholder="Prijs" required>
                                <label for="bewerken-prijs">Prijs</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="beschrijving" id="bewerken-beschrijving" placeholder="Beschrijving" required>
                                <label for="bewerken-beschrijving">Beschrijving</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="number" class="form-control" name="hoeveelheid" id="bewerken-hoeveelheid" placeholder="Hoeveelheid" required>
                                <label for="bewerken-hoeveelheid">Hoeveelheid</label>
                            </div>

                        </div>

                        <div class="modal-footer d-flex justify-content-center">
                            <button type="submit" class="btn mx-auto">
                                Bewerken
                            </button>
                        </div>

                    </form>

                </div>
            </div>
        </div>

        <!-- Modal voor het verwijderen van een product -->
        <div class="modal verwijder-modal" tabindex="-1" id="verwijderen">
            <div class="modal-dialog">
                <div class="modal-content">

                    <form action="verwijderen" method="post">

                        <div class="modal-header text-center">
                            <h1>Weet u zeker dat het product wilt verwijderen?</h1>
                        </div>

                            <input type="hidden" name="id" id="verwijderen-id">

                        <div class="modal-footer d-flex justify-content-between">
                            <button type="submit" class="btn btn-verwijderen mx-auto">
                                Verwijderen
                            </button>

                            <button type="button" data-bs-dismiss="modal" class="btn btn-annuleren mx-auto">
                                Annuleren
                            </button>
                        </div>

                    </form>

                </div>
            </div>
        </div>

    </jsp:attribute>

    <jsp:attribute name="script">
        <script src="content/js/home.js"></script>
    </jsp:attribute>

</t:template>