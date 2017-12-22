package core.lecture3_05_IO_Stream.practice.task_5_08_huffman.tree;

public class Heap {

	private Node[] checkList;
	private Node[] heap;
	private int heapSize;

	public Heap() {
		this.checkList = new Node[256];
		this.heap = new Node[256];
		this.heapSize = 0;
	}

	public void addOrIncrement(Node n) {
		if (checkList[n.b + 128] != null) {
			checkList[n.b + 128].freq++;
		} else {
			this.add(n);
		}
	}

	public void add(Node n) {
		checkList[n.b + 128] = n;
		heap[heapSize] = n;
		siftUp(heapSize);
		heapSize++;
	}

	public int size() {
		return heapSize;
	}

	public Node getMin() {
		if (isEmpty()) {
			throw new RuntimeException("Keko on tyhjä!");
		}
		Node n = heap[0];
		heap[0] = heap[heapSize - 1];
		if (--heapSize > 0) {
			siftDown(0);
		}
		return n;
	}

	public boolean isEmpty() {
		if (this.heapSize == 0) {
			return true;
		} else {
			return false;
		}
	}

	private void siftDown(int i) {
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;
		if (rightChild >= heapSize && leftChild >= heapSize) {
			return;
		}
		int smallestChild = heap[rightChild].freq > heap[leftChild].freq ? leftChild
				: rightChild;
		if (heap[i].freq > heap[smallestChild].freq) {
			swap(smallestChild, i);
			siftDown(smallestChild);
		}
	}

	private void swap(int i, int j) {
		Node temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private void siftUp(int i) {
		if (i > 0) {
			int parent = (i - 1) / 2;
			if (heap[parent].freq > heap[i].freq) {
				swap(parent, i);
				siftUp(parent);
			}
		}
	}

}
