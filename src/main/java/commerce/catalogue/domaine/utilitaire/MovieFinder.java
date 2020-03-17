package commerce.catalogue.domaine.utilitaire;

import java.util.HashMap;

public class MovieFinder extends TmdbRequest {
	
	public MovieFinder() {
		super("search/movies");
	}
	
	public String getFilm(String title) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("query", title);
		
		return super.sendRequest(map);
	}
	
}
