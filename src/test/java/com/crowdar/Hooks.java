package com.crowdar;

import com.crowdar.core.PropertyManager;
import io.cucumber.java.After;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Hooks {
    @After
    public void deleteAllTimeEntries() throws IOException, InterruptedException {
        String url = String.format("https://api.clockify.me/api/v1/workspaces/%s/user/%s/time-entries", PropertyManager.getProperty("workspaceId"), PropertyManager.getProperty("userId"));
        String token = PropertyManager.getProperty("token");
        String responseBody = getTimeEntries(url, token);
        List<String> ids = getIds(responseBody);
        if (ids.isEmpty()) {
            return;
        }
        deleteTimeEntries(url, token, ids);
    }

    private String getTimeEntries(String url, String token) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .header("accept", "application/json")
                .header("x-api-key", token)
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return (String) response.body();
    }

    private List<String> getIds(String responseBody) {
        JSONArray body = new JSONArray(responseBody);
        List<String> ids = new ArrayList<String>();
        for (int i = 0 ; i < body.length(); i++) {
            JSONObject timeEntry = body.getJSONObject(i);
            String id = timeEntry.getString("id");
            ids.add(id);
        }
        return ids;
    }

    private void deleteTimeEntries(String url, String token, List<String> ids) throws IOException, InterruptedException {
        String deleteUrl = url + "?time-entry-ids=" + String.join(",", ids);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(deleteUrl))
                .header("accept", "application/json")
                .header("x-api-key", token)
                .DELETE()
                .build();
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
