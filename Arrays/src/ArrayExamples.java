import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayExamples {

    static final int N_SIZE = 10;

    public static void main(String[] args) {
//        fillArray();
//        copyArrays();
//        constantArray();
        theNextDimension();
    }


    public static void constantArray(){
        int[] ofConstantSize = new int[N_SIZE];
    }

    public static void fillArray(){
        String[] people = new String[5];
        Scanner input = new Scanner(System.in);

        for(int i=0; i<people.length; i++ ){
            people[i] = input.nextLine();
        }

        // Data acquired
        // -------
        // Display data
        for(int i=0; i<people.length; i++) {
            System.out.print(people[i] + ", ");
        }

        // For Each
        for(String indiv : people){
            System.out.print(indiv + ", ");
        }

        System.out.println(Arrays.toString(people));
    }

    public static void copyArrays(){
        int[] evens = new int[10];
        for(int i=0; i<evens.length; i++) {
            evens[i] = i*2;
        }

        int x = 7;
        int y = x;

        y = 8;

        // This passes a reference
//         int[] copyEvens = evens;

        // This would change both since they are the same
        // copyEvens[0] = -404;

        // We need a deep copy
        // Slow long way
        int[] copyEvens = new int[evens.length];
        for(int i=0; i<evens.length; i++) {
            copyEvens[i] = evens[i];
        }

        int[] fastCopy = new int[evens.length];
        System.arraycopy(evens, 0, fastCopy, 0, evens.length);

        System.out.println(Arrays.toString(fastCopy));
    }

    public static void theNextDimension(){
        int[][] grid = new int[10][4];

        for(int y=0; y<grid.length; y++){
            int[] innerList = grid[y];
            for(int x=0; x<innerList.length; x++ ) {
                innerList[x] = x * y;
            }
        }
        print2D(grid);

        int[][] directGrid = new int[10][4];

        for(int y=0; y<directGrid.length; y++){
            for(int x=0; x<directGrid[y].length; x++ ) {
                directGrid[x][y] = x * y;
            }
        }
        print2D(directGrid);

    }

    public static int[][] makeGrid(int h, int w) {
        int[][] grid = new int[h][w];

        for(int y=0; y<grid.length; y++){
            int[] innerList = grid[y];
            for(int x=0; x<innerList.length; x++ ) {
                innerList[x] = x * y;
            }
        }
        return grid;
    }

    public static void print2D(int[][] grid) {
        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }
    }
}
