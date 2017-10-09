
public class Occurrence implements Comparable<Occurrence>{
	String word;
	int count;
	
	Occurrence(String word, int count){
		this.word = word;
		this.count = count;
	}
	
	public String toString(){
		return this.word;
	}
	
	static Singly<Occurrence> count(Singly<String> l){
		if(l==null)return null;
		Singly<String> lo = MergeSortString.mergeSort(l);
		Singly<String> first = lo;
		Singly<String> suite = lo.next;
		Singly<Occurrence> s = null;
		int count = 1;
		while(true){
			if(suite==null){
				Occurrence o = new Occurrence(first.element, count);
				s = new Singly<Occurrence>(o, s);
				return s;
			}
			if(suite.element.equals(first.element)){
				count+=1;
				suite = suite.next;
			}else{
				Occurrence o = new Occurrence(first.element, count);
				s = new Singly<Occurrence>(o, s);
				first = suite;
				suite = suite.next;
				count = 1;
			}
		}
	}
	
	static Singly<Occurrence> sortedCount(Singly<String> l){
		Singly<Occurrence> s = count(l);
		s = MergeSort.mergeSort(s);
		return s;
	}

	@Override
	public int compareTo(Occurrence that) {
		// TODO Auto-generated method stub
		if(this.count>that.count)return -1;
		if(this.count<that.count)return 1;
		if(this.count==that.count){
			 return this.word.compareTo(that.word);

		}
		return 0;
	}

}
