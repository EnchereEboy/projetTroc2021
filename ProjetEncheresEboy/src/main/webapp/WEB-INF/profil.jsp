<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>eboy - Profil</title>
	<style type="text/css">
		#container {
			text-align: center;
		}
	</style>
</head>

<body>
	<h1>Enchères-eboy</h1>

	<div id="container">
		<p>Pseudo : ${vendeur.pseudo}</p>
		<p>Nom : ${vendeur.nom}</p>
		<p>Prénom : ${vendeur.prenom}</p>
		<p>Email : ${vendeur.email}</p>
		<p>Téléphone : ${vendeur.telephone}</p>
		<p>Rue : ${vendeur.rue}</p>
		<p>Code Postale : ${vendeur.codePostal}</p>
		<p>Ville : ${vendeur.ville}</p>		
	</div>
</body>

</html>