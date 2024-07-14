package com.alura.conversor.model;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoneda {
    public Moneda buscarCambioDivisa(String monedaBase, String monedaObjetivo, double valor){

        String api_key = "3ccdf3c4d232987d4dc1b554";
        String direccionURL = "https://v6.exchangerate-api.com/v6/" + api_key+
                "/pair/"+ monedaBase+ "/" + monedaObjetivo+ "/"+ valor;
        URI direccion = URI.create(direccionURL);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException("No se encontró ese cambio de divisa");
        }
    }
}
