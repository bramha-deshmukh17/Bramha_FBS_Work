package Classwork.Dec_03;

public class MyKey implements Comparable<MyKey> {

	int key;

	MyKey(int key) {
		this.key = key;
	}

	@Override
	public int compareTo(MyKey o) {
		// TODO Auto-generated method stub
		return this.key - o.key;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Key: " + this.key;
	}

	@Override
	public boolean equals(Object obj) {
		MyKey mk = (MyKey) obj;
		return this.key == mk.key;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.key;
	}

}
