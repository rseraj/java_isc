package session2;

public class Pair<K, V> {
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	private K key;
	private V value;
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}
