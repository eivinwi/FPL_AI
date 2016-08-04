package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import reponses.Element;
import reponses.GameSettings;
import reponses.Phase;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScrapeFplInfo implements InitializingBean {

    public void afterPropertiesSet() {
        try {
            scrape();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    public void scrape() throws URISyntaxException, IOException {
       /* HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet();
        request.setURI(new URI("https://fantasy.premierleague.com/drf/bootstrap-static"));

        HttpResponse response = client.execute(request);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line = "";
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        */
        URL url = new URL("https://fantasy.premierleague.com/drf/bootstrap-static");

        try(InputStream is = url.openStream()) {
            JsonReader reader = Json.createReader(is);

            JsonObject obj = reader.readObject();

            JsonArray phases = obj.getJsonArray("phases");
            JsonArray elements = obj.getJsonArray("elements");
            JsonObject settings = obj.getJsonObject("game-settings");


            ObjectMapper mapper = new ObjectMapper();


            List<Phase> phaseList = phases.getValuesAs(Phase.class);
            List<Element> elementList = elements.getValuesAs(Element.class);
            GameSettings gameSettings = new GameSettings(settings);

            System.out.println("phases");
            System.out.println(phases);
        }
    }
}
