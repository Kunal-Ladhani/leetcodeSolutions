class Node {
    public int key;
    public Node next;

    public Node() {
        this.key = -1;
        this.next = null;
    }
}

class MyHashSet {
    public static final int MAX_CAPACITY = 1 << 20;
    public static final int INITIAL_CAPACITY = 4;
    
    public Node[] map;
    public int size;
    public int capacity; 
    
    public MyHashSet() {
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
        this.map = new Node[INITIAL_CAPACITY];
        for (int i=0; i<this.capacity; i++) {
            this.map[i] = null;
        }
    }
    
    public void add(int key) {
        // you should not add key already present in hashset
        if (contains(key)) {
            return;
        }

        if (this.size + 1 > this.capacity) {
            reHash();
        }

        Node head = getBucketNode(key);
        Node newNode = new Node();
        newNode.key = key;

        // this is first node in bucket
        if (head == null) {
            this.map[key % this.capacity] = newNode;
            this.size++;
            return;
        }

        // linked list already exists
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        this.size++;
    }
    
    public void remove(int key) {
        Node head = getBucketNode(key);
        if (head == null) {
            return;
        }

        // delete the first one
        if (head.key == key) {
            this.map[key % this.capacity] = head.next;
            head.next = null;
            this.size--;
            return;
        }

        Node curr = head;
        Node prev = head;
        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next;
                curr.next = null;
                this.size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        Node head = getBucketNode(key);
        if (head == null)
            return false;
        Node curr = head;
        while (curr != null) {
            if (curr.key == key)
                return true;
            curr = curr.next;
        }
        return false;
    }

    // -------- helper methods --------

    private Node getBucketNode(int key) {
        return map[key % this.capacity];
    }

    private void reHash() {
        int newCapacity = this.capacity * 2;
        if (newCapacity > MAX_CAPACITY) {
            // you can throw OOM error here!
            return;
        }

        Node[] newMap = new Node[newCapacity];

        for (int i=0; i<this.capacity; i++) {
            Node curr = this.map[i];
            
            while (curr != null) {
                Node next = curr.next;

                int newIndex = curr.key % newCapacity;

                curr.next = newMap[newIndex];
                newMap[newIndex] = curr;

                curr = next;
            }
        }

        this.map = newMap;
        this.capacity = newCapacity;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */