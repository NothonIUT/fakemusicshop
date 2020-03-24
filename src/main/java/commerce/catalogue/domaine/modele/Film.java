package commerce.catalogue.domaine.modele;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.json.*;

import commerce.catalogue.domaine.utilitaire.MovieFinder;
import commerce.catalogue.domaine.utilitaire.TmdbRequest;

//@Entity (name="commerce.catalogue.domaine.modele.Film")
//@DiscriminatorValue("film")
@Entity (name="commerce.catalogue.domaine.modele.Film")
@DiscriminatorValue("film")
public class Film extends Article {

	private String realisateur; // A trouver
	//private List<String> genres; // Champ genres
	private String annee; // Champ release_date
	private int idTmdb; // Champ id
	private float note; // Champ vote_average
	private String api_response;

	public Film() {
		
		super();
		this.realisateur = "";
		this.annee = "";
		this.idTmdb = 0;
		this.note = -1;
		
	}
	
	public Film(String titre, double prix) {

		MovieFinder finder = new MovieFinder();

		this.api_response = finder.getFilm(titre);
		
		this.parseFilm(api_response);
		super.setPrix(prix);
		this.realisateur = "";
		super.setDisponibilite(200);
	}

	public Film(int id) {

	}

	@Basic
	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

/*	@Basic
	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
*/
	@Basic
	public String getAnnee() {
		return annee;
	}

	@Basic
	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public int getIdTmdb() {
		return idTmdb;
	}

	public void setIdTmdb(int idTmdb) {
		this.idTmdb = idTmdb;
	}

	@Basic
	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	private void parseFilm(String json) {
		JSONObject obj = new JSONObject(json);
		JSONArray arr = obj.getJSONArray("results");
		
		super.setTitre(arr.getJSONObject(0).getString("title"));
		super.setDescription(arr.getJSONObject(0).getString("overview"));;
		super.setImage("http://image.tmdb.org/t/p/w500" + arr.getJSONObject(0).getString("poster_path"));
		this.annee = arr.getJSONObject(0).getString("release_date");
		this.idTmdb = arr.getJSONObject(0).getInt("id");
		this.note = arr.getJSONObject(0).getFloat("vote_average");
	}
	
	@Override
	public String toString() {
		
		return "Titre : "+getTitre()+" Prix : "+getPrix() + " Description : "+getDescription();
	}
}