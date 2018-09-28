import java.util.TreeMap;

/**
 * Created by steven.
 * Date: 29/9/18
 * Problem: https://leetcode.com/problems/car-fleet/description/
 * Tags: 
 * Algo: 
 * TimeComplexity: O(nlogn)
 * SpaceComplexity: O(n)
 */
 
public class CarFleet {
    public static void main(String[] args) {
        System.out.println(carFleet(12, new int[] {10,8,0,5,3}, new int[] {2,4,1,1,3}));
        System.out.println(carFleet(10, new int[] {6, 8}, new int[] {3,2}));
    }
    public static int carFleet(int target, int[] pos, int[] speed) {
        TreeMap<Integer, Double> m = new TreeMap<>();

        for (int i = 0; i < pos.length; i++) {
            double time = (target - pos[i])*1.0/speed[i];
            m.put(-pos[i], time);
        }

        int res = 0;
        double cur = 0;

        System.out.println(m);

        for (double time: m.values()) {
            if (time > cur) {
                res += 1;
                cur = time;
            }
        }
        return res;
    }
}
