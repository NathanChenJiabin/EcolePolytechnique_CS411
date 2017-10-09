
public class Median {
	
	
	static Pair<Double> median (Singly<Double> data){
		if(data == null)return new Pair<Double>(Double.NaN, Double.NaN);
		int len = Singly.length(data);
		if (len == 1) return new Pair<Double>(data.element, data.element);
		data = MergeSort.mergeSort(data);
		Singly<Double> res = Singly.split(data);
		Singly<Double> left = data;
		while(left.next!=null){
			left = left.next;
		}
		if(len%2==0){
			return new Pair<Double>(left.element, res.element);
		}else{
			return new Pair<Double>(left.element, left.element);
		}

	}

}
