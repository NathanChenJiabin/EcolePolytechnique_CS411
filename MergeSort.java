
public class MergeSort{
	
	static<E extends Comparable<E>> Singly<E> merge(Singly<E> l1, Singly<E> l2){
		if(l1==null)return l2;
		if(l2==null)return l1;
		Singly<E> accu;
		Singly<E> last;
		if(l1.element.compareTo(l2.element)<=0){
			accu = new Singly<E>(l1.element, null);
			last = accu;
			l1 = l1.next;
		}else{
			 accu = new Singly<E>(l2.element, null);
			 last = accu;
			l2 = l2.next;
		}
		while(l1!=null&&l2!=null){
			if(l1.element.compareTo(l2.element)<=0){
                last.next = new Singly<E>(l1.element, null);
                last = last.next;
				l1 = l1.next;
			}else{
                last.next = new Singly<E>(l2.element, null);
                last = last.next;
				l2 = l2.next;
			}
		}
		if(l1==null){
			last.next = l2;
			return accu;
		}
        last.next = l1;
        return accu;
	}
	
	static<E extends Comparable<E>> Singly<E> mergeSort(Singly<E> l){
		Singly<E> res = Singly.split(l);
		if(res==null)return l;
		l = mergeSort(l);
		res = mergeSort(res);
		return merge(l, res);
	}

}
