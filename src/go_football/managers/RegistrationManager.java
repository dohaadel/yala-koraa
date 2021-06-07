package go_football.managers;

import java.util.List;

import go_football.entity.Adminstrator;
import go_football.entity.PlayGroundOwner;
import go_football.entity.Player;
import go_football.entity.User;

public class RegistrationManager {
	
	
	public User login(String email, String password, List<Player> players, List<PlayGroundOwner> owners) {
		for (User user : players) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) 
				return user;
		}
		
		for (User user : owners) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) 
				return user;
		}
		return null;
	}
	
	public User register(String name, String password, String email, String phone, String location, List<Player> players, List<PlayGroundOwner> owners, List<Adminstrator> admins, String type) {
		User user;
		if (type == "PLAYER") {
			user = new Player(name, password, email, phone, location);
			players.add((Player) user);
		}
		else if (type == "OWNER"){
			user = new PlayGroundOwner(name, password, email, phone, location);
			owners.add((PlayGroundOwner) user);
		} else {
			user = new Adminstrator(name, password, email, phone, location);
			admins.add((Adminstrator) user);
		}
		return user;
	}
}
