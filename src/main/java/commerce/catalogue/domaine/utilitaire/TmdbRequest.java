package commerce.catalogue.domaine.utilitaire;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class TmdbRequest {

	private final String baseUrl = "https://api.themoviedb.org/3/";
	private final String apiKey = "157ddf0b52e1e8a032ce672cb85805d8";
	private URL urlRequest; // GET Url

	// Créé l'url pour une commande précise (ex : search/movies/)
	// Ne pas mettre de / au debut de commandRequest
	public TmdbRequest(String commandRequest) {
		try {
			urlRequest = new URL(baseUrl + commandRequest);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public String sendRequest(Map<String, String> termeRecherche) {

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(urlRequest + parseMap(termeRecherche));
		HttpResponse response;
		try {
			response = client.execute(request);
		System.out.println(urlRequest + parseMap(termeRecherche));
		System.out.println(response);

		Scanner sc = new Scanner(response.getEntity().getContent());

		String result = "";

		System.out.println(response.getStatusLine());

		while (sc.hasNext()) {

			result = sc.nextLine();

		}
		
		return result;

		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Error";
		
	}

	public String parseMap(Map<String, String> map) {
		String requestParam = "/?api_key=" + apiKey;
		for (String cle : map.keySet()) {
			requestParam += "&" + cle + "=" + map.get(cle);
		}
		return requestParam;
	}
}
