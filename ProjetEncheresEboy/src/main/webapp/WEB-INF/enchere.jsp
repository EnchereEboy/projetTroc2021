<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchere en cours EBoy</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/4-col-portfolio.css" rel="stylesheet">
</head>

<body class="container">
	<a href="<%=response.encodeRedirectURL(request.getContextPath() + "/accueil")%>"><h3>ENI-Enchères</h3></a>
	<br>
	<h1 class="jumbotron">Détail vente</h1>

	<c:if test="${!empty article} ">
		<c:forEach var="a" items="${article }">
			<div id="a" class="row">
				<div class="card">
					<div class="card-body">
						<h3>${a.nom }</h3>
						<br> <br>
						<div>
							<p>Description : ${a.description}</p>
						</div>
						<!-- Div du bloc Description et de la boite de texte -->
						<br> <br>
						<p>Catégorie : ${a.categorie.libelle }</p>
						<br> <br>
						<p>Meilleur offre : ${a.prixVente } pts par</p>
						<br> <br>
						<p>Mise à prix : ${a.prixInitial } points</p>
						<br> <br>
						<p>Fin de l'enchère : ${a.dateFinEncheres }</p>
						<br> <br>
						<div>
							<!-- Div Bloc de l'adresse de retrait -->
							<p>Retrait : ${a.utilisateur.ville }
						</div>
						<br> <br>
						<p>Vendeur : ${a.utilisateur.pseudo }</p>
						<br> <br>
						<p>Ma proposition :</p>
						<form action="" method="POST"></form>
						<input type="number" id="enchereProposition"
							name="enchereProposition"> <input type="submit"
							name="enchereProposition">
					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>
	<div id="a" class="row">
		<div class="card">
			<div class="card-body">
				<h3>${article.nom }</h3>
				<br> <br>
				<div>
					<p>Description : ${article.description}</p>
				</div>
				<!-- Div du bloc Description et de la boite de texte -->
				<br> <br>
				<p>Catégorie : ${article.categorie.libelle }</p>
				<br> <br>
				<p>Meilleur offre : ${article.prixVente } pts par
					${enchere.utilisateur.pseudo }</p>
				<br> <br>
				<p>Mise à prix : ${article.prixInitial } points</p>
				<br> <br>
				<p>Fin de l'enchère : ${article.dateFinEncheres }</p>
				<br> <br>
				<div>
					<!-- Div Bloc de l'adresse de retrait -->
					<p>Retrait : ${article.utilisateur.ville }
				</div>
				<br> <br>
				<p>Vendeur : ${article.utilisateur.pseudo }</p>
				<br> <br>
				<p>Ma proposition :</p>
				<form action="" method="POST"></form>
				<input type="number" id="enchereProposition"
					name="enchereProposition"> <input type="submit"
					name="enchereProposition" value="Enchérir">
			</div>
		</div>
	</div>


</body>
</html>