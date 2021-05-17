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

import fr.eni.eboy.bll.ArticleManager;
import fr.eni.eboy.bll.UtilisateurManager;
import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Retrait;
import fr.eni.eboy.bo.Utilisateur;
/**
 * Servlet implementation class NouvelleVente
 */
@WebServlet({ "/NouvelleVente", "/index" })
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
//private static final DateTimeFormatter formatJourMoisAnneeHeureMinute = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getServletPath().equals("/index")) {
			String idUser1 = request.getParameter("id");
			  if(idUser1!=null){
	    	System.out.println(request.getParameter("id"));
			    
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
		
		String nomArticle=request.getParameter("article");
		String descritionArticle=request.getParameter("description");
		System.out.println(descritionArticle);
		System.out.println(request.getParameter("categorie"));
		Integer nocategorie=Integer.parseInt(request.getParameter("categorie"));
		Integer prixInitial= Integer.parseInt(request.getParameter("miseaprix"));
		String dateDebutEnchere1=request.getParameter("datedebutenchere").replace('T', ' ');
		LocalDateTime dateDebutEnchere=LocalDateTime.parse(dateDebutEnchere1,formatter);
		String dateFinEnchere = request.getParameter("datefinenchere").replace('T', ' ');
	    LocalDateTime dateFinEnchere1  =LocalDateTime.parse(dateFinEnchere,formatter);
		String adresse =request.getParameter("adresse").trim();
		String codePostal =request.getParameter("codepoastal").trim();
		String Ville =request.getParameter("ville").trim(); 
		//System.out.println(adresse+"------"+codePostal+"--------"+Ville);
		ArticleManager manager = new ArticleManager(); 
		try {
			
			if(( adresse.length()>0  || codePostal.length()>0 || Ville.length()>0 ) ) {
				System.out.println("Avec adresse ="+adresse.length());
				Retrait pointRetrait=new Retrait(adresse,codePostal,Ville);
				Article newarticle=manager.Ajouter(nomArticle, descritionArticle, dateDebutEnchere, dateFinEnchere1, prixInitial, 0, false, 1, nocategorie,pointRetrait);
				System.out.println("vente avec adresse ");
				System.out.println(newarticle);
			}else {
				System.out.println("sans adresse adresse");
				Retrait pointRetrait=new Retrait();
				Article newarticle=manager.Ajouter(nomArticle, descritionArticle, dateDebutEnchere, dateFinEnchere1, prixInitial, 0, false, 1, nocategorie,pointRetrait);
				System.out.println("vente sans adresse ");
				System.out.println(newarticle);
			} 
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
//		System.out.println(nomArticle+"------"+descritionArticle+"--------"+nocategorie);
//		System.out.println(prixInitial+"------"+dateDebutEnchere+"--------"+dateFinEnchere);
//		System.out.println(adresse+"------"+codePostal+"--------"+Ville+"++++++++    "+dateFinEnchere1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//		
//		 
		doGet(request, response);
	}

}
