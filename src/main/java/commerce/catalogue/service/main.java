package commerce.catalogue.service;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.Map;

import commerce.catalogue.domaine.modele.Film;
import commerce.catalogue.domaine.utilitaire.MovieFinder;
import commerce.catalogue.domaine.utilitaire.TmdbRequest;

public class main {

	public static void main(String[] args) throws JsonProcessingException, IOException {

		Film unFilm = new Film("django", 25);
		System.out.println("Titre : " + unFilm.getTitre());
		System.out.println("Description : "+ unFilm.getDescription());
	}

}
