
public class EfficiencyMeasure {
	static double compressionRate(BinaryImage img){
		QTree t = Compression.QTreeFromImage(img);
		String code = t.toString();
		int carre = img.getSize()*img.getSize();
		double compression_rate = 1.585*code.length() / carre ;
		return compression_rate;
	}
	
	static BinaryImage randomBinaryImage(int size, double prob){
		BinaryImage img = new BinaryImage(size);
		if(prob == 0){
			img.fillAreaWhite(0, 0, size);
			return img;
		}
		if(prob==1){
			img.fillAreaBlack(0, 0, size);
			return img;
		}
		for(int i = 0; i<size; i++){
			for(int j =0; j<size; j++){
				double alea = Math.random();
				if(alea>prob){
					img.toWhite(i, j);
				}else{
					img.toBlack(i, j);
				}
			}
		}
		return img;
	}
	
	public static void main(String[] args){
		for(int i =0; i<11; i++){
			double prob = i*0.1;
			BinaryImage img = EfficiencyMeasure.randomBinaryImage(256, prob);
			double compre_rate = EfficiencyMeasure.compressionRate(img);
			System.out.println("Compression rate of image created randomly with probablity "+ prob+" is  "+compre_rate);
		}
	}

}
