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
		<h2>Mon profil</h2>
		<p>Pseudo : ${utilisateur.pseudo}</p>
		<p>Nom : ${utilisateur.nom}</p>
		<p>Prénom : ${utilisateur.prenom}</p>
		<p>Email : ${utilisateur.email}</p>
		<p>Téléphone : ${utilisateur.telephone}</p>
		<p>Rue : ${utilisateur.rue}</p>
		<p>Code Postale : ${utilisateur.code_postal}</p>
		<p>Ville : ${utilisateur.ville}</p>
		<a href="modifierProfil"><button type="button">Modifier</button></a>
	</div>
</body>

</html>