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
import fr.eni.eboy.bll.EnchereManager;
import fr.eni.eboy.bll.UtilisateurManager;
import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Enchere;
import fr.eni.eboy.bo.Utilisateur;

/**
 * Servlet implementation class ServletEnchere
 */
@WebServlet("/enchere")
public class ServletEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEnchere() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionEncheres = request.getSession();
	
		Article articleEnCours = new Article();
		  if(request.getParameter("id")!=null) {
				   Integer idArticle = Integer.parseInt(request.getParameter("id"));
				   sessionEncheres.setAttribute("idArticleselec", idArticle); 
					articleEnCours = new ArticleManager().selectById(idArticle);
					request.setAttribute("article", articleEnCours);
					System.out.println("article en cours : "+articleEnCours);
					Enchere enchereSelectionnee = new EnchereManager().selectByArticleMeilleurOffre(articleEnCours);
					request.setAttribute("enchere", enchereSelectionnee);
					request.setAttribute("meilleurAcheteur", enchereSelectionnee.getUtilisateur());
					System.out.println("Voici l'enchere selectionnée : " + enchereSelectionnee);
					System.out.println("Enchere faite par  :" + enchereSelectionnee.getUtilisateur());
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/enchere.jsp");
					rd.forward(request, response);
			 }else {
					RequestDispatcher rd = request.getRequestDispatcher("/encheres");
					rd.forward(request, response);
			 }
			
			
			
			
//			RequestDispatcher rd = request.getRequestDispatcher("/encheres");
//			rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		HttpSession sessionEncheres = request.getSession();
		Article articleEnCours1 = new Article();
		Integer idArticle=(Integer)sessionEncheres.getAttribute("idArticleselec");
		articleEnCours1 = new ArticleManager().selectById(idArticle); 
		
		Integer idUser=(Integer) sessionEncheres.getAttribute("idUser"); 
		  System.out.println("article en coursenchere "+articleEnCours1);
		Integer proposition= Integer.parseInt(request.getParameter("enchereProposition"));
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur = utilisateurManager.retournerUtilisateurParId(idUser);
		Integer userCredit= utilisateur.getCredit();  
		
		
		if(articleEnCours1.getPrixVente()+1 > proposition && proposition < userCredit) {
			request.setAttribute("message", "Veuillez revoir votre proposition");
			request.setAttribute("article", articleEnCours1);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/enchere.jsp");
			rd.forward(request, response);
		}else {
			LocalDateTime dateDuJour = LocalDateTime.now(); 
			
			Enchere newEnchere= new Enchere(dateDuJour, proposition, articleEnCours1, utilisateur);
			EnchereManager validateEncher= new EnchereManager();
			
              validateEncher.validationEnchere(newEnchere); 
			RequestDispatcher rd = request.getRequestDispatcher("/index");
			rd.forward(request, response);
		}
		
		//doGet(request, response);
	}

}
