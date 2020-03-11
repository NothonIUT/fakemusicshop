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
}
