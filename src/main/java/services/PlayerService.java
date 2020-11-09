package services;

import models.Player;

/**
 * @author ruizhu
 * @className: PlayerService
 * @description: Find the overall player with the max number of played games
 */
public class PlayerService {
    SkaterService skaterService = new SkaterService();
    GoalieService goalieService = new GoalieService();

    /**
     * @author ruizhu
     * @methodsName: findPlayerWithMostGames
     * @description: Find the overall player with the max number of played games
     * @return: Player
     */
    public Player findPlayerWithMostGames(){
        if(skaterService.findSkaterWithMostGames().getGamesPlayed() >= goalieService.findGoalieWithMostGames().getGamesPlayed()){
            return skaterService.findSkaterWithMostGames();
        }else
            return goalieService.findGoalieWithMostGames();
    }
}
