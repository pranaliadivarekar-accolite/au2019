package com.accolite.au.java;

public class StackImpl {

	int maxSize = 10;
	int arr[] = new int[maxSize];
	int top;

	public boolean isFull() {
		if (maxSize == top)
			return true;
		else
			return false;
	}

	public void push(int val) {
		if (!isFull()) {
			arr[top++] = val;
			System.out.println(top);
		}
		else
			System.out.println("Stack is full!");
	}

	public void pop() {
		if (!isEmpty()) {
			if(isFull())
				top--;
			arr[top] = 0;
			top--;
		}
		else
			System.out.println("Stack is empty!");
	}

	public void display() {
		System.out.println("Stack ->");
		for (int i = 0; i < top; i++)
			System.out.println(arr[i]);
	}

	public boolean isEmpty() {
		if (top == 0)
			return true;
		else
			return false;
	}
}
