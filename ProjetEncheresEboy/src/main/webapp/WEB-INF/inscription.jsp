<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Eboy - Inscription</title>
<style>
body {
	text-align: center;
}

table {
	margin: auto;
}
</style>

</head>

<body>
	<h1>Eboy-Enchères</h1>

	<form action="<%=request.getContextPath()%>/ServletInscription"
		method="POST">
		<table id="TableInscription">
			<tbody>
				<h2>Mon profil</h2>
				<h4>${mdpPasIdentique}</h4>
				<tr>
					<td>Pseudo:</td>
					<td><input type="text" id="idpseudo" name="pseudo"
						minlength="1" maxlength="30" value='${pseudo}' required></td>
					<td>Nom:</td>
					<td><input type="text" id="idnom" name="nom" minlength="1"
						maxlength="30" value='${nom}' required></td>
				</tr>

				<tr>
					<td>Prenom:</td>
					<td><input type="text" id="idprenom" name="prenom"
						minlength="3" maxlength="30" value='${prenom}' required></td>
					<td>Email:</td>
					<td><input type="email" id="idemail" name="email"
						minlength="4" maxlength="50" value='${email}' required></td>
				</tr>

				<tr>
					<td>Telephone:</td>
					<td><input type="tel" id="idtel" name="telephone" min="10"
						max="15" value='${telephone}' required></td>
					<td>Rue:</td>
					<td><input type="text" id="idrue" name="rue" minlength="1"
						maxlength="30" value='${rue}' required></td>
				</tr>

				<tr>
					<td>Code Postal:</td>
					<td><input type="text" id="idcp" name="cp" minlength="1"
						maxlength="6" value='${codePostal}' required></td>
					<td>Ville:</td>
					<td><input type="text" id="idville" name="ville" minlength="1"
						maxlength="50" value='${ville}' required></td>
				</tr>

				<tr>
					<td>Mot de passe:</td>
					<td><input type="password" id="idmdp" name="mdp" minlength="3"
						maxlength="30" required></td>
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
</body>
</html>