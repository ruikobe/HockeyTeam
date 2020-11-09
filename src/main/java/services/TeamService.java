package services;

/**
 * @author ruizhu
 * @className: TeamService
 * @description: Validate/check the team roster is valid
 */
public class TeamService {

    /**
     * @methodsName: teamValid
     * @description: Validate/check the team roster is valid
     * @return: void
     */
    public void teamValid(){
        int allPlayersNumber = GoalieService.getAllGoalieNumber() + SkaterService.getAllSkater();
        int activePlayersNumber = GoalieService.getActiveGoalieNumber() + SkaterService.getActiveSkater();

        if(ManagerService.getManagerNubmer() != 1){
            System.out.println("\nNot valid, there must always be only one manager on the team.\n");
        }else if (activePlayersNumber != 15){
            System.out.println("\nNot valid, there must always be exactly 15 active players on the team at a time. Currently, there are " + GoalieService.getActiveGoalieNumber() + " active goalies, and " + SkaterService.getActiveSkater() + " active skaters in the team.\n");
        }else if (allPlayersNumber > 20){
            System.out.println("\nNot valid, no more than 20 overall players are allowed on the team at a time.\n");
        }else if (GoalieService.getAllGoalieNumber() == 0){
            System.out.println("\nNot valid, the team must have at least one goalie.\n");
        }else if (CoachService.getHeadCoachNumber() > 1){
            System.out.println("\nNot valid, there can only be one head coach assigned to the team at any time.\n");
        }else if (CoachService.getAssistantCoachNumber() == 0 || CoachService.getAssistantCoachNumber() > 3){
            System.out.println("\nNot valid, the number of assistant coaches must be between 1 and 3.\n");
        }else{
        System.out.println("The team is valid!");
        }
    }



}
