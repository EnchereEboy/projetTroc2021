<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eboy - Connexion</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/4-col-portfolio.css" rel="stylesheet">
<style>
	table {
		margin: auto;
	}
	
	.centre {
		text-align: center;
	}
</style>
</head>

<body class="container">
	<a href="<%=response.encodeRedirectURL(request.getContextPath() + "/accueil")%>"><h3>ENI-Enchères</h3></a>

	<h3>${messageUser}</h3>
	<br>
	<h1 class="jumbotron">Connexion</h1>
	
	<div class="jumbotron">
		<form action="<%=request.getContextPath()%>/ServletConnexion"
			method="POST">
	
			<table id="MaTable" style="text-align: center">
				<tbody>
					<tr>
						<td>Identifiant :</td>
						<td><input type="text" id="ididentifiant" name="id" required></td>
					</tr>
	
					<tr>
						<td>Mot de passe :</td>
						<td><input type="password" id="idmdp" name="mdp" required></td>
					</tr>
	
					<tr>
						<td rowspan="2"><input type="submit" id="connexion"
							value="Connexion"></td>
	
	
						<td colspan="2"><input type="checkbox" id="idsouvenir"
							name="souvenir">Se souvenir de moi
						<td>
					</tr>
	
					<td><a href="">Mot de passe oublié</a></td>
	
				</tbody>
			</table>
		</form>

		<div class="centre">
			<form action="<%=request.getContextPath()%>/ServletInscription"
				method="GET">
				<input type="submit" name="creer" id="creer" value="Créer un compte">
			</form>
		</div>
	</div>

</body>
</html>