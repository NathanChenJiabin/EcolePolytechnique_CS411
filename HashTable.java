import java.util.*;

public class HashTable {
	final static int M = 5000;
	Vector<LinkedList<Quadruple>> buckets;
	public HashTable() {
		buckets = new Vector<LinkedList<Quadruple>>(M);
		buckets.setSize(M);
		for(int i = 0; i< M; i++ ) {
			buckets.set(i, new LinkedList<Quadruple>());
		}		
	}
	
	public int hashCode(Row r1, Row r2, int height) {
		return r1.hashCode()+r2.hashCode()+height;
	}
	
	public int bucket(Row r1, Row r2, int height) {
		return Math.abs(hashCode(r1, r2, height))%M;
	}
	public void add(Row r1, Row r2, int height, long result) {
		int hashvalue = bucket(r1, r2, height);
		Quadruple q = new Quadruple(r1, r2, height, result);
		this.buckets.get(hashvalue).add(q);
	}
	public Quadruple find(Row r1, Row r2, int height) {
		int hachvalue = bucket(r1, r2, height);
		return this.buckets.get(hachvalue).element();
	}

}
