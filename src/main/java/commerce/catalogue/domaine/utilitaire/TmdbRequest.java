package commerce.catalogue.domaine.utilitaire;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class TmdbRequest {
	
	private final String baseUrl = "https://api.themoviedb.org/3/";
	private final String apiKey = "157ddf0b52e1e8a032ce672cb85805d8";
	private URL urlRequest; // GET Url
	
	// Créé l'url pour une commande précise (ex : search/movies/)
	// Ne pas mettre de / au debut de commandRequest
	public TmdbRequest(String commandRequest){
		try {
			urlRequest = new URL(baseUrl + commandRequest);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public String sendRequest(Map<String, String> termeRecherche) {
		try {
			System.out.println(urlRequest.toString());
			HttpURLConnection con = (HttpURLConnection) urlRequest.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
			DataOutputStream param = new DataOutputStream(con.getOutputStream());
			param.writeBytes(parseMap(termeRecherche));
			System.out.println(urlRequest.toString());
			param.flush();
			param.close();
			
			// Le proxy de ses morts bloque la co
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) {
				System.out.println("Bien jouej");
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer reponse = new StringBuffer();
				
				while((inputLine = in.readLine()) != null) {
					reponse.append(inputLine);
				}
				in.close();
				System.out.println(reponse.toString());
			}else {
				System.out.println("Bah Dommage pd");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public String parseMap(Map<String, String> map) {
		String requestParam = "/?api_key="+apiKey;
		for (String cle : map.keySet()) {
			requestParam += "&"+cle+"="+map.get(cle);
		}
		return requestParam;
	}
}
