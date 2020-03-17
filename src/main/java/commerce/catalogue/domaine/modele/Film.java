package commerce.catalogue.domaine.modele;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="commerce.catalogue.domaine.modele.Film")
@DiscriminatorValue("film")
public class Film extends Article {

	private String realisateur; // A trouver
	private String description; // Champ overview
	private List<String> genres; // Champ genres
	private int annee; // Champ realease_date
	private int idTmdb; // Champ id
	private float note; // Champ vote_average
	
	
	public Film(String titre){
		
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
	
	
}
