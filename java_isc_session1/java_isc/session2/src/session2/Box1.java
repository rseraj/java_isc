package session2;

public class Box1<T> {
	
	public Box1(T item) {
		super();
		this.item = item;
	}

	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

}
