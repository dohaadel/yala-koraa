package go_football.entity;

public class AvaliableHour {
	private String day;
	private int startHour;
	private int endHour;
	private boolean isAvaliable;
	private Player player;
	
	
	
	public AvaliableHour() {
		isAvaliable = true;
	}

	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public int getStartHour() {
		return startHour;
	}
	
	public void setStartHour(int startHour) {
		if (startHour < 0 || startHour > 23) throw new IllegalArgumentException();
		this.startHour = startHour;
	}
	
	public int getEndHour() {
		return endHour;
	}
	
	public void setEndHour(int endHour) {
		if (endHour < 0 || endHour > 23) throw new IllegalArgumentException();
		this.endHour = endHour;
	}
	

	public boolean isAvaliable() {
		return isAvaliable;
	}

	public void setAvaliable(boolean isAvaliable) {
		this.isAvaliable = isAvaliable;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "AvaliableHour [day=" + day + ", startHour=" + startHour + ", endHour=" + endHour + ", isAvaliable="
				+ isAvaliable + "]";
	}	
}
