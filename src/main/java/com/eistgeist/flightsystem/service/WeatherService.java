package com.eistgeist.flightsystem.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.StringTokenizer;

@Service
@AllArgsConstructor
public class WeatherService {

    public float getWeather(String cityName) {
        float temperature = 0;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .uri(URI.create("http://api.weatherapi.com/v1/current.json?key=447cdd8e041443e3adb182013222007&q="+cityName+"&aqi=no"))
                    .GET()
                    .build();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String weatherResponse = response.body().toString();
            StringTokenizer tokenizer = new StringTokenizer(weatherResponse,", :");
            while(tokenizer.hasMoreTokens()) {
                String nextToken = tokenizer.nextToken();
                if(nextToken.contains("temp_c")) {
                    System.out.println(nextToken);
                    String temperatureString = tokenizer.nextToken();
                    temperature= Float.parseFloat(temperatureString);
                }
            }
        }
        catch (Exception e) {
        e.printStackTrace();
        return temperature;
        }
        return temperature;
    }
}
