package model;

import java.util.ArrayList;
import java.util.List;

public class Gifter {

	private String name;
	private String currentGiftee;
	private List<String> exceptions;
	
	public Gifter() {
		
	}
	
	public Gifter(String person, List<String> exemptions) {
		setName(person);
		setExceptions(exemptions);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrentGiftee() {
		return currentGiftee;
	}
	public void setCurrentGiftee(String currentGiftee) {
		this.currentGiftee = currentGiftee;
	}
	public List<String> getExceptions() {
		return exceptions;
	}
	public void setExceptions(List<String> exceptions) {
		this.exceptions = exceptions;
	}
	public void addException(String exception) {
		if (this.exceptions == null ) {
			this.exceptions = new ArrayList<String>();
		}
		exceptions.add(exception);
	}
	
}
