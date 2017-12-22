package core.lecture3_05_IO_Stream.practice.task_5_08_huffman.tree;

public class CodeMaker {

	private String[] codes;
	private Node rootNode;

	public CodeMaker(Heap heap) {

		int n = heap.size() - 1;
		for (int i = 0; i < n; i++) {
			Node hNode = new Node();
			Node x = heap.getMin();
			Node y = heap.getMin();
			hNode.left = x;
			hNode.right = y;
			hNode.freq = x.freq + y.freq;
			heap.add(hNode);
		}
		this.rootNode = heap.getMin();
		this.codes = new String[256];
	}


	public String[] getCodes() {
		makeCodes(this.rootNode, "");
		return this.codes;
	}

	public void makeCodes(Node x, String code) {
		if (x != null) {
			makeCodes(x.left, code + "0");
			if (x.left == null && x.right == null) {
				this.codes[x.ch] = code;
			}
			makeCodes(x.right, code + "1");
		}
	}
}
