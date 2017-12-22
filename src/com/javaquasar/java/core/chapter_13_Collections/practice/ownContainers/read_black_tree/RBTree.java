package com.javaquasar.java.core.chapter_13_Collections.practice.ownContainers.read_black_tree;

class RedBlackTree {
	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private class Node {
		int key;
		String value;
		Node leftChild;
		Node rightChild;
		Node parent;

		boolean color;

		private Node(int key, String value, boolean color) {
			this.key = key;
			this.value = value;
			this.color = color;
		}

		private Node(boolean color, Node rightChild, Node leftChild, String value, int key) {
			this.color = color;
			this.rightChild = rightChild;
			this.leftChild = leftChild;
			if (leftChild != null)
				leftChild.parent = this;
			if (rightChild != null)
				leftChild.parent = this;
			parent = null;
			this.value = value;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Key: " + key + " Value:" + value;
		}
	}

	Node root;

	// Левый поворот
	private Node leftTurn(Node root) {
		Node newRoot = root.rightChild;
		root.rightChild = newRoot.leftChild;
		newRoot.leftChild = root;
		return newRoot;
	}

	// Правый поворот
	private Node rightTurn(Node root) {
		Node newRoot = root.leftChild;
		root.leftChild = newRoot.rightChild;
		newRoot.rightChild = root;
		return newRoot;
	}

	private Node grandparent(Node node) {
		if (node != null && node.parent != null) {
			return node.parent.parent;
		} else {
			return null;
		}
	}

	private Node uncle(Node node) {
		Node g = grandparent(node);
		if (g == null) {
			return null;
		}
		if (node.parent == g.leftChild) {
			return g.rightChild;
		} else
			return g.leftChild;
	}

	private Node sibling(Node node) {
		if (node == node.parent.rightChild) {
			return node.parent.leftChild;
		} else {
			return node.parent.rightChild;
		}
	}

	private Node insertCase1(Node node) {
		if (node.parent == null) {
			node.color = false;
			return node;
		} else
			return insertCase2(node);
	}

	private Node insertCase2(Node node) {
		if (node.parent.color == false) {
			return node;
		} else {
			return insertCase3(node);
		}
	}

	private Node insertCase3(Node node) {
		Node uncle = uncle(node);
		Node g;
		if (uncle != null && uncle.color == true && node.parent.color == true) {
			node.parent.color = false;
			uncle.color = false;
			g = grandparent(node);
			g.color = true;
			return insertCase2(g);
		} else {
			return insertCase4(node);
		}
	}

	private Node insertCase4(Node node) {
		Node g = grandparent(node);
		if (node == node.parent.rightChild && node.parent == g.leftChild) {
			leftTurn(node.parent);
			node = node.leftChild;
		} else if (node == node.parent.leftChild && node.parent == g.rightChild) {
			rightTurn(node.parent);
			node = node.rightChild;
		}
		return insertCase5(node);
	}

	private Node insertCase5(Node node) {
		Node g = grandparent(node);
		node.parent.color = false;
		g.color = true;
		if (node == node.parent.leftChild && node.parent == g.leftChild) {
			rightTurn(g);
		} else {
			leftTurn(g);
		}
		return node;
	}

	public void traverseTree(Node currentNode) {
		if (currentNode != null) {
			traverseTree(currentNode.leftChild);
			System.out.println(currentNode + "\nлевый потомок:" + currentNode.leftChild + "  правый потомок :" + currentNode.rightChild);
			traverseTree(currentNode.rightChild);
		}
	}

	public void traverseTree() {
		traverseTree(root);
	}

	// Добавить узел
	public void addNode(int key, String value) {
		// Создаем новый узел:
		Node newNode = new Node(key, value, true);
		newNode.leftChild = null;
		newNode.rightChild = null;
		if (root == null) { // первый добавленный узел
			newNode.color = false;
			root = newNode;
		} else {
			// Начинаем обход:
			Node currentNode = root;
			Node parent;
			while (true) {
				parent = currentNode;
				// Проверяем ключи:
				if (key < currentNode.key) {
					currentNode = currentNode.leftChild;
					if (currentNode == null) {
						// Помещаем узел в нужное место:
						parent.leftChild = insertCase1(newNode);
						return;
					}
				} else {
					currentNode = currentNode.rightChild;
					if (currentNode == null) {
						// Помещаем узел в нужное место:
						parent.rightChild = insertCase1(newNode);
						return;
					}
				}
			}
		}
	}

	// Поиск узла по ключу
	public Node findNode(int key) {
		Node focusNode = root;
		while (focusNode.key != key) {
			if (key < focusNode.key)
				focusNode = focusNode.leftChild;
			else
				focusNode = focusNode.rightChild;
			// Не нашли:
			if (focusNode == null)
				return null;
		}
		return focusNode;
	}

	// Красный или нет
	private boolean isRed(Node node) {
		if (node == null)
			return false;
		return node.color == RED;
	}
}

public class RBTree {
	public static void main(String[] args) {
		RedBlackTree continents = new RedBlackTree();
		continents.addNode(1, "Европа");
		continents.addNode(3, "Африка");
		continents.addNode(5, "Австралия");
		continents.addNode(4, "Америка");
		continents.addNode(2, "Азия");
		continents.addNode(6, "Антарктида");
		continents.traverseTree();
	}
}
