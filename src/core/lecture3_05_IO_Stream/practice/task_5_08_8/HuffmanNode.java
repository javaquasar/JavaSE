package core.lecture3_05_IO_Stream.practice.task_5_08_8;
// Michael Mazique
// CSE 143, Autumn 2013
// Section AI, Martin Reyes
// Constructs a HuffmanNode object�that is used to Encode/Decode files

public class HuffmanNode implements Comparable<HuffmanNode> {
	public int frequency;     // Frequency stored in this node
	public int letter;        // Character stored in this node
	public HuffmanNode left;  // Reference to left subtree
	public HuffmanNode right; // Reference to right subtree
  
  
  	public HuffmanNode(int frequency) {
      this(frequency, 0);
	}
		
	public HuffmanNode(int frequency, int letter) {
		this.frequency = frequency;
		this.letter = letter;
	}
 
	// Compares frequencies of two HuffmanNodes
	public int compareTo(HuffmanNode other) {
		return frequency - other.frequency;
	}
}