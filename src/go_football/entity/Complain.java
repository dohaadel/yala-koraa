package go_football.entity;

/***
 * this is Complain class that takes complains
 */
public class Complain {
	/***
	 * complain's playground
	 */
	private Playground playground;
	/***
	 * complain's player
	 */
	private Player player;
	/***
	 * complain's Complaine
	 */
	private String complaine;

	/***
	 * this is Complain constructor
	 * 
	 * @param Playground playground
	 * @param Player  player
	 * @param Strin   complaine
	 */
	public Complain(Playground playground, Player player, String complaine) {
		this.playground = playground;
		this.player = player;
		this.complaine = complaine;
	}

	/***
	 * this method return Playground
	 * 
	 * @return Playground
	 */
	public Playground getPlayground() {
		return playground;
	}

	/***
	 * this method set Playground
	 * 
	 * @param Playground playground
	 */
	public void setPlayground(Playground playground) {
		this.playground = playground;
	}

	/***
	 * this method return Player
	 * 
	 * @return Player
	 */
	public Player getPlayer() {
		return player;
	}

	/***
	 * this method set Player
	 * 
	 * @param Player player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/***
	 * this method return Complaine
	 * 
	 * @return String
	 */
	public String getComplaine() {
		return complaine;
	}

	/***
	 * this method set a Complaine
	 * 
	 * @param String complaine
	 */
	public void setComplaine(String complaine) {
		this.complaine = complaine;
	}
	
	/***
	 * override toString method for Complain class
	 * @return String
	 */
	@Override
	public String toString() {
		return "Complain [playground=" + playground + ", player=" + player + ", complaine=" + complaine + "]";
	}

}
