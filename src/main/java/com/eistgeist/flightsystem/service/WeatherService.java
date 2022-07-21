package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.model.Weather;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@AllArgsConstructor
public class WeatherService {

    public Weather getWeather(String cityName) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .uri(URI.create("http://api.weatherapi.com/v1/current.json?key=447cdd8e041443e3adb182013222007&q=" + cityName + "&aqi=no"))
                    .GET()
                    .build();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String weatherResponse = response.body().toString();
            JsonNode node = Json.parse(weatherResponse);
            return Json.fromJson(node.get("current"), Weather.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
