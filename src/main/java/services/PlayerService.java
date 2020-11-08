package services;

import models.Player;

public class PlayerService {
    SkaterService skaterService = new SkaterService();
    GoalieService goalieService = new GoalieService();

    public Player findPlayerWithMostGames(){

        if(skaterService.findSkaterWithMostGames().getGamesPlayed() >= goalieService.findGoalieWithMostGames().getGamesPlayed()){
            return skaterService.findSkaterWithMostGames();
        }else
            return goalieService.findGoalieWithMostGames();
    }
}
