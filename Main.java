import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean control = true;
        int player1Wins = 0;
        int player2Wins = 0;
        while(control){
            //get user input
            System.out.println("Player 1: enter rock, paper, scissors, or the corresponding number");
            String playerInput1 = input.next();
            System.out.println("Player 2: enter rock, paper, scissors, or the corresponding number");
            String playerInput2 = input.next();
            // parse input in the parseInput method
            int player1Num = parseInput(playerInput1);
            int player2Num = parseInput(playerInput2);

            if(player1Num == player2Num){
                System.out.println("Tie");
            } else if((player1Num + 1) % 3 == player2Num % 3){
                System.out.println("Player 2 wins");
                player2Wins++;
            } else{
                System.out.println("Player 1 wins");
                player1Wins++;
            }

            System.out.println("Play again? y/n");
            if(Objects.equals(input.next(), "y")){
                control = true;
            }else {
                control = false;
            }
        }
        System.out.println("Player 1 wins:" + player1Wins + "\nPlayer 2 wins:" + player2Wins);
    }

    //parse input method to parse the user input into an integer, if the user inputs a string that matches
    //the hashmap key value pair, the key is returned
    private static Integer parseInput(String input){
        HashMap<Integer, String> selection = new HashMap<>();
        selection.put(1, "rock");
        selection.put(2, "paper");
        selection.put(3, "scissors");

        int number = 0;
        try{
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            for (Map.Entry<Integer, String> entry : selection.entrySet()) {
                if (entry.getValue().equals(input)) {
                    number = entry.getKey();
                }
            }
        }
        return number;
    }
}