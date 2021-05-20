<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eboy - Inscription</title>
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
	<a
		href="<%=response.encodeRedirectURL(request.getContextPath() + "/accueil")%>"><h3>ENI-Enchères</h3></a>
	<br>
	<h1 class="jumbotron">Inscription</h1>

	<div class="jumbotron">
		<div class="centre">
			<form action="<%=request.getContextPath()%>/ServletInscription"
				method="POST">
				<table id="TableInscription">
					<tbody>
						<h4>${mdpPasIdentique}</h4>
						<tr>
							<td>Pseudo:</td>
							<td><input type="text" id="idpseudo" name="pseudo"
								minlength="1" maxlength="30" value='${pseudo}' required></td>
							<td>Nom:</td>
							<td><input type="text" id="idnom" name="nom" minlength="1"
								maxlength="30" value='${nom}' pattern=".{1,30}.[A-Za-z -]"
								required></td>
						</tr>

						<tr>
							<td>Prenom:</td>
							<td><input type="text" id="idprenom" name="prenom"
								minlength="3" maxlength="30" value='${prenom}'
								pattern=".{1,30}.[A-Za-z -]" required></td>
							<td>Email:</td>
							<td><input type="email" id="idemail" name="email"
								minlength="4" maxlength="50" value='${email}' required></td>
						</tr>

						<tr>
							<td>Telephone:</td>
							<td><input type="tel" id="idtel" name="telephone" min="10"
								max="15" value='${telephone}' pattern=".{8}.[0-9]" required></td>
							<td>Rue:</td>
							<td><input type="text" id="idrue" name="rue" minlength="1"
								maxlength="30" value='${rue}' required></td>
						</tr>

						<tr>
							<td>Code Postal:</td>
							<td><input type="text" id="idcp" name="cp" minlength="1"
								maxlength="6" value='${codePostal}' pattern=".{3}.[0-9]"
								required></td>
							<td>Ville:</td>
							<td><input type="text" id="idville" name="ville"
								minlength="1" maxlength="50" value='${ville}'
								pattern=".{1,50}.[A-Za-z -]" required></td>
						</tr>

						<tr>
							<td>Mot de passe:</td>
							<td><input type="password" id="idmdp" name="mdp"
								minlength="3" maxlength="30" required></td>
							<td>Confirmation:</td>
							<td><input type="password" id="idmdpconfirmation"
								name="mdpconfirmation" minlength="3" maxlength="30" required></td>
						</tr>
						<input type=hidden name='keyUser' value='${idUserSession}'>
						<tr>
							<td colspan="2" class="button"><input type="submit"
								value="Créer"></td>
							<td colspan="2" class="button"><a
								href="<%=response.encodeRedirectURL(request.getContextPath() + "/index")%>"><input
									type="button" value="Annuler"></a></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>