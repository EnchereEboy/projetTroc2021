package fr.eni.eboy.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant l'objet utilisateur
 * @author sboussoukou2021
 */
public class Utilisateur implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer numero; 
	private String pseudo;// 30 caractères maximum
	private String nom;// 30 caractères maximum
	private String prenom;// 30 caractères maximum
	private String email;// 50 caractères maximum
	private String telephone;// 15 caractères maximum optionnel
	private String rue;// 30 caractères maximum
	private String codePostal;// 10 caractères maximum
	private String ville;// 50 caractères maximum
	private String motDePasse;// 30 caractères maximum
	private Integer credit;
	private boolean administrateur;
	
	private List<Article> listeArticles = new ArrayList<Article>();
	private List<Enchere> listeEncheres = new ArrayList<Enchere>();
	
	public Utilisateur() {
	}
	
	public Utilisateur(Integer numero, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur,
			List<Article> listeArticles, List<Enchere> listeEncheres) {
		this();
		setNumero(numero);
		setPseudo(pseudo);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setTelephone(telephone);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setMotDePasse(motDePasse);
		setCredit(credit);
		setAdministrateur(administrateur);
		setListeArticles(listeArticles);
		setListeEncheres(listeEncheres);
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getRue() {
		return rue;
	}
	
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public Integer getCredit() {
		return credit;
	}
	
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	public boolean isAdministrateur() {
		return administrateur;
	}
	
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
	
	public List<Article> getListeArticles() {
		return listeArticles;
	}
	
	public void setListeArticles(List<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}
	
	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}
	
	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	@Override
	public String toString() {
		return "Utilisateur [numero=" + numero + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit + ", administrateur="
				+ administrateur + ", listeArticles=" + listeArticles + ", listeEncheres=" + listeEncheres + "]";
	}
}
