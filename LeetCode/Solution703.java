import java.util.PriorityQueue;

public class Solution703 {
    PriorityQueue<Integer> q=new PriorityQueue<>();
    int k;
    public Solution703(int k, int[] nums) {
        this.k=k;
        for (int num:nums){
            if (q.size()<k) q.add(num);
            else {
                if (q.peek()<num){
                    q.poll();
                    q.add(num);
                }
            }
        }
    }

    public int add(int val) {
        if (q.size()<k) q.add(val);
        else{
            if (q.peek()<val){
                q.poll();
                q.add(val);
            }
        }
        return q.peek();
    }
}
