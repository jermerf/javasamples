public class ForLoops {
    public static void main(String[] args) {

        int tracker = 0;
        while(tracker < 10){
            System.out.println("Tracker: " + tracker);
            tracker++;
        }

        for(int i=0; i<10; i++) {
            System.out.println("i: " + i);
        }

        // More in Arrays
        int[] ages = {32, 7, 4, 2};
        for(int i=0; i<ages.length; i++) {
            System.out.println(ages[i]);
        }

        for(int val : ages){
            System.out.println(val);
        }


    }
}
