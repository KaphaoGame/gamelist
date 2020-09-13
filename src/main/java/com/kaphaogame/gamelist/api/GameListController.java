package com.kaphaogame.gamelist.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameListController {
    private List<GameListModel> topGameRequestList;
    private List<GameListModel> newReleaseGameRequestList;
    private GameListRequest gameListRequest;


    public GameListController() {
        topGameRequestList = new ArrayList<>();
        newReleaseGameRequestList = new ArrayList<>();
        gameListRequest = new GameListRequest("https://api.rawg.io/api/games?dates=2020-01-01,2020-12-31&ordering=-rating");
        for (GameListModel gameListModel : gameListRequest.getGameListModels()) {
            topGameRequestList.add(gameListModel);
        }
        gameListRequest = new GameListRequest("https://api.rawg.io/api/games?dates=2020-09-01,2020-09-30");
        for (GameListModel gameListModel : gameListRequest.getGameListModels()) {
            newReleaseGameRequestList.add(gameListModel);
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity showTopGameRequestList(){
        return ResponseEntity.ok(topGameRequestList);
    }

    @GetMapping(value = "/new-release")
    public ResponseEntity showNewReleaseGameRequestList(){
        return ResponseEntity.ok(newReleaseGameRequestList);
    }
}
