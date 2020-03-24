package commerce.catalogue.service;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

import java.util.Map;

import commerce.catalogue.domaine.utilitaire.TmdbRequest;

public class main {

	public static void main(String[] args) {

		TmdbRequest tmdb = new TmdbRequest("search/movie");
		Map<String, String> map = new HashMap<>();
		map.put("query", "Django");
		System.out.println(tmdb.sendRequest(map));
	}

}
