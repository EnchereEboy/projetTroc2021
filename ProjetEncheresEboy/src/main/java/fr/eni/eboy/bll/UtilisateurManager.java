package fr.eni.eboy.bll;

import fr.eni.eboy.bo.Utilisateur;
import fr.eni.eboy.dal.DaoFactory;
import fr.eni.eboy.dal.UtilisateurDao;

public class UtilisateurManager {
	private UtilisateurDao utilisateurDao;
	
	public UtilisateurManager() {
		utilisateurDao = DaoFactory.getUtilisateurDao();
	}
	
	public Utilisateur insertConnection(String pseudo, String motDePasse) {
		return DaoFactory.getUtilisateurDao().insertConnection(pseudo,motDePasse);
	}

	public Utilisateur insert(Utilisateur nouveauUser) {
		
		//Utilisateur nouvelUtilisateur = new Utilisateur(pseudo,prenom,telephone,codePostal,motDePasse,nom,email,rue,ville);
		
		//J'appelle la DAO, je fais la méthode insert et le tout me renvoie les info du nouvel inscrit
		return DaoFactory.getUtilisateurDao().insert(nouveauUser);
	}
	public Utilisateur retournerUtilisateur(String pseudo) {
		return utilisateurDao.selectByPseudo(pseudo);
	}
	
	public Utilisateur retournerUtilisateurParId(Integer numero) {
		return utilisateurDao.selectById(numero);
	}
	
	public void modificationUtilisateur(Utilisateur utilisateur) {
		this.utilisateurDao.update(utilisateur);
	}
	
	public int supprimerUtilisateur(Integer numero) {
		return this.utilisateurDao.delete(numero);
	}
	
	public int debiter(int idUser, int montantPropose) {
		return this.utilisateurDao.debiterUser(idUser, montantPropose);
	}
	
	
	public int crediter (int idArticle) {
		return utilisateurDao.crediterUser(idArticle);
	}
	
	
}
