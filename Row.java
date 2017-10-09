public class Row {
	private final int[] fruits;

	public Row() {
		this.fruits = new int[0];
	}

	public Row(int[] fruits) {
		this.fruits = fruits;
	}

	public Row addFruit(int fruit) {
		int len = this.fruits.length;
		int[] newrow = new int[len+1];
		for(int j = 0 ; j< len; j++) {
			newrow[j] = this.fruits[j];			
		}
		newrow[len] = fruit ;
		Row newfruit = new Row(newrow);
		return newfruit ;
	}

	public boolean isValid() {
		int len = this.fruits.length;
		if(len>2) {
			for(int j =0; j<len-2; j++) {
				if(this.fruits[j]== this.fruits[j+1]&& this.fruits[j]== this.fruits[j+2]) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean areStackable(Row r1, Row r2) {
		int len0 = this.fruits.length;
		int len1 = r1.fruits.length;
		int len2 = r2.fruits.length;
		if(len0 == len1 && len0 == len2) {
			for(int j = 0; j< len0; j++) {
				if(this.fruits[j]==r1.fruits[j]&&this.fruits[j]==r2.fruits[j]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		Row that = (Row)o;
		if(this.fruits.length != that.fruits.length)
			return false;
		for(int i = 0 ; i < this.fruits.length; ++i){
			if(this.fruits[i] != that.fruits[i])
				return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		for(int i = 0; i < fruits.length; ++i){
			hash = 2*hash + fruits[i];
		}
		return hash;
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();

		for(int i = 0; i < fruits.length; ++i)
			s.append(" _");
		s.append("\n");

		for(int i = 0; i < fruits.length; ++i)
			s.append("|" + fruits[i]);
		s.append("|\n");
		
		return s.toString();
	}
}
