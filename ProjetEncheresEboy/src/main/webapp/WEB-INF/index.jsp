<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceuil EBoy</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/4-col-portfolio.css" rel="stylesheet">
<script src="vendor/jsThomas.js"></script> 
</head>

<body class="container" onfocus="delay()"   onload = "oncheckedAll()">
	
	<a href="<%=response.encodeRedirectURL(request.getContextPath() + "/accueil")%>"><h3>ENI-Enchères</h3></a>
	<br>
<c:choose>
    <c:when test="${empty idUser}">
        <a href="<%=response.encodeRedirectURL(request.getContextPath() + "/ServletConnexion")%>">S'inscrire - Se connecter</a>
		<br> 
    </c:when>
    <c:otherwise>
         <br>  
		 <a href="<%=response.encodeRedirectURL(request.getContextPath() + "/enchere")%>">Encheres</a>    
		  <a href="<%=request.getContextPath()%>/vente?id=${idUser}">Vendre un article</a> 
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
		<!-- 		debut partie recherche	 -->	
		<c:if test="${!empty idUser}">
				<div>
				<div class="line">
					<input type="radio" name="optionConnectee" value="achats"
						id="achats" onclick="unGreyMeGreyOther(0)" checked> <label>Achats</label>
					<ul class="liste" id="listeAchat">
						<li><input type="checkbox" name="enchereOuverte" value="true"
							id="enchereOuverte" checked> <label>enchères
								ouvertes</label></li>
						<li><input type="checkbox" name="enchereUtilisateur"
							value="true" id="enchereUtilisateur" checked> <label>mes
								enchères</label></li>
						<li><input type="checkbox" name="enchereGagnee" value="true"
							id="enchereGagnee" checked> <label>mes enchères
								remportées</label></li>
					</ul>
				</div>
				<div class="line" >
					<input type="radio" name="optionConnectee" value="ventes" id="ventes"
						onclick="unGreyMeGreyOther(1)" checked> <label>Mes
						Ventes</label>
					<ul class="liste" id="listeVente">
						<li><input type="checkbox" name="ventesOuverte" value="true"
							id="ventesOuverte" checked> <label>mes ventes en
								cours</label></li>
						<li><input type="checkbox" name="venteNonDebutee" value="true"
							id="venteNonDebutee" checked> <label>ventes non
								débutées</label></li>
						<li><input type="checkbox" name="venteTerminee" value="true"
							id="venteTerminee" checked> <label>ventes
								teminées</label></li>
					</ul>
				</div>
			</div>
			</c:if>
<!-- 		fin partie recherche	 -->
			
		</form>
	</div>


	<c:if test="${!empty articles}">
		<c:forEach var="a" items="${articles }">

			<div id="a" class="row">
				<div class="col-md-4">
					<div class="card">
						<div class="card-body">
						    <c:if test="${!empty idUser}">
							   <h3><a href=' <c:url value=" ./enchere?id=${a.numero } "/> '> ${a.nom }</a></h3>
							</c:if>
							 <c:if test="${empty idUser}">
							   <h3>${a.nom }</h3>
							</c:if>
							<br> <br>
							<p>Prix : ${a.prixVente } points</p>
							<br>
							<p>Fin de l'enchère : ${a.dateFinEncheres }</p>
							<br> <br>
							<c:if test="${!empty idUser}">
							 <p>Vendeur : <a href=' <c:url value=" ./profil?id=${a.utilisateur.numero } "/> '> ${a.utilisateur.pseudo}</a> </p>
							</c:if>
							<c:if test="${empty idUser}">
							  <p>Vendeur :  ${a.utilisateur.pseudo} </p>
							</c:if>
						</div>
					</div>

				</div>
			</div>

		</c:forEach>

	</c:if>



</body>
</html>