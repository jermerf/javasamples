public class Five50pdf {
    public static void main(String[] args) {
        for(int i=1; i<=9; i++) {
            int j = 1;
            while(j<=9) {
                System.out.print(j + "*" + i + "= " + (i*j) + "\t");
                j++;
            }
            System.out.println();
        }
    }
}
