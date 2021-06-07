package go_football.entity;

import java.util.ArrayList;
import java.util.List;

public class Player extends User{
	
	private double ewallet;
	private List<Invitation> invitations;
	
	
	public Player(String name, String password, String email, String phone, String location) {
		super(name, password, email, phone, location);
		this.ewallet = 0;
		invitations = new ArrayList<>();
	}


	public double getEwallet() {
		return ewallet;
	}

	public boolean withdraw(double amount) {
		if (amount < 0) throw new IllegalArgumentException();
		if (ewallet - amount < 0) return false;
		ewallet -= amount;
		return true;
	}	
	
	
	public void deposide(double amount) {
		if (amount < 0) throw new IllegalArgumentException();
		ewallet += amount;
	}
	
	public Invitation showLastInvitation() {
		return invitations.get(invitations.size()-1);
	}

	public List<Invitation> getInvitations() {
		return invitations;
	}
	
	public void addInvitation(Invitation invitation) {
		invitations.add(invitation);
	}
}