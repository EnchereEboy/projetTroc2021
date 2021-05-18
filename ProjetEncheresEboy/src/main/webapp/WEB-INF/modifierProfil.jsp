<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>eboy - Modifier mon profil</title>
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

<body>
	<h1>Enchères-eboy</h1>
	<div id="container1">
		<h2>Modifier mon profil</h2>
		<form action="modifierProfil" method="post">
	      <div id="form_gauche">
	        <label for="pseudo">Pseudo : </label>
	        <input type="text" id="pseudo" name="pseudo" value="${utilisateur.pseudo}">
	        <br>
	        <label for="prenom">Prénom : </label>
	        <input type="text" id="prenom" name="prenom" value="${utilisateur.prenom}">
	        <br>
	        <label for="telephone">Téléphone : </label>
	        <input type="text" id="telephone" name="telephone" value="${utilisateur.telephone}">
	        <br>
	        <label for="codePostal">Code Postal : </label>
	        <input type="text" id="codePostal" name="codePostal" value="${utilisateur.codePostal}">
	        <br>
	        <label for="motDePasse">Mot de passe actuel : </label>
	        <input type="password" id="motDePasse" name="motDePasse">
	        <br>
	        <label for="nouveauMotDePasse">Nouveau mot de passe : </label>
	        <input type="password" id="nouveauMotDePasse" name="nouveauMotDePasse">
	      </div>

	      <div id="form_droite">
	        <label for="nom">Nom : </label>
	        <input type="text" id="nom" name="nom" value="${utilisateur.nom}">
	        <br>
	        <label for="email">Email : </label>
	        <input type="email" id="email" name="email" value="${utilisateur.email}">
	        <br>
	        <label for="rue">Rue : </label>
	        <input type="text" id="rue" name="rue" value="${utilisateur.rue}">
	        <br>
	        <label for="ville">Ville : </label>
	        <input type="text" id="ville" name="ville" value="${utilisateur.ville}">
	        <br><br>
	        <label for="confirmationMotDePasse">Confirmation : </label>
	        <input type="password" id="confirmationMotDePasse" name="confirmationMotDePasse">
	      </div>
      
	      <div id="container2">
	      	<p>Crédit :	${credit}</p>
	        <br>
			<input type="submit" value="Enregistrer">
		    <input type="reset" value="Supprimer mon compte">
	      </div>
      
  		</form>
	</div>

</body>
</html>