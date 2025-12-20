class Node {
    public Node next;
    public int key;
    public int value;

    public Node() {
        this.key = -1;  // AS ALL VALUES ARE >= 0
        this.value = -1;
        this.next = null;
    }
}

class MyHashMap {

    public static final int INITIAL_SIZE = 4;
    public static final int MAX_CAPACITY = 1 << 20;
    
    public int nodes;
    public int size;
    private Node[] map;

    public MyHashMap() {
        this.nodes = 0;
        this.size = INITIAL_SIZE;
        map = new Node[INITIAL_SIZE];

        for (int i=0; i<this.size; i++) {
            this.map[i] = new Node();
        }
    }
    
    public void put(int key, int value) {
        if (this.nodes + 1 > this.size) {
            reHash();
        }
        Node head = getBucketHead(key);

        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            // key exists in that bucket
            // so we do not increase no of nodes
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        prev.next = newNode;
        this.nodes++;
    }
    
    public int get(int key) {
        Node head = getBucketHead(key);
        Node curr = head.next;
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        Node head = getBucketHead(key);

        Node curr = head.next;
        Node prev = head;
        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next;
                curr.next = null;
                this.nodes--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // ------- helper methods -------
    private Node getBucketHead(int key) {
        return map[key % this.size];
    }

    private void reHash() {
        int newSize = this.size * 2;
        if (newSize > MAX_CAPACITY) {
            return;
        }

        Node[] newMap = new Node[newSize];
        for (int i = 0; i < newSize; i++) {
            newMap[i] = new Node(); // dummy head
        }

        for (int i = 0; i < this.size; i++) {
            Node curr = map[i].next; // SKIP dummy

            while (curr != null) {
                Node next = curr.next;

                int newIdx = curr.key & (newSize - 1);
                curr.next = newMap[newIdx].next;
                newMap[newIdx].next = curr;

                curr = next;
            }
        }

        this.map = newMap;
        this.size = newSize;
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */