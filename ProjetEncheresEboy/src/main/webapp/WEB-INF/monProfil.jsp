<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>eboy - Mon Profil</title>
	<!-- Bootstrap core CSS -->
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="css/4-col-portfolio.css" rel="stylesheet">
	<style type="text/css">
		table{
			margin:auto;
		}
		
		td {
			text-align: left;
			width: 100px;
		}		
	</style>
</head>

<body class="container">
	<h2>ENI-Enchères</h2>
	<br>
	
	<h1 class="jumbotron">Mon profil</h1>
	
	<div class="jumbotron">
		<table>
			<tr>
				<td>Pseudo :</td>
				<td>${utilisateur.pseudo}</td>
			</tr>
			<tr>
				<td>Nom :</td>
				<td>${utilisateur.nom}</td>
			</tr>
			<tr>
				<td>Prénom :</td>
				<td>${utilisateur.prenom}</td>
			</tr>
			<tr>
				<td>Email :</td>
				<td>${utilisateur.email}</td>
			</tr>
			<tr>
				<td>Téléphone :</td>
				<td>${utilisateur.telephone}</td>
			</tr>
			<tr>
				<td>Rue :</td>
				<td>${utilisateur.rue}</td>
			</tr>
			<tr>
				<td>Code Postal :</td>
				<td>${utilisateur.codePostal}</td>
			</tr>
			<tr>
				<td>Ville :</td>
				<td>${utilisateur.ville}</td>
			</tr>
		</table>
	</div>
	<a href="<%=request.getContextPath()%>/accueil"><button type="button">Retour</button></a>
	<a href="<%=request.getContextPath()%>/modifierProfil?id=${utilisateur.numero}"><button type="button">Modifier</button></a>
</body>

</html>