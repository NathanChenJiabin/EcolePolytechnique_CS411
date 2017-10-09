
public class Compression {
	static void imgFromQTree(QTree t, BinaryImage img, int x, int y, int size){
		if(t.isLeaf()){
			if(t.getColor()==0){
				img.fillAreaBlack(x, y, size);
			}else{
				img.fillAreaWhite(x, y, size);
			}
		}else{
		Compression.imgFromQTree(t.getChild(0),img , x, y, size/2);
		Compression.imgFromQTree(t.getChild(1),img , x+(size/2), y, size/2);
		Compression.imgFromQTree(t.getChild(2),img , x, y+(size/2), size/2);
		Compression.imgFromQTree(t.getChild(3),img , x+(size/2), y+(size/2), size/2);
		}
	}
	
	static void imgFromQTree(QTree t, BinaryImage img){
		Compression.imgFromQTree(t, img, 0, 0, img.getSize());
	}
	
	static QTree QTreeFromImage(BinaryImage img, int x, int y, int size){
		if(img.isConstantColor(x, y, size)){
			if(img.isBlack(x, y)){
				return new QTree(0);
			}else{
				return new QTree(1);
			}
		}else{
			QTree topleft = Compression.QTreeFromImage(img, x, y, size/2);
			QTree topright = Compression.QTreeFromImage(img, x+(size/2), y, size/2);
			QTree bottomleft = Compression.QTreeFromImage(img, x, y+(size/2), size/2);
			QTree bottomright = Compression.QTreeFromImage(img, x+(size/2), y+(size/2), size/2);
			return new QTree(topleft, topright, bottomleft, bottomright);
		}
	}
	
	static QTree QTreeFromImage(BinaryImage img){
		return Compression.QTreeFromImage(img, 0, 0, img.getSize());
	}

}
