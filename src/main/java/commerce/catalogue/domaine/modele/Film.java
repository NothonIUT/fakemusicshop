package commerce.catalogue.domaine.modele;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;

import commerce.catalogue.domaine.utilitaire.MovieFinder;
import commerce.catalogue.domaine.utilitaire.TmdbRequest;

//@Entity (name="commerce.catalogue.domaine.modele.Film")
//@DiscriminatorValue("film")
public class Film extends Article {

	private String realisateur; // A trouver
	private String description; // Champ overview
	private List<String> genres; // Champ genres
	private int annee; // Champ realease_date
	private int idTmdb; // Champ id
	private float note; // Champ vote_average
	private String api_response;
	
	
	public Film(String titre){
		
		MovieFinder finder = new MovieFinder();
		
		this.api_response = finder.getFilm(titre);
		
		super.setTitre(titre);
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

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
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
	
	private void parseFilm(String json) throws JsonParseException, IOException {
		JsonParser parser = new  JsonFactory().createJsonParser(json);
	}
	
	
}
