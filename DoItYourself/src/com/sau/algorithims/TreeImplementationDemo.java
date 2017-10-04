package com.sau.algorithims;

//This tree implementation can have multiple child nodes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeImplementationDemo {

	public static void main(String args[]) {
		MyTreeNode<String> root = new MyTreeNode<>("Root");

		MyTreeNode<String> child1 = new MyTreeNode<>("Child1");
		child1.addChild("Grandchild1");
		child1.addChild("Grandchild2");

		MyTreeNode<String> child2 = new MyTreeNode<>("Child2");
		child2.addChild("Grandchild3");

		root.addChild(child1);
		root.addChild(child2);
		root.addChild("Child3");

		root.addChildren(Arrays.asList(new MyTreeNode<>("Child4"), new MyTreeNode<>("Child5"), new MyTreeNode<>("Child6")));

		for (MyTreeNode node : root.getChildrenofThisNode()) {
			System.out.println(node.getData());
		}

		System.out.println(MyTreeNode.findNode(new MyTreeNode("Child6"), root));

		MyTreeNode.displayAll(root, 0);

	}
}

class MyTreeNode<T> {
	private T data = null;
	private List<MyTreeNode> children = new ArrayList<>();
	private MyTreeNode parent = null;

	public MyTreeNode(T data) {
		this.data = data;
	}

	public void addChild(MyTreeNode child) {
		child.setParent(this);
		this.children.add(child);
	}

	public void addChild(T data) {
		MyTreeNode<T> newChild = new MyTreeNode<>(data);
		newChild.setParent(this);
		children.add(newChild);
	}

	public void addChildren(List<MyTreeNode<String>> children) {
		for (MyTreeNode t : children) {
			t.setParent(this);
		}
		this.children.addAll(children);
	}

	public List<MyTreeNode> getChildrenofThisNode() {
		return children;
	}

	public static boolean findNode(MyTreeNode<String> node, MyTreeNode<String> rootNode) {

		if (node.data.equals(rootNode.data)) {
			return true;
		} else {
			if (rootNode.children.size() == 0) {
				return false;
			} else {
				for (MyTreeNode myTreeNode : rootNode.children) {
					if (node.data.equals(myTreeNode.data)) {
						return true;
					} else {
						boolean result = findNode(node, myTreeNode);
						if (result) {
							return true;
						}
					}
				}
				return false;
			}
		}

	}

	public static void displayAll(MyTreeNode<String> rootNode, int level) {
		String indentation = "";
		int indentLevel = level + 1;
		for (int i = 0; i < indentLevel; i++) {

			indentation = indentation + "\t";
		}

		System.out.println(indentation + rootNode.data);

		if (rootNode.children.size() == 0) {
			return;
		} else {
			for (MyTreeNode myTreeNode : rootNode.children) {
				displayAll(myTreeNode, indentLevel);
			}
			return;
		}

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	private void setParent(MyTreeNode parent) {
		this.parent = parent;
	}

	public MyTreeNode getParent() {
		return parent;
	}
}
