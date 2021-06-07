package frontend;

import java.util.List;
import java.util.Scanner;

import go_football.entity.Player;
import go_football.entity.Playground;
import go_football.managers.PlayersManager;

public class PlayerMain {

	Scanner scanner;
	
	private PlayersManager manager;
	
	public PlayerMain(Player player, List<Player> otherPlayers, List<Playground> playgrounds) {
		scanner = new java.util.Scanner(System.in);
		manager = new PlayersManager(player, otherPlayers, playgrounds);
	}



	public void playerMain() {
		boolean logout = false;
		while(true) {
			if (logout)
				break;
			showMenu();
			int choice = Integer.parseInt(scanner.next());
			switch(choice) {
				case 1:
					showPlaygrounds();
					break;
				case 2:
					reservation();
					break;
				case 3:
					deposite();
					break;
				case 4:
					withdraw();
					break;
				case 5:
					cancel();
					break;
				case 6:
					invite();
					break;
				case 7:
					complain();
					break;
				case 8:
					logout = true;
					break;
			}
		}
	}
	
	
	private void invite() {
		System.out.println("Enter your friend ID: ");
		int playerId = Integer.parseInt(scanner.next());
		System.out.println("Enter the playground ID: ");
		int playgroundId = Integer.parseInt(scanner.next());
		try {
			manager.invitePlayer(playerId, playgroundId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void cancel() {
		System.out.println("Enter the playground ID: ");
		int playgroundId = Integer.parseInt(scanner.next());
		manager.cancel(playgroundId);
		System.out.println("Canceled");
	}


	public void showMenu() {
		System.out.println("1- show playground");
		System.out.println("2- booking");
		System.out.println("3- Deposit");
		System.out.println("4- Withdraw");
		System.out.println("5- Cancel booking");
		System.out.println("6- invite your friends");
		System.out.println("7- Complains");
		System.out.println("8- Logout");
	}
	
	
	public void showPlaygrounds() {
		System.out.println("Enter the location");
		String location = scanner.next().trim();
		manager.showPlaygrounds(location);
	}
	
	public void reservation() {
		System.out.println("please enter the playground ID: ");
		int playgroundId = Integer.parseInt(scanner.next());
		System.out.println("please enter the day: ");
		String day = scanner.next().trim();
		System.out.println("please enter Start hour: ");
		int startHour = Integer.parseInt(scanner.next());
		System.out.println("please enter End hour: ");
		int endHour = Integer.parseInt(scanner.next());
		Playground playground = null;
		try {
			playground = manager.reservePlayground(playgroundId, day, startHour, endHour);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if (playground == null)
			System.out.println("There is no money");
		else
		    System.out.println("Reservation completed!");
	}
	
	public void withdraw() {
		System.out.println("Enter how much you wanna withraw: ");
		int amount = Integer.parseInt(scanner.next());
		manager.withdraw(amount);
	}
	
	public void deposite() {
		System.out.println("Enter how much you wanna deposite:");
		int amount = Integer.parseInt(scanner.next());
		manager.deposite(amount);
	}
	
	public void complain() {
		System.out.println("Enter the playground ID");
		int playgroundId = Integer.parseInt(scanner.next());
		scanner.nextLine();
		System.out.println("Enter your complain: ");
		String complainMessage = scanner.nextLine();
		manager.complain(playgroundId, complainMessage);
	}
}
