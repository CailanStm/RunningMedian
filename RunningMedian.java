import java.util.*;

public class RunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        findMedians(a);
    }
    
    public static void findMedians(int[] inputs) {
        PriorityQueue<Integer> leftHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> rightHeap = new PriorityQueue<Integer>();

        for (int i = 0; i < inputs.length; i++) {
            int currNum = inputs[i];

            int leftSize = leftHeap.size();
            int rightSize = rightHeap.size();
            if (leftSize == rightSize) {
                if (rightSize > 0 && currNum > rightHeap.peek()) {
                    leftHeap.add(rightHeap.poll());
                    rightHeap.add(currNum);
                } else {
                    leftHeap.add(currNum);
                }
                double median = leftHeap.peek() / 1.0;
                System.out.printf("%.1f\n", median);
            } else {
                if (currNum < leftHeap.peek()) {
                    rightHeap.add(leftHeap.poll());
                    leftHeap.add(currNum);
                } else {
                    rightHeap.add(currNum);
                }
                double median = (leftHeap.peek() + rightHeap.peek()) / 2.0;
                System.out.printf("%.1f\n", median);
            }
        }
    }
}
