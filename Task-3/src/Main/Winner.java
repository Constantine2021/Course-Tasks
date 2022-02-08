package Main;

public class Winner {
    protected static String victoryRules(int userMove, int compMove, int length){
        int half = length/2;
        if (userMove == compMove) return "Draw!";
        if ((userMove < compMove && compMove - userMove > half) ||
                (userMove > compMove && compMove + length - userMove > half))
            return "You win!";
        return "You lose!";
    }
}