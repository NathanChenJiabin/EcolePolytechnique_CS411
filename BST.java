public class BST {
    private double value;
    private BST left, right;
    private int size;

    BST(BST left, double value, BST right) {
        this.left = left;
        this.value = value;
        this.right = right;
        this.size = BST.size(left)+BST.size(right) +1;
    }

    BST(double value) {
        this(null, value, null);
        this.size  = 1;
    }

    static boolean contains(BST b, double x) {
        while (b != null) {
            if (x == b.value)
                return true;
            b = (x < b.value) ? b.left : b.right;
        }
        return false;
    }

    static BST add(BST b, double x) {
        if (b == null)
            return new BST(x);
        if (x < b.value){
            b.left = add(b.left, x); b.size+=1;  }        
        else{
            b.right = add(b.right, x);b.size+=1;}
        
        return b;
    }

    // suppose b != null
    static double getMin(BST b) {
        while (b.left != null)
            b = b.left;
        return b.value;
    }
    // suppose b!=null
    static double getMax(BST b){
    	while(b.right!=null){
    		b = b.right;
    	}
    	return b.value;
    }

    // suppose b != null
    static BST removeMin(BST b) {
        if (b.left == null)
            return b.right;
        b.left = removeMin(b.left);
        
        b.size-=1;
        return b;
    }
    // suppose b!=null
    static BST removeMax(BST b){
    	if(b.right==null){
    		return b.left;   		
    	}
    	b.right = removeMax(b.right);
    	b.size = 1 + size(b.left)+ size(b.right);
    	return b;
    }

    // if b contains x, remove one occurence of x in b
    static BST remove(BST b, double x) {
        if (b == null)
            return null;
        if (x < b.value) {
            b.left = remove(b.left, x);
            
            b.size = BST.size(b.left)+BST.size(b.right) +1;
            }
        else if (x > b.value) {
            b.right = remove(b.right, x);
            
            b.size = BST.size(b.left)+BST.size(b.right) +1;
            }
        else { // x == b.value
            if (b.right == null)
            	
                return b.left;
            b.value = getMin(b.right);
            b.right = removeMin(b.right);
            b.size-=1;
        }
        return b;
    }
    static BST remove2(BST b, double x) {
        if (b == null)
            return null;
        if (x < b.value) {
            b.left = remove2(b.left, x);
            }
        else if (x > b.value) {
            b.right = remove2(b.right, x);
            }
        else { // x == b.value
			if(Math.random()>0.5){
			   if (b.right == null)
					return b.left;	
                b.value = getMin(b.right);
			    b.right = removeMin(b.right);
            }
			else{
				if (b.left == null)
					return b.right;
	            b.value = getMax(b.left);
				b.right = removeMax(b.left);
			}
        }
        b.size = 1 + size(b.left)+ size(b.right);
        return b;
    }
    
    static int size(BST b) {
    	if(b==null) {
    		return 0;
    	}else {
    		return b.size;
    	}
    }
    static double select(BST b, int k) {
    	assert b!=null;
    	int sizeofleft = BST.size(b.left);
    	if(sizeofleft<k) {
    		return select(b.right, k- sizeofleft -1);
    		
    	}else if(sizeofleft>k) {
    		return select(b.left, k);
    	}else {
    		return b.value;
    	}
    }
    static int internalPathLength(BST b) {
    	if(b == null)return 0;
    	return internalPathLength(b.left)+internalPathLength(b.right)+size(b)-1;
    }
    static int hauteur(BST b) {
    	if (b == null) return 0;
    	return 1+ Math.max(hauteur(b.left), hauteur(b.right));
    }


}
