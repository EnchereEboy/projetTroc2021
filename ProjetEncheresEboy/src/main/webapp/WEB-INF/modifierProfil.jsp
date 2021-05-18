<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>eboy - Modifier mon profil</title>
	<!-- Bootstrap core CSS -->
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="css/4-col-portfolio.css" rel="stylesheet">
	<style type="text/css">
		#container1 {
			text-align: center;
		}
		
		#form_gauche {
			float: left;
			width: 50%;
		}
				
		#container2 {
			clear: left;
		}			
	</style>
</head>

<body class="container">
	<h2>ENI-Enchères</h2>
	
	<h1 class="jumbotron">Modifier mon profil</h1>
	
	<div class="jumbotron">
		<div id="container1">
			<form action="modifierProfil" method="post">
		      <div id="form_gauche">
		        <label for="pseudo">Pseudo : </label>
		        <input type="text" id="pseudo" name="pseudo" value="${userUpdate.pseudo}" size="20" maxlength="30">
		        <br>
		        <label for="prenom">Prénom : </label>
		        <input type="text" id="prenom" name="prenom" value="${userUpdate.prenom}" pattern=".{1,30}.[A-Za-z -]" size="20" maxlength="30">
		        <br>
		        <label for="telephone">Téléphone : </label>
		        <input type="text" id="telephone" name="telephone" value="${userUpdate.telephone}" pattern=".{8}.[0-9]" size="20" maxlength="20">
		        <br>
		        <label for="codePostal">Code Postal : </label>
		        <input type="text" id="codePostal" name="codePostal" value="${userUpdate.codePostal}" pattern=".{3}.[0-9]" size="20" maxlength="20">
		        <br>
		        <label for="motDePasse">Mot de passe actuel : </label>
		        <input type="password" id="motDePasse" name="motDePasse" required="required" size="20" maxlength="20">
		        <br>
		        <label for="nouveauMotDePasse">Nouveau mot de passe : </label>
		        <input type="password" id="nouveauMotDePasse" name="nouveauMotDePasse" size="20" maxlength="20" required>
		      </div>
	
		      <div id="form_droite">
		        <label for="nom">Nom : </label>
		        <input type="text" id="nom" name="nom" value="${userUpdate.nom}" pattern=".{1,30}.[A-Za-z -]" size="20" maxlength="30">
		        <br>
		        <label for="email">Email : </label>
		        <input type="email" id="email" name="email" value="${userUpdate.email}" size="20" maxlength="60">
		        <br>
		        <label for="rue">Rue : </label>
		        <input type="text" id="rue" name="rue" value="${userUpdate.rue}" size="20" maxlength="120">
		        <br>
		        <label for="ville">Ville : </label>
		        <input type="text" id="ville" name="ville" value="${userUpdate.ville}" pattern=".{1,50}.[A-Za-z -]" size="20" maxlength="20">
		        <br><br>
		        <label for="confirmationMotDePasse">Confirmation : </label>
		        <input type="password" id="confirmationMotDePasse" name="confirmationMotDePasse" size="20" maxlength="20" required>
		      </div>
	      
		      <div id="container2">
		      	<p>Crédit :	${userUpdate.credit}</p>
		        <br>
				<button type="submit">Enregistrer</button>
				<a href="<%=request.getContextPath()%>/suppressionCompte?id=$(utilisateur.numero)"><button>Supprimer mon compte</button></a>
		      </div>
		            
	  		</form>
		</div>
	</div>

</body>
</html>