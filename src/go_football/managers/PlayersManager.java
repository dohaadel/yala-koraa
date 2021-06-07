package go_football.managers;

import java.util.List;

import go_football.entity.AvaliableHour;
import go_football.entity.Invitation;
import go_football.entity.Player;
import go_football.entity.Playground;

public class PlayersManager {
	private Player player;
	private List<Player> otherPlayers;
	private List<Playground> playgrounds;
	
	public PlayersManager(Player player, List<Player> otherPlayers, List<Playground> playgrounds) {
		this.player = player;
		this.otherPlayers = otherPlayers;
		this.playgrounds = playgrounds;
	}
	
	public void showPlaygrounds(String location) {
		for (Playground  playground : playgrounds) {
			if (playground.getLocation().equals(location))
				System.out.println(playground);
		}
	}
	
	private Playground getPlayground(int id) {
		for (Playground playground : playgrounds) {
			if (playground.getId() == id) {
				return playground;
			}
		}
		return null;
	}
	
	private AvaliableHour getAvaliableHour(List<AvaliableHour> avaliableHours, String day, int startHour, int endHour) {
		for (AvaliableHour tempAvaliableHour : avaliableHours) {
			if (tempAvaliableHour.isAvaliable() && tempAvaliableHour.getDay().equals(day)
					&& tempAvaliableHour.getStartHour() == startHour
					&& tempAvaliableHour.getEndHour() == endHour) {
				return tempAvaliableHour;
			}
		}
		return null;
	}
	
	public Playground reservePlayground(int playgroundId, String day, int startHour, int endHour) {
		Playground playground = getPlayground(playgroundId);
		if (playground == null) throw new IllegalArgumentException("There is no playground with this id!");
		int hours = endHour - startHour;
		double price = hours * playground.getPricePerHour();
		if (player.getEwallet() < price)
			return null;
		
		AvaliableHour avaliableHour = getAvaliableHour(playground.getAvaliableHours(), day, startHour, endHour);
		if (avaliableHour  == null) throw new IllegalArgumentException("There is no avaliable date in these time!");
		
		avaliableHour.setPlayer(player);
		avaliableHour.setAvaliable(false);
		player.withdraw(price);
		playground.getOwner().deposide(price);
		return playground;
	}
	
	public boolean cancel(int playgroundId) {
		Playground playground = getPlayground(playgroundId);
		if (playground == null) throw new IllegalArgumentException("There is no playground with this id!");
		for (AvaliableHour avaliableHour : playground.getAvaliableHours()) {
			if (avaliableHour.getPlayer() == player) {
				avaliableHour.setAvaliable(true);
				int hours = avaliableHour.getEndHour() - avaliableHour.getStartHour();
				double price = hours * playground.getPricePerHour();
				player.deposide(price);
				playground.getOwner().withdraw(price);
				return true;
			}
		}
		return false;
	}
	
	public void invitePlayer(int playerId, int playgroundId) {
		Playground playground = getPlayground(playgroundId);
		if (playground == null) throw new IllegalArgumentException("There is no playground with this id!");
		AvaliableHour avaliableHour = null;
		for (AvaliableHour tempAvaliableHour : playground.getAvaliableHours()) {
			if (tempAvaliableHour.getPlayer().equals(player)) {
				avaliableHour = tempAvaliableHour;
			}
		}
		
		Invitation invitation = new Invitation(player, avaliableHour, playground);
		for (Player otherPlayer : otherPlayers) {
			if (otherPlayer.getId() == playerId) {
				otherPlayer.addInvitation(invitation);
			}
		}
	}
	
	public boolean withdraw(int amount) {
		return player.withdraw(amount);
	}
	
	public void deposite(int amount) {
		player.deposide(amount);
	}
	
	// not implemented
	public void complain(int id, String complainMessage) {
		Playground playground = getPlayground(id);
		if (playground == null) throw new RuntimeException("There is no playground wih this id");
		playground.complain(player, complainMessage);
	}
}