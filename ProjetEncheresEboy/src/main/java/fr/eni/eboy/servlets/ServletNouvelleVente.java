package fr.eni.eboy.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.eboy.bll.ArticleManager;
import fr.eni.eboy.bll.CategorieManager;
import fr.eni.eboy.bll.UtilisateurManager;
import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Categorie;
import fr.eni.eboy.bo.Retrait;
import fr.eni.eboy.bo.Utilisateur;
/**
 * Servlet implementation class NouvelleVente
 */
@WebServlet({ "/NouvelleVente", "/vente" })
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
//private static final DateTimeFormatter formatJourMoisAnneeHeureMinute = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private static final DateTimeFormatter formatBDDVersJavaLocalDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getServletPath().equals("/vente")) {
			String idUser1 = request.getParameter("id");
			  if(idUser1!=null){
	    	System.out.println(request.getParameter("idUser"));
			    
		    try{   
		    	Integer idUser = Integer.parseInt(idUser1); 
				UtilisateurManager utilisateurManager = new UtilisateurManager();
				Utilisateur user = new Utilisateur();
		    	    user = utilisateurManager.retournerUtilisateurParId(idUser);
		    		request.setAttribute("user", user);
					System.out.println(user);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/articleNouveau.jsp");
				    rd.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
		 }else{
			 System.out.println("sans identifiant");
			 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/articleNouveau.jsp");
			 rd.forward(request, response);
		 }
		}else if(request.getServletPath().equals("/NouvelleVente")) {
			System.out.println("sans identifiant");
		 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/articleNouveau.jsp");
		 rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //recuperation des champs du formulaire
		HttpSession sessionEncheres = request.getSession();
		int id = (Integer) sessionEncheres.getAttribute("idUser");
		String nomArticle=request.getParameter("article");
		String descritionArticle=request.getParameter("description");  
		Integer noCategorie=Integer.parseInt(request.getParameter("categorie"));
		Categorie categorie = new CategorieManager().selectById(noCategorie);
		System.out.println(sessionEncheres.getAttribute("idUser"));
		Integer noUtilisateur=(Integer) sessionEncheres.getAttribute("idUser");
		Utilisateur utilisateur = new UtilisateurManager().retournerUtilisateurParId(noUtilisateur);
		Integer prixInitial= Integer.parseInt(request.getParameter("miseaprix"));
		
		String dateDebutEnchere1=request.getParameter("datedebutenchere");
		String heureDebutEnchere1=request.getParameter("heuredebutenchere");
		String dateDebutEnchere01=dateDebutEnchere1+" "+heureDebutEnchere1; 
		System.out.println("qsdqds ---- "+dateDebutEnchere01);
		LocalDateTime dateDebutEnchere=LocalDateTime.parse(dateDebutEnchere01,formatBDDVersJavaLocalDateTime); 
		
		String dateFinEnchere = request.getParameter("datefinenchere");
		String heureFinEnchere = request.getParameter("heurefinenchere");  
		String dateheureFinEnchere=dateFinEnchere+" "+heureFinEnchere; 
	    LocalDateTime dateFinEnchere1  =LocalDateTime.parse(dateheureFinEnchere,formatBDDVersJavaLocalDateTime);
	    System.out.println("debut "+dateDebutEnchere+" fin "+dateFinEnchere1);
		String adresse =request.getParameter("adresse").trim();
		String codePostal =request.getParameter("codepostal");
		
		String Ville =request.getParameter("ville").trim();   
		
		
		ArticleManager manager = new ArticleManager(); 
		try{			
				if(( adresse.length()>0  && codePostal.length()>0 && Ville.length()>0 ) ) { 
					Retrait pointRetrait=new Retrait(adresse,codePostal,Ville);
					Article newarticle=manager.Ajouter(nomArticle, descritionArticle, dateDebutEnchere, dateFinEnchere1, prixInitial, prixInitial, false, utilisateur, categorie,pointRetrait);
				}else {  
					Retrait pointRetrait=new Retrait();
					Article newarticle=manager.Ajouter(nomArticle, descritionArticle, dateDebutEnchere, dateFinEnchere1, prixInitial, prixInitial, false, utilisateur, categorie,pointRetrait);
				} 
			} catch (Exception e) {
				 
				e.printStackTrace();
			} 	 
		doGet(request, response);
	}

}
