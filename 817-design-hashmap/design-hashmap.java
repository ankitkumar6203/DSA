class MyHashMap {
    public static class Node{
        int key, value;
        Node(int k, int v){
            key = k;
            value = v;
        }
    }
    private final int Size = 769;
    private List<Node>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[Size];
        for(int i=0;i<Size;i++){
            buckets[i] = new LinkedList<>();
        }
    
    }

    private int hash(int key) {
        return key % Size;
    }
    
    public void put(int key, int value) {
        int index=hash(key);
        for(Node node : buckets[index]){
            if(node.key == key){
                node.value = value;
                return;
            }
        }
        buckets[index].add(new Node(key, value));
    }
    
    public int get(int key) {
        int index = hash(key);
        for (Node node : buckets[index]) {
            if (node.key == key) return node.value;
        }
        return -1;
    }
    public void remove(int key) {
        int index = hash(key);
        Iterator<Node> it = buckets[index].iterator();
        while(it.hasNext()){
            if(it.next().key==key){
                it.remove();
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */