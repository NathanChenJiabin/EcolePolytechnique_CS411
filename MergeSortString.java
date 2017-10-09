public class MergeSortString {

	static Singly<String> merge(Singly<String> l1, Singly<String> l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		Singly<String> accu;
		if (l1.element.compareTo(l2.element) <= 0) {
			accu = l1; 
			l1 = l1.next; //supprime le premier élément de l1
		} else {
			accu = l2; 
			l2 = l2.next; //supprime le premier élément de l2
		}
		accu.next = null; //accu ne contient plus qu'un seul élément
		Singly<String> last = accu;
		while (l1 != null && l2 != null) {
			if (l1.element.compareTo(l2.element) <= 0) {
				last.next = l1; //ajoute le premier éléménet de l1 à la fin de l'accumulateur
				last = last.next; //pointe le dernier élément de l'accumulateur
				l1 = l1.next; //supprime le premier élément de l1
				 
			} else {
				last.next = l2; l2 = l2.next; last = last.next;
			}
		}
		if (l1 != null) last.next = l1;
		if (l2 != null) last.next = l2;
		return accu;
	}

	static Singly<String> mergeSort(Singly<String> l) {
		if (l == null || l.next == null) return l;
		return merge(mergeSort(Singly.split(l)), mergeSort(l));
	}

}
