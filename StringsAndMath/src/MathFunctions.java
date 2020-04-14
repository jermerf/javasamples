public class MathFunctions {

    public static void main(String[] args){
        double num = 1.1;
        System.out.println(Math.floor(num));

        int[] freq = new int[102];

        for(int i=0; i<1000000; i++){
            int rand = (int)Math.ceil( Math.random() * 100);
            freq[rand]++;
        }
        for(int i=0; i<freq.length; i++){
            System.out.println(i + ": " + freq[i]);
        }

    }

}
