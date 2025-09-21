package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetMensalistaPorMatriculaClient {
    public static void main(String[] args) throws Exception {
        String matricula = "123";
        URL url = new URL("http://localhost:7000/mensalistas/" + matricula);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Mensalista encontrado:");
        System.out.println(response);
    }

}
