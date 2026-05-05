

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {

        String json = fetchJson(urlString);
        return parseAttribute(json, attributeName);
    }

    // --- Subsystem 1 + 2: HTTP + Response handling ---
    private String fetchJson(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP request failed with status: " + status);
        }

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                content.append(line);
            }

            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    // --- Subsystem 3: JSON parsing ---
    private String parseAttribute(String json, String attributeName) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(json);

            Object value = obj.get(attributeName);

            if (value == null) {
                throw new IllegalArgumentException(
                        "Attribute not found: " + attributeName);
            }

            return value.toString();

        } catch (IllegalArgumentException e) {
            throw e; // rethrow cleanly
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid JSON or parsing error");
        }
    }
}