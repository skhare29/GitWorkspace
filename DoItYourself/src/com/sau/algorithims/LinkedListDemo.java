package com.sau.algorithims;

// Example of Single linked list
public class LinkedListDemo {

	public static void main(String args[]) {

		// create new Linked list
		LinkedList linkedList = new LinkedList();

		linkedList.addToStart(new LinkedList.Node<String>("A"));
		linkedList.addToStart(new LinkedList.Node<String>("B"));
		linkedList.addToStart(new LinkedList.Node<String>("C"));
		linkedList.addToStart(new LinkedList.Node<String>("D"));
		linkedList.addToEnd(new LinkedList.Node<String>("E"));

		linkedList.dislayList();
		
		linkedList.removeNode(new LinkedList.Node<String>("E"));
		
		linkedList.dislayList();
	}

}

class LinkedList {
	private Node firstNodeRef = null;
	private Node lastNodeRef = null;

	public boolean addToStart(Node node) {
		if (firstNodeRef == null && lastNodeRef == null) {
			firstNodeRef = node;
			lastNodeRef = node;
			return true;
		} else if ((firstNodeRef == null && lastNodeRef != null) || (firstNodeRef != null && lastNodeRef == null)) {
			return false;
		} else {
			node.next = firstNodeRef;
			firstNodeRef = node;
			return true;
		}

	}

	public boolean addToEnd(Node node) {
		if (firstNodeRef == null && lastNodeRef == null) {
			firstNodeRef = node;
			lastNodeRef = node;
			return true;
		} else if ((firstNodeRef == null && lastNodeRef != null) || (firstNodeRef != null && lastNodeRef == null)) {
			return false;
		} else {
			lastNodeRef.next = node;
			lastNodeRef = node;
			return true;
		}
	}

	public void dislayList() {
		Node currentNode = firstNodeRef;

		while (currentNode != null) {

			System.out.println("Node data > " + currentNode.data);
			currentNode = currentNode.next;

		}
	}

	public void removeNode(Node<String> node) {
		Node currentNode = firstNodeRef;
		Node previousNode = null;

		while (currentNode != null) {
			if (currentNode.data.equals(node.data)) {
				System.out.println("Node found in list: " + currentNode.data);

				if (currentNode == firstNodeRef && currentNode == lastNodeRef){
					
					firstNodeRef = null;
					lastNodeRef = null;
					
				}else if(currentNode == firstNodeRef) {

					firstNodeRef = currentNode.next;

				} else if (currentNode == lastNodeRef) {
					
					previousNode.next = null;
					lastNodeRef = previousNode;
					
				} else {

					previousNode.next = currentNode.next;
					
				}

				break;
			}
			previousNode = currentNode;
			currentNode = currentNode.next;

		}
	}

	static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;

		}
	}

}