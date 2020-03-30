<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="commerce.catalogue.service.CatalogueManager"%>
<%@ page import="commerce.catalogue.domaine.modele.Article"%>
<%@ page import="commerce.catalogue.domaine.modele.Livre"%>
<%@ page import="commerce.catalogue.domaine.modele.Musique"%>
<%@ page import="commerce.catalogue.domaine.modele.Piste"%>
<%@ page import="commerce.catalogue.domaine.modele.Film"%>

<%@ include file="enTetePage.html"%>

<%
	CatalogueManager catalogueManager = (CatalogueManager) application.getAttribute("catalogueManager");
	Article art = catalogueManager.chercherArticleParRef(request.getParameter("refArticle"));
%>

<h1 class='art-title'>
	<%
		out.print(art.getTitre());
	%>
</h1>

<div class='art-cont-img'>
	<img class='art-img'
		src="<%if (art.getImage().startsWith("http"))
				out.print(art.getImage());
			else
				out.print("./images/" + art.getImage());%>">
</div>

<div class='art-cont-other-attribute'>
	<span class='art-attribute-title'>Prix : </span> <span
		class='art-attribute-value'> <%=art.getPrix()%>€
	</span>
</div>

<%if(art instanceof Film){
	Film artfilm = (Film) art;
	out.print("<div class='art-cont-other-attribute'>");
	out.print("	<span class='art-attribute-title'>Note des utilisateurs : </span> <span");
	out.print("	class='art-attribute-value'>"+artfilm.getNote()+"/10 </span> </div>");

	
}


%>

<div class='art-cont-other-attribute'>
	<span class='art-attribute-title'>Description : </span> <br> <br>
	<span class='art-attribute-value'> <%
 	String description = art.getDescription();
 	if (description.equals("")) {
 		out.print("Oups....pas encore de description...");
 	} else {
 		out.print(description);
 	}
 %>
	</span>
</div>

<div class='art-button'>
<a
	href="<%=response.encodeURL(
					"./controlePanier.jsp?refArticle=" + art.getRefArticle() + "&amp;commande=ajouterLigne")%>"
	class="button add_to_cart_button product_type_simple"> Mettre dans
	le panier
	</a>
	</div>

<%@ include file="piedDePage.html"%>
