package commerce.catalogue.domaine.utilitaire;

import java.net.MalformedURLException;
import java.net.URL;

public class TmdbRequest {
	
	private final String baseUrl = "https://api.themoviedb.org/3/";
	private final String apiKey = "157ddf0b52e1e8a032ce672cb85805d8";
	private URL urlRequest;
	
	// Créé l'url pour une commande précise (ex : search/movies/)
	// Ne pas mettre de / au debut de commandRequest
	public TmdbRequest(String commandRequest){
		try {
			urlRequest = new URL(baseUrl + commandRequest + "/&api_key="+apiKey);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public String sendRequest(String termeRecherche) {
		
		return null;
	}
}
