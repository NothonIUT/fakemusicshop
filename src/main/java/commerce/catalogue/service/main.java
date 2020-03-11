package commerce.catalogue.service;

import java.util.HashMap;

import java.util.Map;

import commerce.catalogue.domaine.utilitaire.TmdbRequest;

public class main {

	public static void main(String[] args) {

		TmdbRequest tmdb = new TmdbRequest("search/movies");
		Map<String, String> map = new HashMap<>();
		map.put("querry", "Django");
		
		tmdb.sendRequest(map);
		
	}

}
