package fr.viacesi.autoradio;

public enum ModeAutoradio {
	TUNER("Tuner"), CD("CD");
	
	private String representation;
	ModeAutoradio(String representation){
		this.representation = representation;
	}
	public String toString(){
		return representation;
	}
}
