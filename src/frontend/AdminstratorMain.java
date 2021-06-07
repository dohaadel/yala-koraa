package frontend;

import java.util.List;
import java.util.Scanner;

import go_football.entity.Adminstrator;
import go_football.entity.Complain;
import go_football.entity.PlayGroundOwner;
import go_football.entity.Player;
import go_football.entity.Playground;
import go_football.entity.User;
import go_football.managers.AdminstratorManager;

/***
* this is AdminstratorMain class 
*/
public class AdminstratorMain {
	
	Scanner scanner;
	/***
	* adminstratorManager
	*/
	private AdminstratorManager adminstratorManager;
	
	/***
	 * AdminstratorMain constructor
	 * @param Adminstrator adminstrator 
	 * @param List<Playground> playgrounds
	 * @param List<Player> players
	 * @param List<PlayGroundOwner> groundOwners
	 */ 
	public AdminstratorMain(Adminstrator adminstrator, List<Playground> playgrounds, List<Player> players, List<PlayGroundOwner> groundOwners) {
		this.scanner = new Scanner(System.in);
		this.adminstratorManager = new AdminstratorManager(adminstrator, playgrounds, players, groundOwners);
	}
	
	/***
	 * this method used to view administratorMain
	 */ 
	public void adminstratorMain() {
		boolean logout = false;
		while(true) {
			if (logout)
				break;
			showMenu();
			int choice = Integer.parseInt(scanner.next());
			switch(choice) {
				case 1:
					getUser();
					break;
				case 2:
					deleteUser();
					break;
				case 3:
					getPlayground();
					break;
				case 4:
					removePlayground();
					break;
				case 5:
					viewComplain();
					break;
				case 6:
					logout = true;
					break;
			}
		}
	}
	/***
	 * this method showMenu 
	 */
	private void showMenu() {
		System.out.println("1- Show user");
		System.out.println("2- Delete user");
		System.out.println("3- Show playground");
		System.out.println("4- Remove playgroud");
		System.out.println("5- See complains ");
		System.out.println("6- Logout");
		
	}

	/***
	 * this method get used to getUser 
	 */
	
	public void getUser() {
		System.out.println("Enter the user ID");
		int id = Integer.parseInt(scanner.next());
		User user = adminstratorManager.getUser(id);
		System.out.println(user);
	}
	
	/***
	 * this method used to deleteUser 
	 */
	public void deleteUser() {
		System.out.println("Enter the user ID");
		int id = Integer.parseInt(scanner.next());
		adminstratorManager.removeUser(id);
		
	}
	
	/***
	 * this method used to getPlayground
	 */
	public void getPlayground() {
		System.out.println("Enter the playground ID");
		int id = Integer.parseInt(scanner.next());
		Playground playground = adminstratorManager.getPlayground(id);
		System.out.println(playground);
	}
	
	/***
	 * this method used to viewComplains
	 */
	public void viewComplain() {
		System.out.println("Enter the playground ID ");
		int id = Integer.parseInt(scanner.next());
		List<Complain> complains = adminstratorManager.showComplains(id);
		System.out.println(complains);
	}
	
	/***
	 * this method used to removePlayground
	 */
	public void removePlayground() {
		System.out.println("Enter the playground ID ");
		int id = Integer.parseInt(scanner.next());
		adminstratorManager.removePlayground(id);
	}
}
