package core.lecture3_05_IO_Stream.practice.task_5_08_huffman.io;

import java.io.FileOutputStream;
import java.io.IOException;

import core.lecture3_05_IO_Stream.practice.task_5_08_huffman.tree.Node;

public class BinaryWriter {
    
    private Node root;
    boolean[] buffer;
    int mark;
    Node treeMark;
    FileOutputStream fout;
    
    public BinaryWriter(FileOutputStream fo) {
        this.root = new Node();
        this.buffer = new boolean[256];
        this.mark = 0;
        this.fout = fo;
        this.treeMark = this.root;
    }
    
    public void addCode(byte b, String code) {
        Node currentNode = this.root;
        
        for (int i = 0; i < code.length(); i++) {
            
            if (code.charAt(i) == '0') {
                if (currentNode.left == null) {
                    currentNode.left = new Node();
                }
                currentNode = currentNode.left;
            }
            else {
                if (currentNode.right == null) {
                    currentNode.right = new Node();
                }
                currentNode = currentNode.right;
            }
        }
        currentNode.b = b;
    }
    
    public void addByte(int b, boolean stop) throws IOException {
        boolean[] bits = byteToBits(b);
        int end = 8;
        
        
        if (stop) {
            int trashBits = b;
            mark -= trashBits;
        }
        else {
            for (int i = 0; i < 8; i++) {
                this.buffer[mark] = bits[i];
                mark++;
            }
        }

        if (mark > 248 || stop) {
            processBuffer();
        }
        
        
    }
    
    private static boolean[] byteToBits(int data) {
            if (data < 0 || 255 < data) {
                    throw new IllegalArgumentException("" + data);
            }

            boolean[] bits = new boolean[8];
            for (int i=0; i < 8; i++) {
                    bits[i] = ( (data & (1 << (7-i)) ) != 0 );
            }
            return bits;
    }

    private void processBuffer() throws IOException {
        int i = 0;       

        while (i < mark) {

            if (treeMark.b != 0) {
                fout.write((int) treeMark.b);
                treeMark = this.root;
            }
            else if (!buffer[i]) {
                treeMark=treeMark.left;
                i++;
            }
            else if (buffer[i]) {
                treeMark=treeMark.right;
                i++;
            }
        }
        if (treeMark.b != 0) {
                fout.write((int) treeMark.b);
                treeMark = this.root;
        }
        
        this.buffer = new boolean[256];
        this.mark = 0;
        
    }
}
