package com.dsa.linkedlist;

import java.util.Scanner;

class Node {
	int data;
	Node next = null;
}
class ConstructList {
	Node head;
	public void push(int data){
		Node node = new Node();
		node.data = data;
		node.next = head;
		head = node;
	}
	public void print(){
		Node curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data+"-> ");
			curr=curr.next;
		}
		System.out.println();
	}
}

class FindElement{
	int count = 0;
	public void findNthElement(int position, Node head){
		if(head == null){
			return;
		}
		findNthElement(position,head.next);
		count++;
		if(position == count ){
			System.out.println(head.data);
		}
	}
}

public class NthElement {
	public static void main(String args[]){
		ConstructList cl = new ConstructList();
		Scanner sc = new Scanner(System.in);

		for(int i = 0 ; i < 10 ;i++){
			cl.push(sc.nextInt());
		}
		cl.print();
		FindElement fe = new FindElement();
		System.out.println("Enter the position to find the element from last :");
		int position = sc.nextInt();
		fe.findNthElement(position,cl.head);
		
	}
}
