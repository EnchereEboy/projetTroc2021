/**
 * 
 */
package fr.eni.eboy.bo;

import java.io.Serializable;

/**
 * @author SIDY
 *
 */
public class Utilisateur implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer no_utilisateur; 
	private String pseudo;// 30 caractères maximum
	private String nom;// 30 caractères maximum
	private String prenom;// 30 caractères maximum
	private String email;// 50 caractères maximum
	private String telephone;// 15 caractères maximum optionnel
	private String rue;// 30 caractères maximum
	private String code_postal;// 10 caractères maximum
	private String ville;// 50 caractères maximum
	private String mot_de_passe;// 30 caractères maximum
	private Integer credit;
	private boolean administrateur;
	
	
	public Integer getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(Integer no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
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
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Utilisateur [no_utilisateur=" + no_utilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", code_postal="
				+ code_postal + ", ville=" + ville + ", mot_de_passe=" + mot_de_passe + ", credit=" + credit
				+ ", administrateur=" + administrateur + "]";
	}
	public Utilisateur(){
		
	}
	
	public Utilisateur(Integer no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, Integer credit, boolean administrateur) {
		this();
		setNo_utilisateur(no_utilisateur);
		setPseudo(pseudo);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setTelephone(telephone);
		setRue(rue);
		setCode_postal(code_postal);
		setVille(ville);
		setMot_de_passe(mot_de_passe);
		setCredit(credit);
		setAdministrateur(administrateur);
	}

	
		

}