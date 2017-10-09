
public class QTree {
	private int color;
	private QTree[] children;
	
	public QTree(int color){
		this.color = color;
		this.children = null;
	}
	
	 public QTree(QTree topLeft, QTree topRight, QTree bottomLeft, QTree bottomRight){
		 this.color = -1;
		 this.children = new QTree[]{topLeft, topRight, bottomLeft, bottomRight};
	 }
	 
	 boolean isLeaf(){
		 if(this.color==-1){
			 return false;
		 }else{
			 return true;
		 }
	 }
	 
	 int getColor(){
		 return this.color;
	 }
	 
	 QTree getChild(int index){
		 assert(index>=0 && index<=3);
		 return this.children[index];
	 }
	 
	 public String toString(){
		 String s = "";
		 if(isLeaf()){
			 s += this.color;
		 }else{
			 s+= "*";
			 for(int i =0; i<4; i++){
				 s+= this.getChild(i).toString();
			 }
		 }
		 return s;
	 }
	 public static Pair<QTree, String> QTreeFromStringAux(String encoding){
		 int c = Character.getNumericValue(encoding.charAt(0));
		 if(c==0 || c==1){
			 return new Pair<QTree, String>(new QTree(c), encoding.substring(1));
		 }else{
			 Pair<QTree, String> topleft = QTree.QTreeFromStringAux(encoding.substring(1));
			 Pair<QTree, String> topright = QTree.QTreeFromStringAux(topleft.second);
			 Pair<QTree, String> bottomleft = QTree.QTreeFromStringAux(topright.second);
			 Pair<QTree, String> bottomright = QTree.QTreeFromStringAux(bottomleft.second);
			 QTree t = new QTree(topleft.first, topright.first, bottomleft.first, bottomright.first);
			 return new Pair<QTree, String>(t, bottomright.second);
		 }
	 }
	 public static QTree QTreeFromString(String encoding){
		 return QTree.QTreeFromStringAux(encoding).first;
	 }

}
