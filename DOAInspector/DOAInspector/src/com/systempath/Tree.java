package com.systempath;

import java.util.ArrayList;

public class Tree<T> {

	private Node<T> root;

	public Tree(Node<T> root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return (root == null) ? true : false;
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public boolean exists(T key) {
		return find(root, key);
	}

	public int getNumberOfNodes() {
		return getNumberOfDescendants(root) + 1;
	}

	public int getNumberOfDescendants(Node<T> node) {
		int n = node.getChildren().size();
		for (Node<T> child : node.getChildren())
			n += getNumberOfDescendants(child);

		return n;

	}

	private boolean find(Node<T> node, T keyNode) {
		boolean res = false;
		if (node.getData().equals(keyNode))
			return true;

		else {
			for (Node<T> child : node.getChildren())
				if (find(child, keyNode))
					res = true;
		}

		return res;
	}
	
    public Node<T> findNode(Node<T> node, T keyNode)
    {
    	if(node == null)
    		return null;
    	if(node.getData().equals(keyNode))
    		return node;
    	else
    	{
    		Node<T> cnode = null;
    		for (Node<T> child : node.getChildren())
    			if ((cnode = findNode(child, keyNode)) != null)
    				return cnode;
    	}
    	return null;         
    } 

	public ArrayList<Node<T>> getPreOrderTraversal() {
		ArrayList<Node<T>> preOrder = new ArrayList<Node<T>>();
		buildPreOrder(root, preOrder);
		return preOrder;
	}

	public ArrayList<Node<T>> getPostOrderTraversal() {
		ArrayList<Node<T>> postOrder = new ArrayList<Node<T>>();
		buildPostOrder(root, postOrder);
		return postOrder;
	}

	private void buildPreOrder(Node<T> node, ArrayList<Node<T>> preOrder) {
		preOrder.add(node);
		for (Node<T> child : node.getChildren()) {
			buildPreOrder(child, preOrder);
		}
	}

	private void buildPostOrder(Node<T> node, ArrayList<Node<T>> postOrder) {
		for (Node<T> child : node.getChildren()) {
			buildPostOrder(child, postOrder);
		}
		postOrder.add(node);
	}

	public ArrayList<Node<T>> getLongestPathFromRootToAnyLeaf() {
		ArrayList<Node<T>> longestPath = null;
		int max = 0;
		for (ArrayList<Node<T>> path : getPathsFromRootToAnyLeaf()) {
			if (path.size() > max) {
				max = path.size();
				longestPath = path;
			}
		}
		return longestPath;
	}

	public int getMaxDepth()
	{
		return getLongestPathFromRootToAnyLeaf().size();
	}
	
	public ArrayList<ArrayList<Node<T>>> getPathsFromRootToAnyLeaf() {
		ArrayList<ArrayList<Node<T>>> paths = new ArrayList<ArrayList<Node<T>>>();
		ArrayList<Node<T>> currentPath = new ArrayList<Node<T>>();
		getPath(root, currentPath, paths);

		return paths;
	}

	private void getPath(Node<T> node, ArrayList<Node<T>> currentPath,
			ArrayList<ArrayList<Node<T>>> paths) {
		if (currentPath == null)
			return;

		currentPath.add(node);

		if (node.getChildren().size() == 0) {
			// This is a leaf
			paths.add(clone(currentPath));
		}
		for (Node<T> child : node.getChildren())
			getPath(child, currentPath, paths);

		int index = currentPath.indexOf(node);
		for (int i = index; i < currentPath.size(); i++)
			currentPath.remove(index);
	}

	private ArrayList<Node<T>> clone(ArrayList<Node<T>> list) {
		ArrayList<Node<T>> newList = new ArrayList<Node<T>>();
		for (Node<T> node : list)
			newList.add(new Node<T>(node));

		return newList;
	}
}

























//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Represents a Tree of Objects of generic type T. The Tree is represented as
// * a single rootElement which points to a List<Node<T>> of children. There is
// * no restriction on the number of children that a particular node may have.
// * This Tree provides a method to serialize the Tree into a List by doing a
// * pre-order traversal. It has several methods to allow easy updation of Nodes
// * in the Tree.
// */
//public class Tree<T> {
// 
//    private Node<T> rootElement;
//     
//    /**
//     * Default ctor.
//     */
//    public Tree() {
//        super();
//    }
// 
//    /**
//     * Return the root Node of the tree.
//     * @return the root element.
//     */
//    public Node<T> getRootElement() {
//        return this.rootElement;
//    }
// 
//    /**
//     * Set the root Element for the tree.
//     * @param rootElement the root element to set.
//     */
//    public void setRootElement(Node<T> rootElement) {
//        this.rootElement = rootElement;
//    }
//     
//    /**
//     * Returns the Tree<T> as a List of Node<T> objects. The elements of the
//     * List are generated from a pre-order traversal of the tree.
//     * @return a List<Node<T>>.
//     */
//    public List<Node<T>> toList() {
//        List<Node<T>> list = new ArrayList<Node<T>>();
//        walk(rootElement, list);
//        return list;
//    }
//     
//    /**
//     * Returns a String representation of the Tree. The elements are generated
//     * from a pre-order traversal of the Tree.
//     * @return the String representation of the Tree.
//     */
//    public String toString() {
//        return toList().toString();
//    }
//     
//    /**
//     * Walks the Tree in pre-order style. This is a recursive method, and is
//     * called from the toList() method with the root element as the first
//     * argument. It appends to the second argument, which is passed by reference     * as it recurses down the tree.
//     * @param element the starting element.
//     * @param list the output of the walk.
//     */
//    private void walk(Node<T> element, List<Node<T>> list) {
//        list.add(element);
//        for (Node<T> data : element.getChildren()) {
//            walk(data, list);
//        }
//    }
//}
//
//
//
