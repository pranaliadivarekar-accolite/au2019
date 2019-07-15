package com.accolite.au.java;

public class LinkedHashMapImpl {

	HashMapObject arr[];
	int maxSize;
	DoublyLinkedListImpl dll = new DoublyLinkedListImpl();
	HashMapObject obj;

	public LinkedHashMapImpl() {
		maxSize = 100;
		arr = new HashMapObject[maxSize];
	}

	public void put(int key, int value) {
		obj = new HashMapObject();
		obj.setKey(key);
		obj.setValue(value);
		obj.setHash(obj.generateHash(key));
		int hash = obj.getHash();
		HashMapObject nextObj;
		if (arr[hash] == null) {
			dll.insertDataAtLast(key);
			arr[hash] = obj;
		} else {
			if (arr[hash].getKey() != key) {
				nextObj = arr[hash];
				while(nextObj.nextObject != null)
				{
					nextObj = nextObj.nextObject;
				}
				nextObj.nextObject = obj;
				dll.insertDataAtLast(key);

			} else
				arr[hash] = obj;
		}
	}

	public void delete(int key) {
		boolean flag = false;
		Node newNode = dll.head;
		while (newNode != null) {
			if (newNode.data == key) {
				dll.deleteData(key);
				
				obj = new HashMapObject();
				int hash = obj.generateHash(key);
				arr[hash] = deleteFromHashTable(hash, key);
				flag = true;
				break;
			}
			newNode = newNode.next;
		}
		if (!flag)
			System.out.println("No such key found!");
	}
	
	public HashMapObject deleteFromHashTable(int hash, int key)
	{
		obj = arr[hash];
		HashMapObject originalObj = obj;
		if(obj.getKey() == key)
			return obj.nextObject;
		while(obj.nextObject.key != key)
		{
			obj = obj.nextObject;
		}
		obj.nextObject = obj.nextObject.nextObject;
		return originalObj;
	}

	public HashMapObject get(int key) {
		boolean flag = false;
		Node newNode = dll.head;
		while (newNode != null) {
			if (newNode.data == key) {
				obj = new HashMapObject();
				int hash = obj.generateHash(key);
				obj = arr[hash];
				while(obj.getKey() != key) {
					obj = obj.nextObject;
				}
				return obj;
			}
			newNode = newNode.next;
		}
		return null;
	}

	public void print() {
		Node newNode = dll.head;
		HashMapObject nextObj;
		while (newNode != null) {
			int key = newNode.data;
			obj = new HashMapObject();
			int hash = obj.generateHash(key);
			obj = arr[hash];
			if (obj.getKey() == key) {
				System.out.println(obj);
			} 
			else {
				nextObj = obj.nextObject;
				while (nextObj != null) 
				{
					if (nextObj.getKey() == key) {
						System.out.println(nextObj);
					} 
					nextObj = nextObj.nextObject;
				}
			}
			newNode = newNode.next;
		}
	}
}

class HashMapObject {
	int key;
	int value;
	int hash;
	HashMapObject nextObject;

	public int generateHash(int key) {
		return key % 10 + 1;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "HashMapObject [key=" + key + ", value=" + value + "]";
	}

}
