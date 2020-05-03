package com.algo.bst;

import java.util.Queue;
import java.util.LinkedList;

class Node {
	int data ;
	Node left = null;
	Node right = null;
}
class Operation{
	public Node createRootNode(int data){
		Node newNode = new Node();
		newNode.data = data;
		newNode.left = null;
		newNode.right = null;
		return newNode;
		
	}
	public Node search(Node root,int data){
		if(root == null){
			return root;
		}
		 Node found =null;
		if(root.data == data){
			return root;
		}else if(root.data>data){
			found = search(root.left,data);
		}else {
			found = search(root.right,data);
		}
		
		return found;
	}
	public Node insert(Node root,int data){
		if(root == null){
			root = createRootNode(data);
		}else if(data <= root.data){
			root.left = insert(root.left,data);
		}else {
			root.right = insert(root.right,data);
		}
		return root;
	}
	public void findMinIterative(Node root){
		if(root == null){
			System.out.println("Tree is empty");
			return;
			
		}
		
		while(root.left != null){
			root = root.left;
		}
		 System.out.println("Minimum "+root.data);
	}
	public void findMaxIterative(Node root){
		if(root == null){
			System.out.println("Tree is empty");
			return;
		}
		while(root.right !=null){
			root = root.right;
		}
		System.out.println("Maximum "+root.data);
	}
	public Node findMinRecursive(Node root){
		if(root == null){
			System.out.println("Tree is empty");
			return root;
		}
		else if(root.left == null){
			System.out.println("Minimum "+ root.data);
			return root;
		}
		return findMinRecursive(root.left);
		
	}
	public void findMaxRecursive(Node root){
		if(root == null){
			System.out.println("Tree is empty");
			return;
		}
		else if(root.right == null){
			System.out.println("Maximum "+ root.data);
			return;
		}
		findMaxRecursive(root.right);
		
	}
	public int findHeight(Node root){
		if(root == null){
			return -1;
		}
		
		return Math.max(findHeight(root.left),findHeight(root.right))+1;
	}
	public void levelOrder(Node root){
		Queue <Node> q = new LinkedList<>();
		if(root == null){
			return;
		}
		
		q.add(root);
		while(!q.isEmpty()){
			Node cur = q.peek();
			System.out.println(cur.data);
			if(cur.left !=null){
				q.add(cur.left);
			}
			if(cur.right !=null){
				q.add(cur.right);
			}
			q.poll();
			
		}
		
	}
	public void inOrder(Node root){
		if(root == null){
			return ;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	public void preOrder(Node root){
		if(root == null){
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	public void postOrder(Node root){
		if(root ==null){
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}
	public boolean isBST(Node root,int min, int max){
		if(root == null){
			return true;
		}
		boolean flag = false;
		if(root.data >= min && root.data <max  && isBST(root.left,min,root.data) && isBST(root.right,root.data,max)){
			flag = true;
		}
		return flag;
	}
	public Node findMin(Node root){
		while(root.left !=null ){
			root = root.left;
		}
		return root;
	}
	public Node deleteNode (Node root ,int data){
		if(root == null){
			return root;
			
		}else if(root.data > data){
			root.left =deleteNode(root.left,data);
		}else if(root.data < data){
			root.right = deleteNode(root.right,data);
		}else{
			//Leaf node case
			if(root.left == null && root.right == null){
				root =null;
			}
			//one child node
			else if(root.left == null){
				Node temp = root;
				root = root.right;
				temp = null;
			}else if(root.right == null){
				Node temp = root;
				root = root.left;
				temp = null;
			//Two Child case
			}else{
				Node temp = findMin(root.right);
				root.data = temp.data;
				root.right = deleteNode(root.right,temp.data);
			}
		}
		return root;
	}
	public Node inOrderSuccessor(Node root,int data){
		
		
		Node current = search(root,data);
		if(current == null){
			return current;
		}
		//No Right subtree for the give node 
		if(current.right !=null){
			return findMinRecursive(current.right);
		}
		else{
			Node successor = null;
			Node ancestor = root;
			while(ancestor !=current){
				if(current.data < ancestor.data){
					successor = ancestor;
					ancestor = ancestor.left;
				}else{
					ancestor = ancestor.right;
				}
				
			}
			return successor;
		}
		
		
	}
}

public class BST {
	public static void main(String args[]){
		Operation op = new Operation();
		Node root = null;
//		root = op.insert(root, 12);
//		root = op.insert(root, 15);
//		root = op.insert(root, 13);
//		root = op.insert(root, 17);
//		root = op.insert(root, 5);
//		root = op.insert(root, 3);
//		root = op.insert(root, 9);
//		root = op.insert(root, 7);
//		root = op.insert(root, 1);
//		root = op.insert(root, 20);
//		root = op.insert(root, 18);
//		if(op.search(root, 12)){
//			System.out.println("Element found");
//		}else{
//			System.out.println("Element not found");
//		}
		//op.findMinIterative(null);
		//System.out.println("Height of the tree "+op.findHeight(root));
		//op.levelOrder(root);
		//op.inOrder(root);
		//op.preOrder(root);
		//op.postOrder(root);
		
		
		//System.out.println("IS BST : "+ op.isBST(root,Integer.MIN_VALUE , Integer.MAX_VALUE));
		//op.deleteNode(root, 15);
		//op.inOrder(root);
		int arr [] = {10,5,1,7,40,50};
		for(int i =0;i<arr.length;i++){
			root = op.insert(root, arr[i]);
		}
		op.inOrder(root);
	}
}
