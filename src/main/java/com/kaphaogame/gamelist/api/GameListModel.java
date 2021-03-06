package com.kaphaogame.gamelist.api;

public class GameListModel {
    private String gameName;
    private String slug;
    private String gameImageURL;
    private Long metacriticScore;
    private Double rating;

    public GameListModel(String gameName, String slug, String gameImageURL, Long metacriticScore, Double rating) {
        this.gameName = gameName;
        this.slug = slug;
        this.gameImageURL = gameImageURL;
        this.metacriticScore = metacriticScore;
        this.rating = rating;
    }

    public GameListModel() {
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

    public Long getMetacriticScore() {
        return metacriticScore;
    }

    public Double getRating() {
        return rating;
    }
}
