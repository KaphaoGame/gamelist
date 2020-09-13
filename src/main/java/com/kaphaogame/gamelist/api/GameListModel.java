package com.kaphaogame.gamelist.api;

public class GameListModel {
    private String gameName;
    private String slug;
    private String gameImageURL;

    public GameListModel(String gameName, String slug, String gameImageURL) {
        this.gameName = gameName;
        this.slug = slug;
        this.gameImageURL = gameImageURL;
    }

    public String getGameName() {
        return gameName;
    }

    public String getSlug() {
        return slug;
    }

    public String getGameImageURL() {
        return gameImageURL;
    }
}
