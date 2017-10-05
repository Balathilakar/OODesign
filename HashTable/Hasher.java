package cracking.code.interviewQ.HashTable.OODesign;

import java.util.ArrayList;

public class Hasher<K, V> {
	
	public static class LinkedListNode<K, V>{
		public LinkedListNode<K, V> next;
		public LinkedListNode<K, V> prev;
		public K key;
		public V value;
		
		public LinkedListNode(K k, V v){
			this.key = k;
			this.value = v;
		}
		
		public String printForward(){
			String data = "(" +key+ ","+value+")";
			
			if(next != null){
				return data+"->"+next.printForward();
			}else{
				return data;
			}
		}
		
	}
	
	private ArrayList<LinkedListNode<K,V>> arr;
	public Hasher(int capacity){
		/*Create list of linked lists*/
		arr = new ArrayList<LinkedListNode<K,V>>();
		arr.ensureCapacity(capacity);
		for(int i = 0;i < capacity;i++){
			arr.add(null);
		}
	}
	
	/*Insert key and value into hash table;*/
	public V put(K key, V value){
		LinkedListNode<K,V> node = getNodeForKey(key);
		
		if(node != null){
			V oldValue = node.value;
			node.value = value;
			return oldValue;
		}
		node = new LinkedListNode<K, V>(key, value);		
		int index = getIndexForKey(key);
		if(arr.get(index)!=null){
			node.next = arr.get(index);
			node.next.prev = node;
		}
		arr.set(index,node);
		return null;
	}
	
	
	/*Get linked list node associated with a given key*/
	private LinkedListNode<K,V> getNodeForKey(K key){
		
		int index = getIndexForKey(key);
		
		LinkedListNode<K,V> current = arr.get(index);
		while(current != null){
			if(current.key == key){
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public int getIndexForKey(K key){
		return Math.abs(key.hashCode() % arr.size());
	}
	
	
	
	
	
	
	
	
}
