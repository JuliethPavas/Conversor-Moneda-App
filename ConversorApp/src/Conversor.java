import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public Moneda convertirPar(String origen, String destino , double cant){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/4710b05ae1a55a38b894d597/pair/"+origen+"/"+destino+"/"+cant))
                .build();
        try {
            HttpResponse<String> response= client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa Divisa.");}

    }

    public double resultado(double cant , double conversion){
        return cant * conversion;
    }
}