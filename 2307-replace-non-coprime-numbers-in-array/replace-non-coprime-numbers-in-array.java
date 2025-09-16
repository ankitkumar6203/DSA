import java.util.*;

public class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        
        for (int x : nums) {
            stack.add(x);
            // Keep merging while top two elements are non-coprime
            while (stack.size() > 1) {
                int last = stack.get(stack.size() - 1);
                int secondLast = stack.get(stack.size() - 2);
                int g = gcd(last, secondLast);
                if (g == 1) {
                    break;
                }
                // they are non-coprime, so merge
                long lcm = lcm((long)last, (long)secondLast, g);
                // pop last
                stack.remove(stack.size() - 1);
                // replace secondLast with lcm
                stack.set(stack.size() - 1, (int)lcm);
            }
        }
        
        return stack;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    
    private long lcm(long a, long b, int g) {
        return (a / g) * b;
    }
}
