package io.javabrains.springbootstarter.model;

public class Ninja {
	
	private String name;
	private String belt;
	
	public Ninja(){
		
	}
	public Ninja(String name,String belt){
		super();
		this.name = name;
		this.belt = belt;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBelt() {
		return belt;
	}
	public void setBelt(String belt) {
		this.belt = belt;
	}
	
	
}
