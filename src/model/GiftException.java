package model;

public class GiftException {
	private String person;
	private String gifteeException;
	
	public GiftException() {
		
	}
	
	public GiftException(String person, String giftee) {
		this.setPerson(person);
		this.setGifteeException(giftee);
	}
	
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getGifteeException() {
		return gifteeException;
	}
	public void setGifteeException(String gifteeException) {
		this.gifteeException = gifteeException;
	}
}
