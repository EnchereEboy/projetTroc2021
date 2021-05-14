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
import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Retrait;

/**
 * Servlet implementation class NouvelleVente
 */
@WebServlet({ "/NouvelleVente", "/index" })
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DateTimeFormatter formatJourMoisAnneeHeureMinute = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/articleNouveau.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //recuperation des champs du formulaire
		
		String nomArticle=request.getParameter("article");
		String descritionArticle=request.getParameter("description");
		Integer nocategorie=Integer.parseInt(request.getParameter("categorie"));
		Integer prixInitial= Integer.parseInt(request.getParameter("miseaprix"));
		String dateDebutEnchere1=request.getParameter("datedebutenchere").replace('T', ' ');
		LocalDateTime dateDebutEnchere=LocalDateTime.parse(dateDebutEnchere1,formatter);
		String dateFinEnchere = request.getParameter("datefinenchere").replace('T', ' ');
	    LocalDateTime dateFinEnchere1  =LocalDateTime.parse(dateFinEnchere,formatter);
		
		String adresse =request.getParameter("adresse").trim();
		String codePostal =request.getParameter("codepoastal").trim();
		String Ville =request.getParameter("ville").trim(); 
		ArticleManager manager = new ArticleManager(); 
		try {
			
			if((adresse != null || adresse.length()>0 ) && (codePostal != null || codePostal.length()>0 ) && (Ville != null || Ville.length()>0 ) ) {
				Retrait pointRetrait=new Retrait(adresse,codePostal,Ville);
				Article newarticle=manager.Ajouter(nomArticle, descritionArticle, dateDebutEnchere, dateFinEnchere1, prixInitial, 0, false, 1, nocategorie,pointRetrait);
			}else {
				Retrait pointRetrait=new Retrait();
				Article newarticle=manager.Ajouter(nomArticle, descritionArticle, dateDebutEnchere, dateFinEnchere1, prixInitial, 0, false, 1, nocategorie,pointRetrait);
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
