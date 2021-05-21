package fr.eni.eboy.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

/**
 * Servlet implementation class ServletAcceuil
 */
@WebServlet(urlPatterns ={"/index", "/accueil", "/encheres"})
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletAccueil() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sessionEncheres = request.getSession();
		request.setAttribute("idUser", sessionEncheres.getAttribute("idUser"));
		List<Article> listeArticlesAccueil = new ArticleManager().selectAllEnCours();
		request.setAttribute("articles", listeArticlesAccueil);
	 
		System.out.println("Is empty :"+ listeArticlesAccueil.isEmpty());
		System.out.println("Size =" + listeArticlesAccueil.size());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 

		//Gestion de session
		HttpSession sessionEncheres = request.getSession();
		if( sessionEncheres.getAttribute("idUser")==null) { 
			doGet(request, response);
			
		}
		
		Integer idUser = (Integer) sessionEncheres.getAttribute("idUser");
		
		String texteRechercheParam = request.getParameter("recherche");
		String categorieParam = request.getParameter("categorie");
//		if (categorieParam==null) {
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
//			rd.forward(request, response);
//		}
		//Radio du choix utilisateur
		String ChoixOptionParam = request.getParameter("optionConnectee");
		boolean ChoixAchat =false;
		boolean ChoixVente =false;
		//Checkboxes achats
		boolean checkEnchereOuverte =Boolean.parseBoolean(request.getParameter("enchereOuverte"));
		boolean checkEnchereUtilisateur =Boolean.parseBoolean( request.getParameter("enchereUtilisateur"));
		boolean checkEnchereGagnee = Boolean.parseBoolean(request.getParameter("enchereGagnee"));
		//Cheboxes ventes
		boolean checkVenteOuverte = Boolean.parseBoolean(request.getParameter("ventesOuverte"));
		boolean checkVenteNonDebutee = Boolean.parseBoolean(request.getParameter("venteNonDebutee"));
		boolean checkVenteTerminee = Boolean.parseBoolean(request.getParameter("venteTerminee"));

		System.out.println("checkEnchereOuverte :"+checkEnchereOuverte);
		System.out.println("checkEnchereUtilisateur :"+checkEnchereUtilisateur);
		System.out.println("checkEnchereGagnee :"+checkEnchereGagnee);
		System.out.println("checkVenteOuverte :"+checkVenteOuverte);
		System.out.println("checkVenteNonDebutee :"+checkVenteNonDebutee);
		System.out.println("checkVenteTerminee :"+checkVenteTerminee);
		String achats = "achats";
		//String ventes = "ventes"; Debug si test ventes
		if (ChoixOptionParam != null) {
			if (ChoixOptionParam.equals(achats)) {
				ChoixAchat = true;
			} else {
				ChoixVente = true;
			}
		}
		System.out.println("Choixoption param : "+ChoixOptionParam);
		System.out.println("ChoixAchat param : "+ChoixAchat);
		System.out.println("ChoixVente param : "+ChoixVente);
		//Temporaire tant que les fonction simplifiées ne sont pas implementées
		if (Integer.parseInt(categorieParam)==0) {
			List<Article> listeArticlesAccueil = new ArticleManager().selectAllEnCours();
			request.setAttribute("articles", listeArticlesAccueil);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
			rd.forward(request, response);
		} 
		Integer idUtilisateur = idUser; 
		System.out.println("utilisateur : "+new UtilisateurManager().retournerUtilisateurParId(idUtilisateur)); 
		Categorie categorieRecherchee = new CategorieManager().selectById(Integer.parseInt(categorieParam));
		texteRechercheParam = texteRechercheParam.toLowerCase().trim();
		System.out.println("texte recherche size :"+ texteRechercheParam.length()); 
		List<Article> listeArticlesAccueil = new ArrayList<Article>();
		if (ChoixAchat) {
			listeArticlesAccueil= new ArticleManager().selectAchatEncherePlusGagneePlusOuverte(categorieRecherchee, texteRechercheParam, checkEnchereOuverte, checkEnchereUtilisateur, checkEnchereGagnee, idUtilisateur);
		}
		if(ChoixVente) {
			listeArticlesAccueil= new ArticleManager().selectVentePlusNonDebuteePlusTerminee(categorieRecherchee, texteRechercheParam, checkVenteOuverte, checkVenteNonDebutee, checkVenteTerminee, idUtilisateur);
		}
		
		request.setAttribute("articles", listeArticlesAccueil);
		
 
		for (Article art : listeArticlesAccueil) {
			System.out.println(art.getNumero());
		}  
		 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

}