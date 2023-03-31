package swea.pro리스트복사_14613;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class UserSolution
{
	
	static Map<String, LinkedNode> map;
	
	public void init()
	{
		map = new HashMap<>();
	}

	public void makeList(char mName[], int mLength, int mListValue[])
	{
		String name = makeStr(mName);
		LinkedNode node = new LinkedNode();
		node.addList(mListValue, mLength);
		map.put(name, node);
		
	}

	public void copyList(char mDest[], char mSrc[], boolean mCopy)
	{
		String name = makeStr(mSrc);
		String newName = makeStr(mDest);
		LinkedNode node = map.get(name);
		if(mCopy) {
			LinkedNode newNode = new LinkedNode();
			newNode.addList(node);
			map.put(newName, newNode);
		}else {
			map.put(newName, node);
		}
	}

	public void updateElement(char mName[], int mIndex, int mValue)
	{
		String name = makeStr(mName);
//		System.out.println(name);
		LinkedNode node = map.get(name);
		node.setElement(mIndex, mValue);
	}

	public int element(char mName[], int mIndex)
	{
		String name = makeStr(mName);
		LinkedNode node = map.get(name);
		
		return node.getElement(mIndex);
	}
	
	static String makeStr(char mName[]) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mName.length; i++) {
			if(mName[i] != '\u0000') sb.append(mName[i]);
			else break;
		}
		return sb.toString();
	}
	
	static class Node{
		int data;
		Node pre;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.pre = null;
			this.next = null;
		}
	}
	
	static class LinkedNode{
		Node head;
		Node end;
		
		public LinkedNode() {
			this.head = new Node(-1);
			this.end = new Node(-2);
			this.head.next = this.end;
			this.end.pre = this.head;
		}
		
		public void addList(int[] list, int length) {
			
			for (int i = 0; i<length ;i++) {
				Node node = new Node(list[i]);
				node.pre =end.pre;
				end.pre.next = node;
				
				node.next = end;
				end.pre = node;
			}
		}
		
public void addList(LinkedNode node) {
			Node tmp = node.head.next;
			while (tmp != node.end) {
				Node n = new Node(tmp.data);
				n.pre =end.pre;
				end.pre.next = n;
				
				n.next = end;
				end.pre = n;
				tmp = tmp.next;
			}
		}
		
		
		public int getElement(int idx) {
			Node tmp = head.next;
			int i = 0;
			while(i<idx) {
				i++;
				tmp = tmp.next;
			}
			return tmp.data;
		}
		
		public void setElement(int idx, int value) {
			Node tmp = head.next;
			int i = 0;
			while(i<idx) {
				i++;
				tmp = tmp.next;
			}
			tmp.data = value;
		}
	}
}