// Deck version 2017

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class Deck {

	private LinkedList<Integer> pack_of_cards;

	// paquet vide
	public Deck() {
		pack_of_cards = new LinkedList<Integer>();
	}

	// paquet de cartes complet trié avec nbVals valeurs
	public Deck(int nbVals) {
		pack_of_cards = new LinkedList<Integer>();
		for (int j = 1; j <= nbVals; j++)
			for (int i = 0; i < 4; i++)
				pack_of_cards.add(j);
	}

	public boolean isEmpty() {
		return pack_of_cards.isEmpty();
	}

	// nombre de cartes dans le paquet
	public int size() {
		return pack_of_cards.size();
	}

	// affichage
	public String toString() {
		return pack_of_cards.size() + " " +(pack_of_cards.size()==0||pack_of_cards.size()==1?"carte":"cartes")+" "+pack_of_cards;
	}
	
	// Compléter ci-dessous

	// Question 1
	public Integer pick(Deck d) {
		if(!d.isEmpty()) {
			Integer last = d.pack_of_cards.removeFirst();
			this.pack_of_cards.addLast(last);
			return last;
		}else {
			return null;
		}
	}
	
	public void pickAll(Deck d) {
		if(this.pick(d)!=null) {
			this.pickAll(d);
		}
	}
	
	public boolean isDeck(int nbVals) {
		int[] count = new int[nbVals];
		for (Integer x : pack_of_cards) {
			if ((x < 1) || (x > nbVals))
				return false;
			count[x - 1]++;
		}
		for (int i = 0; i < nbVals; i++)
			if (count[i] > 4)
				return false;
		return true;
	}

	// Question 2.1
	public int cut() {
		int n = this.size();
		int count = 0;
		double ale = 0.0;
		for(int i =0; i<n;i++) {
			ale = Math.random();
			if(ale>=0.5) {
				count+=1;
			}
		}
		return count;
	}
	
	public Deck split() {
		int c = this.cut();
		Deck newdeck = new Deck();
		for(int i = 0 ; i<c; i++) {
			newdeck.pick(this);
		}
		return newdeck;
	}
	
	// Question 2.2
	public void riffleWith(Deck d) {
		Deck melange = new Deck();
		int n = this.size()+d.size();
		int nb1,nb2=0;
		double ale = 0.0;
        for(int i =0; i<n;i+=1) {
        	nb1 = this.size();
        	nb2 = d.size();
        	ale = Math.random();
        	if(ale>(double)nb1/(nb1+nb2)) {
        		melange.pick(d);
        	}else {        	
        		melange.pick(this);
        	}
        }
		this.pack_of_cards = melange.pack_of_cards;
	}
	// Question 2.3
	public void riffleShuffle(int m) {
		for(int i =0; i<m; i+=1) {
			Deck d = this.split();
			this.riffleWith(d);
		}
	}
	// Les méthodes ci-dessous sont utilisées pour les tests
  // elles ne doivent pas être modifiées ni supprimées.
	
	// paquets customisés (peuvent-être invalides)
	public Deck(int[] a){
		pack_of_cards = new LinkedList<Integer> ();
		for(Integer card:a){
			this.pack_of_cards.addLast(card);
		}
	}

	public Deck(String s){
		Scanner sc = new Scanner(s);
		pack_of_cards = new LinkedList<Integer> () ;
		while (sc.hasNextInt()) {
	          pack_of_cards.addLast(sc.nextInt());
	      }
		sc.close();
	}
	
	public int highestVal(){
		int r = 0;
		for(Integer card:pack_of_cards){
			if(card > r) r = card;
		}
		return r;
	}
	
	public int[] countCards(int nbVals){
		int[] count = new int[nbVals+1];
		for (Integer x : pack_of_cards) {
			if ((x < 1) || (x > nbVals))
				count[0]++;
			else count[x]++;
		}
		return count;
	}
	
	public boolean isSubdeck(Deck d){
		Iterator<Integer> it = d.pack_of_cards.iterator ();
		for(Integer card : this.pack_of_cards){
			if (!it.hasNext()) return false;
			while(it.next() != card){
				if (!it.hasNext()) return false;
			}
		};
		return true;
	}

	public boolean extractSubdeck(Deck d){
		Iterator<Integer> it = d.pack_of_cards.iterator ();
		for(Integer card : this.pack_of_cards){
			if (!it.hasNext()) return false;
			while(it.next() != card){
				if (!it.hasNext()) return false;
			}
			it.remove();
		};
		return true;
	}
	
	public boolean isFull(int nbVals){
		return ((pack_of_cards.size() == 4*nbVals) && isDeck(nbVals)); 
	}
	
	public boolean equals(Deck d){
		Iterator<Integer> it1 = pack_of_cards.iterator() ;
		Iterator<Integer> it2 = d.pack_of_cards.iterator() ;
		while(it1.hasNext() && it2.hasNext()){
			if(!(it1.next().equals(it2.next()))) return false;
		}
		return (!(it1.hasNext() || it2.hasNext())) ;
	}

	public int [] toArray(){
		int [] ret = new int[size()] ;
		int counter = 0 ;
		for(int card:this.pack_of_cards){
			ret[counter] = card ;
			counter++;
		}
		return ret;
	}
	
	public Deck copy(){
		Deck d = new Deck();
		for(Integer card:this.pack_of_cards)
			d.pack_of_cards.addLast(card);
		return d;
	}
	
	public boolean sameCards(Deck d){
		int nbVals = this.highestVal();
		int a[] = this.countCards(nbVals);
		int b[] = d.countCards(nbVals);
		for(int i = 0 ; i <= nbVals ; i++){
			if(a[i] != b[i]) return false;
		}
		return true;
	}
	
}
