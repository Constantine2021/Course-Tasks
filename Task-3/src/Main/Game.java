package Main;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Game {
    public static void main(String[] moves){
        Scanner inScan = new Scanner(System.in);
        while (true){
            if (numberOfMovesIsCorrect(moves) && equalMovesNotExist(moves))
                break;
            else {
                System.out.print("Enter moves for the game: ");
                moves = inScan.nextLine().split(" ");
                System.out.println();
            }
        }
        startGame(moves);
        inScan.close();
    }

    private static boolean numberOfMovesIsCorrect(String[] moves){
        if(moves.length == 0) return false;
        if(moves.length % 2 == 0 || moves.length < 3){
            System.out.println("""
                    You wrong! You must enter odd number of moves and more than 2 moves
                    1 2 3 - yes
                    1 2 - no
                    """);
            return false;
        }
        return true;
    }

    private static boolean equalMovesNotExist(String[] moves){
        HashSet<String> a = new HashSet<>(Arrays.asList(moves));
        if(a.size() != moves.length){
            System.out.println("""
                    You wrong! You must not enter duplicate moves
                    1 2 3 - yes
                    1 2 2 - no
                    """);
            return false;
        }
        return true;
    }

    private static void startGame(String[] moves){
        int computerMove = computerMove(moves);
        SecureRandom random = new SecureRandom();
        byte[] key = random.generateSeed(16);
        byte[] hmac = KeyGenerator.hmacSHA256(key, moves[computerMove].getBytes());
        String hmacString = KeyGenerator.bytesToHex(hmac);
        System.out.println("HMAC: " + hmacString);
        menu(moves);

        String userInput;
        Scanner inScan = new Scanner(System.in);
        while (true){
            System.out.print("Enter Your move: ");
            userInput = inScan.nextLine();
            if (userInput.equals("0")) System.exit(0);
            if (userInput.equals("?")){
                CreateTable.helpTable(moves);
                continue;
            }
            if (userMoveIsCorrect(userInput, moves.length))
                break;
            System.out.println("No such command! Try again");
        }
        System.out.println("Your move: " + moves[Integer.parseInt(userInput) - 1]);
        System.out.println("Computer move: " + moves[computerMove]);
        System.out.println(Winner.victoryRules(Integer.parseInt(userInput) - 1,
                computerMove, moves.length));
        System.out.println("HMAC key: " + KeyGenerator.bytesToHex(key));
    }

    private static boolean userMoveIsCorrect(String input, int numberOfMoves){
        for (int i = 1; i <= numberOfMoves; i++) {
            if (Integer.toString(i).equals(input))
                return true;
        }
        return false;
    }

    private static void menu(String[] moves) {
        System.out.println("Available moves:");
        for (int i = 0; i < moves.length; i++) {
            System.out.println(i + 1 + " - " + moves[i]);
        }
        System.out.println("0 - exit\n? - help");
    }

    private static int computerMove(String[] moves) {
        SecureRandom random = new SecureRandom();
        byte[] randomByte = random.generateSeed(1);
        return (randomByte[0] - Byte.MIN_VALUE) / ((Byte.MAX_VALUE - Byte.MIN_VALUE) / moves.length);
    }
}
