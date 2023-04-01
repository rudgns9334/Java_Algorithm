package swea.pro리스트복사_14613;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		LinkedNode node = new LinkedNode(mLength);
		node.addList(mListValue);
		map.put(name, node);
		
	}

	public void copyList(char mDest[], char mSrc[], boolean mCopy)
	{
		String name = makeStr(mSrc);
		String newName = makeStr(mDest);
		LinkedNode node = map.get(name);
		
		if(mCopy) {
			LinkedNode newNode = new LinkedNode(node);
			node.addChild(newNode);
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
//		System.out.println(node.getElement(mIndex));
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
		int[] list;
		public Node(int idx) {
			this.list = new int[idx];
		}
		
		public void addList(int[] values) {
			for (int i = 0; i < list.length; i++) {
				this.list[i] = values[i];
			}
		}
		
		public int getList(int idx) {
			return this.list[idx];
		}
		
		public void setList(int idx, int value) {
			this.list[idx] = value;
		}
	}
	
	
	static class LinkedNode{
		HashMap<Integer, Integer> change;
		Node next;
		LinkedNode parent;
		List<LinkedNode> child;
		
		public LinkedNode(LinkedNode parent) {
			this.change = new HashMap<>();
			this.child = new ArrayList<>();
			this.parent = parent;
		}
		
		public LinkedNode(int length) {
			this.change = new HashMap<>();
			this.next = new Node(length);
			this.child = new ArrayList<>();
		}
		
		public void addChild(LinkedNode child) {
			this.child.add(child);
		}
		
		
		public void addList(int[] values) {
			this.next.addList(values);
		}
		
		public void addList(Node node) {
			this.next = node;
		}
		
		public int getElement(int idx) {
			if(this.next != null) {
				return this.next.getList(idx);
			}else {
				if(change.containsKey(idx)) return change.get(idx);
				else return this.parent.getElement(idx);
			}
			
		}
		
		public void setElement(int idx, int value) {
			int v = this.getElement(idx);
			this.child.forEach(n -> n.addChange(idx, v));
			if(this.next != null) {
				this.next.setList(idx, value);
			}else {
				this.change.put(idx, value);
			}
			
		}
		
		public void addChange(int idx, int value) {
			if(!this.change.containsKey(idx)) change.put(idx, value);
			
		}
		
		public int getLength() {
			return this.next.list.length;
		}
	}
}