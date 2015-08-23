package model;

public class PreviousGiftees {
	private String gifter;
	private String giftee;
	private int year;
	
	public PreviousGiftees(String gifter, String giftee, int year) {
		this.setGifter(gifter);
		this.setGiftee(giftee);
		this.setYear(year);
	}
	
	public String getGifter() {
		return gifter;
	}
	public void setGifter(String gifter) {
		this.gifter = gifter;
	}
	public String getGiftee() {
		return giftee;
	}
	public void setGiftee(String giftee) {
		this.giftee = giftee;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
}
