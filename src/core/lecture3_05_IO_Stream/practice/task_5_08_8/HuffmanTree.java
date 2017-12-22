package core.lecture3_05_IO_Stream.practice.task_5_08_8;
// Michael Mazique
// CSE 143, Autumn 2013
// Section AI, Martin Reyes
// HuffmanTree

import java.util.*;
import java.io.*;

public class HuffmanTree {
	private HuffmanNode overallRoot;

	// constructs a HuffmanTree object that uses a binary tree to sort given letters of a file, 
   // according to each letter's frequency
	public HuffmanTree(int[] count) {
		Queue<HuffmanNode> order = new PriorityQueue<HuffmanNode>();
		
      
      for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) // does not add letters with frequencies of zero
				order.add(new HuffmanNode(count[i], i));	 
		   if (i == 0)
            order.add(new HuffmanNode(1, i + 1));
      }
		while (order.size() > 1) { // priority queue still has more nodes to add to the tree
			
         // there will always be at least the overallRoot node 
         // and another node if it enters the while loop
         HuffmanNode a = order.remove();
			HuffmanNode b = order.remove(); 
         
			HuffmanNode sum = new HuffmanNode(a.frequency + b.frequency);
			sum.left = a;
			sum.right = b;
			order.add(sum);
		}
		overallRoot = order.remove(); // last node in the PriorityQueue will be the tree
	}
	
	// reconstructs the tree from a given file in standard format
	public HuffmanTree(Scanner input) {
		while(input.hasNextLine()) {
			int letter = Integer.parseInt(input.nextLine());
			String binary = "" + input.nextLine(); // char's ASCII value and binary code come in pairs
			overallRoot = makeTree(overallRoot, letter, binary); // creates the tree
		}
	}
	
	// helper method to recreate the tree
	private HuffmanNode makeTree(HuffmanNode root, int letter, String binary) {
		if (binary.length() == 1) { // creates a leaf node containing the letter
			if (binary.charAt(0) == '0') {
				root.left = new HuffmanNode(0, letter);
			}else { // otherwise, it must be 1
				root.right = new HuffmanNode(0, letter);
			}
			
			
		// otherwise, continue recuring while creating new nodes
		}else {	
			if (binary.charAt(0) == '0') {
				if (root.left == null) { // recursively diminish binary's length
					root.left = makeTree(new HuffmanNode(0), letter, binary.substring(1, binary.length()));
				}else {
					makeTree(root.left, letter, binary.substring(1, binary.length()));
				}
			}else { // otherwise, it must be 1
				if (root.right == null) {
					root.right = new HuffmanNode(0);
				}else {
					makeTree(root.right, letter, binary.substring(1, binary.length()));
				}
			}		
		}
		return root;
	}		
	
	
	// stores the current tree to an output file
	public void write(PrintStream output) {
		String code = "";
		write(output, overallRoot, code);
	}
	
	
	// helper method to store the tree to an output file
	private void write(PrintStream output, HuffmanNode root, String code) {
		if (root.left == null && root.right == null){
			output.println(root.letter); // println the letter to the file
			output.println(code);        // println the binary code to the file
			
		}else { 
			write(output, root.left, code += 0);  // recurse through the next node in the tree
			write(output, root.right, code += 1); // pre-order traversal
		}
	}
	
	
	// reads individual bits from the input stream and writes the corresponding characters 
   // to the output
	public void decode(BitInputStream input, PrintStream output, int eof) {
		addEndOfFile(overallRoot, eof); // Add the end of file character to the far right of the tree
	
      HuffmanNode root = findChar(overallRoot, input, output); // 
		
		while (root.letter != eof) {
			root = findChar(root, input, output); // Find the letter in the tree
		}
		output.print(root.letter);
	}
	
   
	// find the character in the tree by following the pattern given by the binary code
	private HuffmanNode findChar(HuffmanNode root, BitInputStream input, PrintStream output) {
		if (root.left == null && root.right == null) {
			output.print((int) root.letter);
			return root;
		}else {
			if (input.readBit() == 0) {
				root.left = findChar(root.left, input, output);
			}else if (input.readBit() == 1) {
				root.right = findChar(root.right, input, output);
			} 
		}
		return root;
	}
   
   private void addEndOfFile(HuffmanNode root, int eof) {
      if (root.right == null)
         root.right = new HuffmanNode(1, eof);
      else  
         addEndOfFile(root.right, eof);
   }
}
