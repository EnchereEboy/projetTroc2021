package fr.eni.eboy.dal;

import fr.eni.eboy.bo.Utilisateur;

public interface UtilisateurDao {

	Utilisateur insertConnection(String pseudo , String password);
	
	Utilisateur insert(Utilisateur utilisateur);

	public Utilisateur selectByPseudo(String pseudo);

	public Utilisateur selectById(Integer numero);

	public void modifierUtilisateur(Utilisateur utilisateur);

}
