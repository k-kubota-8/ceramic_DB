package model;

import java.io.Serializable;

public class Glaze implements Serializable {
	private int glazeID;
	private String glazeName;
	
	public Glaze() {}
	public Glaze(int glazeID, String glazeName) {
		this.glazeID = glazeID;
		this.glazeName = glazeName;
	}
	
	public int getGlazeID() { return glazeID; }
	public void setGlazeID(int glazeID) { this.glazeID = glazeID; }
	
	public String getGlazeName() { return glazeName; }
	public void setGlazeName(String glazeName) { this.glazeName = glazeName; }
}
