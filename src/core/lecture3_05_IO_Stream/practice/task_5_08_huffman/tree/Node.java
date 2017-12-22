package core.lecture3_05_IO_Stream.practice.task_5_08_huffman.tree;


public class Node implements Comparable{

    public long freq;
    public byte b;
    public Node left;
    public Node right;
    public int ch;
    
    public Node(byte b, long freq) {
        this(b);
        this.freq = freq;
    }
    
    public Node(byte b) {
        this();
        this.freq = 1;
        this.b = b;
        this.ch = (int) b & 0xff;
    }
    
    public Node() {
        this.freq = 0;
        this.left = null;
        this.right = null;
    }
    

    public int compareTo(Object t) {
        Node n = (Node) t;
        if (this.freq == n.freq) {
            return 0;
        }
        else if (this.freq > n.freq) {
            return 1;
        }
        else {
            return -1;
        }
    }
    
}
