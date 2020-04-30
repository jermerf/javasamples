package stacksandqueue;

import java.util.Scanner;

public class StackMain {
    public static void main(String[] args) {
        JerStack papers = new JerStack();
        papers.push("Andrew");
        papers.push("Aaron");
        papers.push("Chelsey");
        papers.push("Hannah");
        papers.push("Spencer");

        System.out.println(papers.pop());
        System.out.println(papers.pop());
        System.out.println(papers.pop());
        System.out.println(papers.pop());
        System.out.println(papers.pop());

        Scanner input = new Scanner(System.in);
        int arrSize = 3;
        int[] nums = new int[arrSize];
        for(int i=0; i<arrSize; i++) {
            nums[i] = input.nextInt();
        }
    }
}
