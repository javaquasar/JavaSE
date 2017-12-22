package core.lecture3_03_Own_containers.practice.task_5_02;

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
	private Node parent = root;

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
			System.out.println(currentNode + "\nлевый потомок:" + currentNode.leftChild + "  правый потомок :" + currentNode.rightChild);
			traverseTree(currentNode.rightChild);
		}
	}

	public void traverseTree() {
		traverseTree(root);
	}

	public void clear(Node el) {
		el.key = 0;
		el.leftChild = null;
		el.rightChild = null;
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

	public void deleteNodeByKey(int key) {
		Node focusNode = root;
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				parent = focusNode;
				focusNode = focusNode.leftChild;
				if (focusNode.key == key) {

					if (focusNode.leftChild == null
							&& focusNode.rightChild == null) {
						parent.leftChild = null;
					}

					if (focusNode.leftChild != null
							&& focusNode.rightChild == null) {
						parent.leftChild = focusNode.leftChild;
					}

					if (focusNode.leftChild == null
							&& focusNode.rightChild != null) {
						parent.leftChild = focusNode.rightChild;
					}

					if (focusNode.leftChild != null
							&& focusNode.rightChild != null) {
						Node copyFocus = focusNode;
						// родитель для copyFocus
						Node secondParent = copyFocus;
						copyFocus = copyFocus.rightChild;
						boolean a = false;

						while (copyFocus.leftChild != null) {
							secondParent = copyFocus;
							copyFocus = copyFocus.leftChild;
							a = true;
						}
						// нашли минимальный элемент справа
						focusNode.key = copyFocus.key;
						focusNode.value = copyFocus.value;

						if (copyFocus.leftChild == null
								&& copyFocus.rightChild == null) {
							if (secondParent.rightChild == copyFocus) {
								secondParent.rightChild = null;
								break;
							} else {
								secondParent.leftChild = null;
								break;
							}
						} else {
							if (!a) {
								secondParent.rightChild = copyFocus.rightChild;
								break;
							} else {
								secondParent.leftChild = copyFocus.rightChild;
								break;
							}
						}

					}

				}
			} else {
				parent = focusNode;
				focusNode = focusNode.rightChild;
				if (focusNode.key == key) {

					if (focusNode.leftChild == null
							&& focusNode.rightChild == null) {
						parent.rightChild = null;
					}

					if (focusNode.leftChild != null
							&& focusNode.rightChild == null) {
						parent.rightChild = focusNode.leftChild;
					}

					if (focusNode.leftChild == null
							&& focusNode.rightChild != null) {
						parent.rightChild = focusNode.rightChild;
					}

					if (focusNode.leftChild != null
							&& focusNode.rightChild != null) {
						Node copyFocus = focusNode;
						// родитель для copyFocus
						Node secondParent = copyFocus;
						copyFocus = copyFocus.rightChild;
						boolean a = false;

						while (copyFocus.leftChild != null) {
							secondParent = copyFocus;
							copyFocus = copyFocus.leftChild;
							a = true;
						}
						// нашли минимальный элемент справа
						focusNode.key = copyFocus.key;
						focusNode.value = copyFocus.value;

						if (copyFocus.leftChild == null
								&& copyFocus.rightChild == null) {
							if (secondParent.rightChild == copyFocus) {
								secondParent.rightChild = null;
								break;
							} else {
								secondParent.leftChild = null;
								break;
							}
						} else {
							if (!a) {
								secondParent.rightChild = copyFocus.rightChild;
								break;
							} else {
								secondParent.leftChild = copyFocus.rightChild;
								break;
							}
						}

					}

				}

			}
			if (focusNode == null)
				return;
		}

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
		System.out.println();
		// continents.deleteNodeByKey(4);
		continents.deleteNodeByKey(3);
		continents.traverseTree();
		System.out.println();
		continents.deleteNodeByKey(4);
		continents.traverseTree();
		
		System.out.println();
		continents.deleteNodeByKey(5);
		continents.traverseTree();
	}
}
