package fr.eni.eboy.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.eboy.bll.ArticleManager;
import fr.eni.eboy.bll.EnchereManager;
import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Categorie;
import fr.eni.eboy.bo.Enchere;
import fr.eni.eboy.bo.Utilisateur;
import fr.eni.eboy.dal.ArticleDaoJdbcImpl;

/**
 * Servlet implementation class ServletAcceuil
 */
@WebServlet(urlPatterns ={"/index", "/acceuil", "/encheres"})
public class ServletAcceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletAcceuil() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		List<Article> listeArticlesAcceuil = new ArticleManager().selectAllEnCours();
		request.setAttribute("articles", listeArticlesAcceuil);
		
		System.out.println("Listes des articles affiché :" + listeArticlesAcceuil.toString());
		System.out.println("Is empty :"+ listeArticlesAcceuil.isEmpty());
		System.out.println("Size =" + listeArticlesAcceuil.size());
		//System.out.println(listeArticlesAcceuil.listIterator());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//		String testBDD ="2021-01-30 10:30:00.0";
//		LocalDateTime dateTestBDD = LocalDateTime.parse(testBDD, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
//		System.out.println(dateTestBDD);
//		System.out.println(dateTestBDD.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
//		System.out.println(dateTestBDD.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS")));
		
//		
//		LocalDateTime dateTest = LocalDateTime.parse("2021-01-30T10:30:00.0");
//		System.out.println(dateTest);

		
		String texteRechercheParam = request.getParameter("recherche");
		String categorieParam = request.getParameter("categorie");
		List<Article> listeArticlesAcceuil = new ArticleManager().selectAllEnCours();
		request.setAttribute("articles", listeArticlesAcceuil);
		
		//--------DEBUG
		//------ creation d'objet pour debug
//		ArticleDaoJdbcImpl aDao = new ArticleDaoJdbcImpl();
//		listeArticlesAcceuil = aDao.selectAllEnCours();
//		
		
//		Integer intChiant = 100;
//		boolean boolChiant = true;
//		List<Article> listArtChiant = new ArrayList<Article>();
//		List<Enchere> listEnchChiant = new ArrayList<Enchere>();
//		Utilisateur u1 = new Utilisateur(intChiant,"yankee" ,"sidy", "barry", "b@eni.fr", "0701020304", "colonel", "35500", "Rennes Sud", "mdp", intChiant, boolChiant, listArtChiant, listEnchChiant);
//		Categorie c1 = new Categorie(intChiant, "DebugCateg",listArtChiant);
//		LocalDateTime dateChiant = LocalDateTime.now();
//		Article a1 = new Article(intChiant, "testServ", "Un bon debug",  dateChiant, dateChiant, intChiant, intChiant, boolChiant, u1, c1);
//		Article a2 = new Article(intChiant+1, "testServ2", "Un bon debug2",  dateChiant, dateChiant, intChiant, intChiant, boolChiant, u1, c1);
////----------
//		listeArticlesAcceuil.add(a1);
//		listeArticlesAcceuil.add(a2);
		for (Article art : listeArticlesAcceuil) {
			System.out.println(art.getNumero());
		}
		
		System.out.println("Listes des articles affiché :" + listeArticlesAcceuil.toString());
		System.out.println( listeArticlesAcceuil.isEmpty());
		System.out.println(listeArticlesAcceuil.size());
		//System.out.println(listeArticlesAcceuil.listIterator());
		
		System.out.println(texteRechercheParam); //Debug Parameter recherche
		System.out.println(categorieParam); // Debug Parameter categorie
		//--------- DEBUG FIN
		
		//---Debug 2
		List<Article> listeArticlesSelectAll = new ArticleManager().selectAll();
		System.out.println( listeArticlesSelectAll.isEmpty());
		System.out.println(listeArticlesSelectAll.size());
		System.out.println("Listes des articles affiché SELECT ALL :" + listeArticlesSelectAll.toString());
		

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
		Article a1 = new Article();
		Article a2 = new Article();
		a2 = listeArticlesSelectAll.get(0);
		a1 = listeArticlesSelectAll.get(1);
		System.out.println("a1 :"+a1);
		System.out.println("a2 :"+a2);
		Enchere enchere1 = new EnchereManager().selectByArticleMeilleurOffre(a1);
		Enchere enchere2 = new EnchereManager().selectByArticleMeilleurOffre(a2);
		
		System.out.println("Enchere testant le selectById 1"+enchere1);
		System.out.println("Enchere testant le selectById 2"+enchere2);
	}

}
