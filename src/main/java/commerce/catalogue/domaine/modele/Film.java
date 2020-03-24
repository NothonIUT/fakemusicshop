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
public class Film extends Article {

	private String realisateur; // A trouver
	private String description; // Champ overview
	private List<String> genres; // Champ genres
	private String annee; // Champ release_date
	private int idTmdb; // Champ id
	private float note; // Champ vote_average
	private String api_response;

	public Film(String titre) {

		MovieFinder finder = new MovieFinder();

		this.api_response = finder.getFilm(titre);
		
		this.parseFilm(api_response);
	}

	public Film(int id) {

	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public int getIdTmdb() {
		return idTmdb;
	}

	public void setIdTmdb(int idTmdb) {
		this.idTmdb = idTmdb;
	}

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
		this.description = arr.getJSONObject(0).getString("overview");
		super.setImage("http://image.tmdb.org/t/p/w500" + arr.getJSONObject(0).getString("poster_path"));
		this.annee = arr.getJSONObject(0).getString("release_date");
		this.idTmdb = arr.getJSONObject(0).getInt("id");
		this.note = arr.getJSONObject(0).getFloat("vote_average");
	}
}