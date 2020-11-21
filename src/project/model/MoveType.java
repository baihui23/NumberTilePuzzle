package project.model;

public enum MoveType {
	
	UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0),
	NONE(0, 0);
	
	final int deltaC;
	final int deltaR;
	
	MoveType(int deltaC, int deltaR) {
		this.deltaC = deltaC;
		this.deltaR = deltaR;
	}
	
	public int getDeltaC() { return deltaC; }
	public int getDeltaR() { return deltaR; }


}
