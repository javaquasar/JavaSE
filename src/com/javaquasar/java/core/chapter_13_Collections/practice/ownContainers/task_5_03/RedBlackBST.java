package com.javaquasar.java.core.chapter_13_Collections.practice.ownContainers.task_5_03;

import java.util.NoSuchElementException;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private Node root; // корень BST

	public static void main(String[] args) {
		RedBlackBST<Integer, Integer> st = new RedBlackBST<>();
		Integer[] numbers = { 1, 2, 3, 4, 5, 6 };
		// Integer[] numbers = { 4, 5, 3, 6, 2, 1 };
		for (Integer number : numbers) {
			st.put(number, number + 1);
		}

		st.traverseTree();
		System.out.println("------------------");
		st.put(7, 10);
		st.traverseTree();
		System.out.println("------------------");
		st.delete(4);
		;
		st.traverseTree();
		System.out.println("------------------");

		for (Integer s : st.keys()) {
			System.out.println(s + " " + st.get(s));
		}
		System.out.println();

	}

	// вспомогательный узел типа данных BST
	private class Node {
		private Key key; // ключ
		private Value val; // связанные с ним данные
		private Node left, right; // Ссылки на левые и правые поддерево
		private boolean color; // цвет материнской линии
		private int N; // количество поддеревьев

		public Node(Key key, Value val, boolean color, int N) {
			this.key = key;
			this.val = val;
			this.color = color;
			this.N = N;
		}

		public String toString() {
			return "Key: " + key + " Value:" + val;
		}
	}

	/*************************************************************************
	 * Node вспомогательные методы
	 *************************************************************************/

	// Если node красный - true, если node черный - false, если node = null -
	// false
	private boolean isRed(Node node) {
		if (node == null) {
			return false;
		} else {
			return (node.color == RED);
		}
	}

	// Возвращает количество дочерних узлов node, если node = null - возвращает
	// 0
	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return node.N;
	}

	/*************************************************************************
	 * Методы печати
	 *************************************************************************/

	public void traverseTree(Node currentNode) {
		if (currentNode != null) {
			traverseTree(currentNode.left);
			System.out.println(currentNode + "\nлевый потомок:" + currentNode.left + "  правый потомок :" + currentNode.right);
			traverseTree(currentNode.right);
		}
	}

	public void traverseTree() {
		traverseTree(root);
	}

	/*************************************************************************
	 * Методы для размера
	 *************************************************************************/

	// return number of key-value pairs in this symbol table
	public int size() {
		return size(root);
	}

	// Еслидерево пустое - true
	public boolean isEmpty() {
		return root == null;
	}

	/*************************************************************************
	 * Обычный поиск BST
	 *************************************************************************/

	// Возвращает значение, связанное с заданным ключом; null, если нет такого
	// ключа
	public Value get(Key key) {
		return get(root, key);
	}

	// Возвращает значение по ключу
	private Value get(Node node, Key key) {
		while (node != null) {
			int cmp = key.compareTo(node.key);
			if (cmp < 0) {
				node = node.left;
			} else if (cmp > 0) {
				node = node.right;
			} else {
				return node.val;
			}
		}
		return null;
	}

	// true если есть пара с заданным ключом
	public boolean contains(Key key) {
		return get(key) != null;
	}

	/*************************************************************************
	 * Красно-черная вставка
	 *************************************************************************/

	// Вставляет ключ-значение, если такой ключ уже есть, то значение
	// переписывается
	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.color = BLACK;
		// assert check();
	}

	// вставиляет пару ключ-значение в поддерево с корнем в node
	private Node put(Node node, Key key, Value value) {
		if (node == null) {
			return new Node(key, value, RED, 1);
		}

		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			node.left = put(node.left, key, value);
		} else if (cmp > 0) {
			node.right = put(node.right, key, value);
		} else {
			node.val = value;
		}
		// проводим исправление ссылок
		if (isRed(node.right) && !isRed(node.left)) {
			node = rotateLeft(node);
		}
		if (isRed(node.left) && isRed(node.left.left)) {
			node = rotateRight(node);
		}
		if (isRed(node.left) && isRed(node.right)) {
			flipColors(node);
		}
		node.N = size(node.left) + size(node.right) + 1;

		return node;
	}

	/*************************************************************************
	 * Красно-черное удаление
	 *************************************************************************/

	// удаляет пару ключ-значение с минимальным ключом
	public void deleteMin() {
		if (isEmpty()) {
			throw new NoSuchElementException("BST underflow");
		}

		// Если оба ребенка корня черные, установливаем корень красным
		if (!isRed(root.left) && !isRed(root.right)) {
			root.color = RED;
		}

		root = deleteMin(root);
		if (!isEmpty()) {
			root.color = BLACK;
		}
		// assert check();
	}

	// удаляет пару ключ-значение с минимальным ключом корнем node
	private Node deleteMin(Node node) {
		if (node.left == null) {
			return null;
		}

		if (!isRed(node.left) && !isRed(node.left.left)) {
			node = moveRedLeft(node);
		}

		node.left = deleteMin(node.left);
		return balance(node);
	}

	// удаляет пару ключ-значение с максимальным ключем
	public void deleteMax() {
		if (isEmpty())
			throw new NoSuchElementException("BST underflow");

		// Если оба ребенка корня черные, установливаем корень красным
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;

		root = deleteMax(root);
		if (!isEmpty())
			root.color = BLACK;
		// assert check();
	}

	// удаляет пару ключ-значение с максимальным ключом корнем node
	private Node deleteMax(Node node) {
		if (isRed(node.left)) {
			node = rotateRight(node);
		}

		if (node.right == null) {
			return null;
		}

		if (!isRed(node.right) && !isRed(node.right.left)) {
			node = moveRedRight(node);
		}

		node.right = deleteMax(node.right);

		return balance(node);
	}

	// delete the key-value pair with the given key
	public void delete(Key key) {
		if (!contains(key)) {
			System.err.println("symbol table does not contain " + key);
			return;
		}

		// if both children of root are black, set root to red
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;

		root = delete(root, key);
		if (!isEmpty())
			root.color = BLACK;
		// assert check();
	}

	// delete the key-value pair with the given key rooted at h
	private Node delete(Node h, Key key) {
		// assert get(h, key) != null;

		if (key.compareTo(h.key) < 0) {
			if (!isRed(h.left) && !isRed(h.left.left))
				h = moveRedLeft(h);
			h.left = delete(h.left, key);
		} else {
			if (isRed(h.left))
				h = rotateRight(h);
			if (key.compareTo(h.key) == 0 && (h.right == null))
				return null;
			if (!isRed(h.right) && !isRed(h.right.left))
				h = moveRedRight(h);
			if (key.compareTo(h.key) == 0) {
				Node x = min(h.right);
				h.key = x.key;
				h.val = x.val;
				// h.val = get(h.right, min(h.right).key);
				// h.key = min(h.right).key;
				h.right = deleteMin(h.right);
			} else
				h.right = delete(h.right, key);
		}
		return balance(h);
	}

	/*************************************************************************
	 * Вспомогательные функции черно-красного дерева
	 *************************************************************************/

	// make a left-leaning link lean to the right
	private Node rotateRight(Node node) {
		// assert (h != null) && isRed(h.left);
		Node x = node.left;
		node.left = x.right;
		x.right = node;
		x.color = x.right.color;
		x.right.color = RED;
		x.N = node.N;
		node.N = size(node.left) + size(node.right) + 1;
		return x;
	}

	// make a right-leaning link lean to the left
	private Node rotateLeft(Node h) {
		// assert (h != null) && isRed(h.right);
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = x.left.color;
		x.left.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}

	// flip the colors of a node and its two children
	private void flipColors(Node h) {
		// h must have opposite color of its two children
		// assert (h != null) && (h.left != null) && (h.right != null);
		// assert (!isRed(h) && isRed(h.left) && isRed(h.right))
		// || (isRed(h) && !isRed(h.left) && !isRed(h.right));
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.right.color;
	}

	// Assuming that h is red and both h.left and h.left.left
	// are black, make h.left or one of its children red.
	private Node moveRedLeft(Node h) {
		// assert (h != null);
		// assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);

		flipColors(h);
		if (isRed(h.right.left)) {
			h.right = rotateRight(h.right);
			h = rotateLeft(h);
			flipColors(h);
		}
		return h;
	}

	// Assuming that h is red and both h.right and h.right.left
	// are black, make h.right or one of its children red.
	private Node moveRedRight(Node h) {
		// assert (h != null);
		// assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
		flipColors(h);
		if (isRed(h.left.left)) {
			h = rotateRight(h);
			flipColors(h);
		}
		return h;
	}

	// restore red-black tree invariant
	private Node balance(Node node) {
		// assert (h != null);

		if (isRed(node.right)) {
			node = rotateLeft(node);
		}
		if (isRed(node.left) && isRed(node.left.left)) {
			node = rotateRight(node);
		}
		if (isRed(node.left) && isRed(node.right)) {
			flipColors(node);
		}

		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}

	/*************************************************************************
	 * Служебные функции
	 *************************************************************************/

	// Высота дерева (1-узел дерева имеет высоту 0)
	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}

	/*************************************************************************
	 * Методы таблицы упорядоченных символов.
	 *************************************************************************/

	// возвращает наименьший ключь, если дерево пустое - null
	public Key min() {
		if (isEmpty()) {
			return null;
		}
		return min(root).key;
	}

	// возвращает наименьший ключ в поддереве с корнем node
	private Node min(Node node) {
		// assert x != null;
		if (node.left == null) {
			return node;
		} else {
			return min(node.left);
		}
	}

	// возвращает наибольший ключь, если дерево пустое - null
	public Key max() {
		if (isEmpty()) {
			return null;
		}
		return max(root).key;
	}

	// возвращает наибольший ключ в поддереве с корнем node
	private Node max(Node node) {
		// assert x != null;
		if (node.right == null) {
			return node;
		} else {
			return max(node.right);
		}
	}

	// the largest key less than or equal to the given key
	public Key floor(Key key) {
		Node node = floor(root, key);
		if (node == null) {
			return null;
		} else {
			return node.key;
		}
	}

	// the largest key in the subtree rooted at x less than or equal to the
	// given key
	private Node floor(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;
		if (cmp < 0)
			return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null)
			return t;
		else
			return x;
	}

	// the smallest key greater than or equal to the given key
	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null)
			return null;
		else
			return x.key;
	}

	// the smallest key in the subtree rooted at x greater than or equal to the
	// given key
	private Node ceiling(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;
		if (cmp > 0)
			return ceiling(x.right, key);
		Node t = ceiling(x.left, key);
		if (t != null)
			return t;
		else
			return x;
	}

	// the key of rank k
	public Key select(int k) {
		if (k < 0 || k >= size())
			return null;
		Node x = select(root, k);
		return x.key;
	}

	// the key of rank k in the subtree rooted at x
	private Node select(Node x, int k) {
		// assert x != null;
		// assert k >= 0 && k < size(x);
		int t = size(x.left);
		if (t > k)
			return select(x.left, k);
		else if (t < k)
			return select(x.right, k - t - 1);
		else
			return x;
	}

	// number of keys less than key
	public int rank(Key key) {
		return rank(key, root);
	}

	// number of keys less than key in the subtree rooted at x
	private int rank(Key key, Node x) {
		if (x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return rank(key, x.left);
		else if (cmp > 0)
			return 1 + size(x.left) + rank(key, x.right);
		else
			return size(x.left);
	}

	/***********************************************************************
	 * Диапазон подсчета и диапазон поиска.
	 ***********************************************************************/

	// all of the keys, as an Iterable
	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	// the keys between lo and hi, as an Iterable
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		// if (isEmpty() || lo.compareTo(hi) > 0) return queue;
		keys(root, queue, lo, hi);
		return queue;
	}

	// add the keys between lo and hi in the subtree rooted at x
	// to the queue
	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null)
			return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0)
			keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0)
			queue.enqueue(x.key);
		if (cmphi > 0)
			keys(x.right, queue, lo, hi);
	}

	// number keys between lo and hi
	public int size(Key lo, Key hi) {
		if (lo.compareTo(hi) > 0)
			return 0;
		if (contains(hi))
			return rank(hi) - rank(lo) + 1;
		else
			return rank(hi) - rank(lo);
	}

	/*************************************************************************
	 * Проверка целостности красно-черной структуры данных BST
	 *************************************************************************/
	private boolean check() {
		if (!isBST()) {
			System.out.println("Not in symmetric order");
		}
		if (!isSizeConsistent()) {
			System.out.println("Subtree counts not consistent");
		}
		if (!isRankConsistent()) {
			System.out.println("Ranks not consistent");
		}
		if (!is23()) {
			System.out.println("Not a 2-3 tree");
		}
		if (!isBalanced()) {
			System.out.println("Not balanced");
		}
		return isBST() && isSizeConsistent() && isRankConsistent() && is23() && isBalanced();
	}

	// does this binary tree satisfy symmetric order?
	// Note: this test also ensures that data structure is a binary tree since
	// order is strict
	private boolean isBST() {
		return isBST(root, null, null);
	}

	// is the tree rooted at x a BST with all keys strictly between min and max
	// (if min or max is null, treat as empty constraint)
	// Credit: Bob Dondero's elegant solution
	private boolean isBST(Node x, Key min, Key max) {
		if (x == null)
			return true;
		if (min != null && x.key.compareTo(min) <= 0)
			return false;
		if (max != null && x.key.compareTo(max) >= 0)
			return false;
		return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
	}

	// are the size fields correct?
	private boolean isSizeConsistent() {
		return isSizeConsistent(root);
	}

	private boolean isSizeConsistent(Node x) {
		if (x == null)
			return true;
		if (x.N != size(x.left) + size(x.right) + 1)
			return false;
		return isSizeConsistent(x.left) && isSizeConsistent(x.right);
	}

	// check that ranks are consistent
	private boolean isRankConsistent() {
		for (int i = 0; i < size(); i++)
			if (i != rank(select(i)))
				return false;
		for (Key key : keys())
			if (key.compareTo(select(rank(key))) != 0)
				return false;
		return true;
	}

	// Does the tree have no red right links, and at most one (left)
	// red links in a row on any path?
	private boolean is23() {
		return is23(root);
	}

	private boolean is23(Node x) {
		if (x == null)
			return true;
		if (isRed(x.right))
			return false;
		if (x != root && isRed(x) && isRed(x.left))
			return false;
		return is23(x.left) && is23(x.right);
	}

	// do all paths from root to leaf have same number of black edges?
	private boolean isBalanced() {
		int black = 0; // number of black links on path from root to min
		Node x = root;
		while (x != null) {
			if (!isRed(x))
				black++;
			x = x.left;
		}
		return isBalanced(root, black);
	}

	// does every path from the root to a leaf have the given number of black
	// links?
	private boolean isBalanced(Node node, int black) {
		if (node == null) {
			return black == 0;
		}
		if (!isRed(node)) {
			black--;
		}
		return isBalanced(node.left, black) && isBalanced(node.right, black);
	}

}
