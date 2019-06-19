package cs.Domain;

public class Hall {
	private String number;
	private int HallCapacity;
	public Hall(String number,int HallCapacity ) {
		this.HallCapacity = HallCapacity;
		this.number = number;
	}
	public int getHallCapacity() {
		return HallCapacity;
	}
	public String getnumber() {
		return number;
	}

}
