
public class Experiment {
	public static void main(String[] args) {
		int N  = 10000;
		run(N);
	}
	
	public static void run(int N) {
		Set s = new Set();
		for(int i=0; i<N; i++) {
			s.add(Math.random());
		}
		System.out.println(s.internalPathLength()/(double)N+1);
		for(int i=0; i<N*N; i++) {
			int k = (int)(Math.random()*N);
			s.remove2(s.select(k));
			s.add(Math.random());
		}
		System.out.println(s.internalPathLength()/(double)N+1);
	}

}
