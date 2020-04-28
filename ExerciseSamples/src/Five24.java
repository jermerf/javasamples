public class Five24 {
    public static void main(String[] args) {
        double total = 0;
        for(int i=1; i<=97; i+=2){
            total += i / (i+2.0);
        }
        System.out.println("Ans: " + total);
    }
}
