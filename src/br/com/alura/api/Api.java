package br.com.alura.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    private String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";


    public String apiConvertido() throws IOException, InterruptedException {
        URI endereco = URI.create(getUrl());
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        return body;
    }

    private String getUrl() {
        return url;
    }
}
