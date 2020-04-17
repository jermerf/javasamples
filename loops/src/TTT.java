import java.util.Scanner;

public class TTT {
    /*
        0 1 2
        3 4 5
        6 7 8
     */
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String board = "---------";
        boolean isX = true;

        for(int turn=0; turn<9; turn++) {
            // Print the game board
            for (int i = 0; i < board.length(); i++) {
                if (i % 3 == 0) {
                    System.out.println();
                }
                System.out.print(board.charAt(i) + " ");
            }
            System.out.println("Where would you like to play?");
            // Print play locations
            for (int i = 0; i < board.length(); i++) {
                if (i % 3 == 0) {
                    System.out.println();
                }
                System.out.print(i + " ");
            }
            int playPosition = input.nextInt();
            String newBoard = board.substring(0, playPosition);
            if (isX) {
                newBoard += "X";
            } else {
                newBoard += "O";
            }
            newBoard += board.substring(playPosition + 1);
            board = newBoard;
            // Switches player
            isX = !isX;
        }
    }

}
