package com.kaphaogame.gamelist.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameListRequest {
    private String request_url;
    private OkHttpClient client;
    private Request request;
    private Response response;
    private JSONParser jsonParser;
    private JSONObject jsonObject;
    private String responseString;
    private List<GameListModel> gameListModels;

    public GameListRequest(String request_url){
        this.request_url = request_url;
        gameListModels = new ArrayList<>();
        client = new OkHttpClient();
        request = new Request.Builder().url(request_url).get().build();
        try {
            response = client.newCall(request).execute();
            responseString = response.body().string();
            jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(responseString);
            JSONArray gameResults = (JSONArray) jsonObject.get("results");
            for (int i = 0; i < gameResults.size(); i++) {
                JSONObject gameResult = (JSONObject) gameResults.get(i);
                String slug = (String) gameResult.get("slug");
                String name = (String) gameResult.get("name");
                String background_image_url = (String) gameResult.get("background_image");
                Long metacriticScore = (Long) gameResult.get("metacritic");
                Double rating = (Double) gameResult.get("rating");
                if(metacriticScore != null){
                    gameListModels.add(new GameListModel(name, slug, background_image_url, metacriticScore, rating));
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDetailPlatform(JSONObject platformsJSON) {
        String detailPlatform;
        JSONArray platforms = (JSONArray) platformsJSON.get("platforms");
        JSONObject platform = (JSONObject) platforms.get(0);
        JSONObject detailPlatformJson = (JSONObject) platform.get("platform");
        detailPlatform = detailPlatformJson.get("slug").toString();
        return detailPlatform;
    }

    public List<GameListModel> getGameListModels() {
        return gameListModels;
    }
}
