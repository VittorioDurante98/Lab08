package it.polito.tdp.extflightdelays.model;

public class Arco {
	
	private Airport aP;
	private Airport aA;
	private long media;
	public Arco(Airport aP, Airport aA, long media) {
		super();
		this.aP = aP;
		this.aA = aA;
		this.media = media;
	}
	public Airport getaP() {
		return aP;
	}
	public void setaP(Airport aP) {
		this.aP = aP;
	}
	public Airport getaA() {
		return aA;
	}
	public void setaA(Airport aA) {
		this.aA = aA;
	}
	public long getMedia() {
		return media;
	}
	public void setMedia(long media) {
		this.media = media;
	}
	@Override
	public String toString() {
		return "Aereoporto Partenza=" + aP + ", Aereoporto Arrivo=" + aA + ", distanza media=" + media ;
	}
	
	
	
	

}
