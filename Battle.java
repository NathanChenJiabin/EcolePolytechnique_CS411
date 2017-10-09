// Battle version 2017

public class Battle {

	private int nbVals;
	private Deck trick;
	private Deck player1;
	private Deck player2;

	public Deck get_player1() {
		return player1;
	}

	public Deck get_player2() {
		return player2;
	}

	public Deck get_trick() {
		return trick;
	}
	
	public int get_nbVals() {
		return nbVals;
	}

	public String toString(){
		return
		"Joueur 1 a "+(player1.toString())+"\n"+
		"Joueur 2 a "+(player2.toString())+"\n"+
		(trick.isEmpty()?"Le pli est vide":
		"Le pli contient "+trick.toString())
		;
	}
	
	public boolean equals(Battle b){
		return player1.equals(b.player1) &&
				player2.equals(b.player2) &&
				trick.equals(b.trick)
				;
	}
	
	// La bataille sans cartes
	public Battle(){
		nbVals = 0;
		player1 = new Deck();
		player2 = new Deck();
		trick = new Deck();
	}

	// Dupliquer une partie
	public Battle copy(){
		Battle r = new Battle();
		r.nbVals = this.get_nbVals();
		r.player1 = this.player1.copy();
		r.player2 = this.player2.copy();
		r.trick = this.trick.copy();
		return r;
	}
	
	// Partie truquée (pour les tests)
	public Battle(int nbVals,Deck player1,Deck player2){
		this.nbVals = nbVals;
		this.player1 = player1;
		this.player2 = player2;
		trick = new Deck();
	}

	public Battle(int nbVals,String player1,String player2){
		this.nbVals = nbVals;
		this.player1 = new Deck(player1);
		this.player2 = new Deck(player2);
		this.trick = new Deck();
	}

	public Battle(int nbVals,Deck player1,Deck player2,Deck trick){
		this.nbVals = nbVals;
		this.player1 = player1;
		this.player2 = player2;
		this.trick = trick;
	}


	
	public Battle(int nbVals,String player1,String player2,String trick){
		this.nbVals = nbVals;
		this.player1 = new Deck(player1);
		this.player2 = new Deck(player2);
		this.trick = new Deck(trick);
	}
	
	// Question 3.1
	public Battle(int nbVals){
		this.nbVals = nbVals;
		Deck d = new Deck(nbVals);
		d.riffleShuffle(7);
		this.player1 = new Deck();
		this.player2 = new Deck();
		for(int i = 0; i<2*nbVals; i++){
			this.player1.pick(d);
			this.player2.pick(d);
		}
		this.trick = new Deck();
	}

	// Question 3.2
	public boolean isOver(){
		return this.player1.isEmpty() || this.player2.isEmpty();

	}
	
	public boolean oneRound(){
		if(this.isOver()){
			return false;
		}
		Integer n1 = this.trick.pick(player1);
		Integer n2 = this.trick.pick(player2);
		while(n1==n2){
			for(int i = 0; i<2; i++){
				if(this.isOver()){
					return false;
				}
				n1 = this.trick.pick(player1);
				n2 = this.trick.pick(player2);
				
			}
		}
		if(n1>n2){
			this.player1.pickAll(trick);
			
		}else if(n1<n2){
			this.player2.pickAll(trick);
			
		}
		return true;	
	}
	
	// Question 3.3
	public int winner(){
		int t1 = this.player1.size();
		int t2 = this.player2.size();
		if(t1>t2){
			return 1;
		}else if(t1<t2){
			return 2;
		}else{
			return 0;
		}
	}
	public int game(int turns){
		for(int i = 0; i< turns; i++){
			if(!this.oneRound()){
				return this.winner();
			}
		}
		return this.winner();
	}

	// Question 4.1
	public int game(){
		Battle tortue = this.copy();
        do{
        	if(!this.oneRound())return this.winner();
        	if(!this.oneRound())return this.winner();
        	tortue.oneRound();
        }while(!this.equals(tortue));
        return 3;
	}

	// Question 4.2
	public static void stats(int nbVals, int nb_of_games){
		int player1_wins = 0 ;
		int player2_wins = 0 ;
		int out_of_cards = 0 ;
		int unfinished = 0 ;
		int result = 0;
		Battle b = null;
		for(int i = 0; i < nb_of_games ; i++){
			b = new Battle(nbVals);
			result = b.game();
			if(result == 1)player1_wins++;
			if(result == 2)player2_wins++;
			if(result == 0)out_of_cards++;
			if(result == 3)unfinished++;
		}
		System.out.println(""+player1_wins+" Questions sur "+nb_of_games+" ont été gagnées par le premier joueur.");
		System.out.println(""+player2_wins+" Questions sur "+nb_of_games+" ont été gagnées par le deuxième joueur.");
		System.out.println(""+unfinished+" Questions infinies sur "+nb_of_games);
		System.out.println(""+out_of_cards+" Questions nulles sur "+nb_of_games);
	}


}
