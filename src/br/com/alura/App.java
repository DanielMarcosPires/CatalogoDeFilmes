package br.com.alura;

import br.com.alura.api.Api;
import br.com.alura.janela.Janela;
import br.com.alura.jsonParser.JsonParser;

import javax.swing.*;
import java.io.IOException;

import java.util.List;
import java.util.Map;

/**
 * <h1>Objetivo</h1>
 * <ul>
 *     <li>Fazer uma conexão <strong>HTTP</strong> e buscar os top 250 filmes</li>
 *     <li>Extrair só os dados de interessa, (titulo, poster, classificação)</li>
 *     <li>Exibir e manipular os dados</li>
 * </ul>
 * */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {


                Api api = new Api();
                JsonParser parser = new JsonParser();
                List<Map<String,String>> listaDeFilmes = parser.parse(api.apiConvertido());


                SwingUtilities.invokeLater(() -> {
                 Janela janela = new Janela(800,500,"Catalogo de filmes",listaDeFilmes);

                });





    }


}