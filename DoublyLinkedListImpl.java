package com.accolite.au.java;

public class DoublyLinkedListImpl {

	Node head;
	Node tail;

	public void insertDataAtLast(int val) {
		Node newNode = new Node(val);

		if (head == null) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;

	}

	public void deleteData(int val) {

		if (this.head.data == val) {
			this.head = this.head.next;
			if (this.head != null)
				this.head.prev = null;
		} else if (this.tail.data == val) {
			this.tail = this.tail.prev;
			this.tail.next = null;
		} else {
			Node node = this.head.next;
			while (node.data != val) {
				node = node.next;
			}
			node.next.prev = node.prev;
			node.prev.next = node.next;

		}

	}

	public static void displayData(Node node) {
		if (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
			displayData(node);
		}
	}
}

class Node {
	int data;
	Node prev;
	Node next;

	Node(int val) {
		this.data = val;
		this.prev = null;
		this.next = null;
	}
}