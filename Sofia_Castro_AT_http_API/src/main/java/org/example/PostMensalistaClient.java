package org.example;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class PostMensalistaClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:7000/mensalistas");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);


        String jsonInput = "{\"nome\":\"Tiago\",\"matricula\":\"000\"}";
        try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonInput.getBytes());
            os.flush();
        }


        System.out.println("Status: " + conn.getResponseCode());
    }


}
