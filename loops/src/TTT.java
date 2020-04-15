import java.util.Scanner;

public class TTT {
    /*
        0 1 2
        3 4 5
        6 7 8
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isX = true;
        String board = "---------";

        for(int turn=0; turn<9; turn++) {
            for (int i = 0; i < board.length(); i++) {
                if (i % 3 == 0) {
                    System.out.println();
                }
                System.out.print(board.charAt(i) + " ");
            }
            System.out.println("Where would you like to play?");
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
            isX = !isX;
            newBoard += board.substring(playPosition + 1);
            board = newBoard;
        }
    }
}
