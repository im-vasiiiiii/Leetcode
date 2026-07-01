import java.util.*;

class SmallestInfiniteSet {
    private PriorityQueue<Integer> heap;
    private Set<Integer> inHeap;
    private int current;
    
    public SmallestInfiniteSet() {
        heap = new PriorityQueue<>();
        inHeap = new HashSet<>();
        current = 1;
    }
    
    public int popSmallest() {
        if (!heap.isEmpty()) {
            int val = heap.poll();
            inHeap.remove(val);
            return val;
        }
        return current++;
    }
    
    public void addBack(int num) {
        if (num < current && !inHeap.contains(num)) {
            heap.offer(num);
            inHeap.add(num);
        }
    }
    
    // Quick test
    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    
        System.out.println(smallestInfiniteSet.popSmallest()); // 1
        System.out.println(smallestInfiniteSet.popSmallest()); // 2
        System.out.println(smallestInfiniteSet.popSmallest()); // 3
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest()); // 1
        System.out.println(smallestInfiniteSet.popSmallest()); // 4
        System.out.println(smallestInfiniteSet.popSmallest()); // 5
    }
}
