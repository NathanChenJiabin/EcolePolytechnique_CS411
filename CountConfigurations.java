import java.util.*;

public class CountConfigurations {
//	static HashTable memo = new HashTable();

	static LinkedList<Row> allRows(int width) {
		LinkedList<Row> res = new LinkedList<Row>();

		if(width == 0) {
			res.add(new Row ());
		} else {
			LinkedList<Row> allSmallerRows = allRows(width-1);
			for(Row l : allSmallerRows) {
				Row tmp0 = l.addFruit(0);
				if(tmp0.isValid())
					res.add(tmp0);

				Row tmp1 = l.addFruit(1);
				if(tmp1.isValid())
					res.add(tmp1);
			}
		}

		return res;
	}

	static long count(Row r1, Row r2, LinkedList<Row> rows, int height) {
		long total =0;
		if(height<=1) {
			
			return total;
		}
		if(height==2) {
			total =1;
			return total;
		}
		for(Row r : rows) {
			if(r.areStackable(r1, r2)) {
				total+=count(r2, r, rows, height-1);
			}
		}
		return total;
	}

	static long count(int n) {
		LinkedList<Row> rows = allRows(n);
		long sum = 0;
		for(Row r1: rows) {
			for(Row r2: rows) {
				sum+= count(r1, r2, rows, n);
			}
		}
		return sum;

	}
}
