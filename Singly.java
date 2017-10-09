public class Singly<E> {
	E element;
	Singly<E> next;

	// On choisit de représenter la liste vide par null, les constructeurs ne
	// peuvent donc construire que des listes non vides.

	public Singly(E element, Singly<E> next) {
		this.element = element;
		this.next = next;
	}

	public Singly(E[] data) {
		assert (data.length > 0) : "\nLe constructeur Singly(E[] data) ne peut être utilisé avec un tableau vide"
				+ "\ncar on ne peut pas construire une liste non vide sans données.";
		this.element = data[0];
		this.next = null;
		Singly<E> cursor = this;
		for (int i = 1; i < data.length; i++) {
			cursor.next = new Singly<E>(data[i], null);
			cursor = cursor.next;
		}
		;
	}

	static <E> Singly<E> copy(Singly<E> l) {
		if (l == null)
			return null;
		Singly<E> res = new Singly<E>(l.element, l.next);
		Singly<E> cursor = res;
		while (l.next != null) {
			l = l.next;
			cursor.next = new Singly<E>(l.element, l.next);
			cursor = cursor.next;
		}
		return res;
	}

	public static <E> boolean areEqual(Singly<E> chain1, Singly<E> chain2) {
		while (chain1 != null && chain2 != null) {
			if (!chain1.element.equals(chain2.element))
				return false;
			chain1 = chain1.next;
			chain2 = chain2.next;
		}
		return chain1 == chain2;
	}
	
	public String toString() {
		Singly<E> cursor = this;
		String answer = "[ ";
		while (cursor != null) {
			answer = answer + (cursor.element).toString() + " ";
			cursor = cursor.next;
		}
		answer = answer + "]";
		return answer;
	}

	
	// 1. Compléter ci-dessous
	static<E> int length(Singly<E> l){
		if (l==null)  return 0;
		int len = 1;
		Singly<E> copy = l;
		while(copy.next!=null){
			len+=1;
			copy = copy.next;
		}
		return len;
	}
	
	static<E> Singly<E> split(Singly<E> l){
		int len = length(l);
		if(len<=1)return null;
		int len1 = (len+1)/2 ;	
		Singly<E> copy = l;
		for(int i = 1; i<len1; i++){
			copy = copy.next;
		}
		Singly<E> res = copy.next;
		copy.next = null;
		return res;
	}
			
	
}
