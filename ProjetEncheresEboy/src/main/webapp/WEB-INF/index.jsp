 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceuil EBoy</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/4-col-portfolio.css" rel="stylesheet">


</head>
<body class="container">
	
	<a href="<%=response.encodeRedirectURL(request.getContextPath() + "/accueil")%>"><h3>ENI-Enchères</h3></a>
	<br>
<c:choose>
    <c:when test="${empty idUser}">
        <a href="<%=response.encodeRedirectURL(request.getContextPath() + "/ServletConnexion")%>">S'inscrire
			- Se connecter</a>
		<br> 
    </c:when>
    <c:otherwise>
         <br>  
		 <a href="<%=response.encodeRedirectURL(request.getContextPath() + "/enchere")%>">Encheres</a>  
		 <a href="<%=response.encodeRedirectURL(request.getContextPath() + "/NouvelleVente")%>">Vendre un article</a>  
		 <a href="<%=request.getContextPath()%>/monProfil?id=${idUser}">Mon profil</a>  
		 
		 <a href="<%=response.encodeRedirectURL(request.getContextPath() + "/ServletDisconnect")%>">Deconnexion</a>	   
 		<br> 
    </c:otherwise>
</c:choose>
	<h3>${msgDeconnexion}</h3>
	<br>
	<h1 class="jumbotron">Liste des enchères</h1>

	<div class="jumbotron">
		<form method="post">
			<div>
				<label for="recherche">Filtre :</label> 
				<input type="text" name="recherche">
				<input type="submit" name="recherche" value="Recherche">
			</div>
			<div>
				<label for="categorie">Catégorie :</label> <select name="categorie">
					<option value=0 selected>Toutes</option>
					<option value=1>Informatique</option>
					<option value=2>Ameublement</option>
					<option value=3>Vêtement</option>
					<option value=4>Sport&Loisirs</option>
				</select>
			</div>
		</form>
	</div>


	<c:if test="${!empty articles}">
		<c:forEach var="a" items="${articles }">

			<div id="a" class="row">
				<div class="col-md-4">
					<div class="card">
						<div class="card-body">
							<h3>${a.nom }<a href=' <c:url value=" ./enchere?id=${a.numero } "/> '> ${a.nom }</a></h3>
							<br> <br>
							<p>Prix : ${a.prixVente } points</p>
							<br>
							<p>Fin de l'enchère : ${a.dateFinEncheres }</p>
							<br> <br>
							<p>Vendeur : <a href=' <c:url value=" ./profil?id=${a.utilisateur.numero } "/> '> ${a.utilisateur.pseudo}</a> </p>
						</div>
					</div>

				</div>
			</div>

		</c:forEach>

	</c:if>



</body>
</html>