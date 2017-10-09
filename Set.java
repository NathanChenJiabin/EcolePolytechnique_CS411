
public class Set {
	private BST root;
	
	public Set() {
		this.root = null;
	}

	boolean contains(double x) {
		return BST.contains(this.root, x);
	}
    void add(double x)  {
    	root = BST.add(this.root, x);
    }
    void remove(double x) {
    	root = BST.remove(this.root, x);
    }
    void remove2(double x){
    	root = BST.remove2(root, x);
    }
    int size() {
    	return BST.size(root);
    }
    double select(int k) {
    	return BST.select(root, k);
    }
    int internalPathLength() {
    	return BST.internalPathLength(root);
    }

}
