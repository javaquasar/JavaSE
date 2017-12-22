package com.javaquasar.java.core.chapter_13_Collections.example.ownContainers;

public class BinaryTree {

	// Класс для представления узла
	public static class Node {
		int key;
		String value;
		Node leftChild;
		Node rightChild;

		Node(int key, String name) {
			this.key = key;
			this.value = name;
		}

		public String toString() {
			return "Key: " + key + " Value:" + value;
		}
	}

	private Node root;

	public void addNode(int key, String value) {
		// Создаем новый узел:
		Node newNode = new Node(key, value);
		if (root == null) { // первый добавленный узел
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
						parent.leftChild = newNode;
						return;
					}
				} else {
					currentNode = currentNode.rightChild;
					if (currentNode == null) {
						// Помещаем узел в нужное место:
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	// Обход узлов в порядке возрастания ключей
	public void traverseTree(Node currentNode) {
		if (currentNode != null) {
			traverseTree(currentNode.leftChild);
			System.out.println(currentNode);
			traverseTree(currentNode.rightChild);
		}
	}

	public void traverseTree() {
		traverseTree(root);
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

	// Тест:
	public static void main(String[] args) {
		BinaryTree continents = new BinaryTree();
		continents.addNode(1, "Европа");
		continents.addNode(3, "Африка");
		continents.addNode(5, "Австралия");
		continents.addNode(4, "Америка");
		continents.addNode(2, "Азия");
		continents.addNode(6, "Антарктида");
		continents.traverseTree();
		System.out.println("\nКонтинент с ключом 4:");
		System.out.println(continents.findNode(4));
	}
}
