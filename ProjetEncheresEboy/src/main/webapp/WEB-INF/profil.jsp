<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>eboy - Profil</title>
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
	
	<h1 class="jumbotron">Profil du vendeur</h1>
	
	<div class="jumbotron">
		<table>
			<tr>
				<td>Pseudo :</td>
				<td>${vendeur.pseudo}</td>
			</tr>
			<tr>
				<td>Nom :</td>
				<td>${vendeur.nom}</td>
			</tr>
			<tr>
				<td>Prénom :</td>
				<td>${vendeur.prenom}</td>
			</tr>
			<tr>
				<td>Email :</td>
				<td>${vendeur.email}</td>
			</tr>
			<tr>
				<td>Téléphone :</td>
				<td>${vendeur.telephone}</td>
			</tr>
			<tr>
				<td>Rue :</td>
				<td>${vendeur.rue}</td>
			</tr>
			<tr>
				<td>Code Postal :</td>
				<td>${vendeur.codePostal}</td>
			</tr>
			<tr>
				<td>Ville :</td>
				<td>${vendeur.ville}</td>
			</tr>
		</table>
	</div>
	<a href="<%=request.getContextPath()%>/accueil"><button type="button">Retour</button></a>
</body>

</html>