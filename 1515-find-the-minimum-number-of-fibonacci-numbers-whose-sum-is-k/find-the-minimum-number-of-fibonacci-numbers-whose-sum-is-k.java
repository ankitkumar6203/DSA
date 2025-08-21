class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        while(fib.get(fib.size()-1)<k){
            int size = fib.size();
            fib.add(fib.get(size-1)+fib.get(size-2));
        }
        int count = 0;
        int i = fib.size()-1;
        while(k>0){
            if(fib.get(i)<=k){
                k = k-fib.get(i);
                count++;
            }
            i--;
        }
        return count;
    }
}