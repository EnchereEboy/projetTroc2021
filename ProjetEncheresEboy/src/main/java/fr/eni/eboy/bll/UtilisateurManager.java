package fr.eni.eboy.bll;

import fr.eni.eboy.bo.Utilisateur;
import fr.eni.eboy.dal.DaoFactory;
import fr.eni.eboy.dal.UtilisateurDao;

public class UtilisateurManager {
	private UtilisateurDao utilisateurDao;
	
	public UtilisateurManager() {
		utilisateurDao = DaoFactory.getUtilisateurDao();
	}
	
	public Utilisateur retournerUtilisateur(String pseudo) {
		return utilisateurDao.selectByPseudo(pseudo);
	}
	
	public Utilisateur retournerUtilisateurParId(Integer numero) {
		return utilisateurDao.selectById(numero);
	}
	
	public void modificationUtilisateur(Utilisateur utilisateur) {
		this.utilisateurDao.modifierUtilisateur(utilisateur);
	}
}
