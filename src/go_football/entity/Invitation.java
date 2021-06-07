package go_football.entity;

/***
* create class Invitation  
*/
public class Invitation {
	/***
	*Invitation's player
	*/
	private User player;
	/***
	* Invitation's avaliableHour
	*/
	private AvaliableHour avaliableHour;
	/***
	* Invitation's playground
	*/
	private Playground playground;
	
	/***
	*  this is constructor  Invitation
	*  @param  User player
	*  @param  AvaliableHour aviableHour
	*  @param  Playground playground
	*/
	public Invitation(User player, AvaliableHour avaliableHour, Playground playground) {
		this.player = player;
		this.avaliableHour = avaliableHour;
		this.playground = playground;
	}
	
	/***
	*   this method return Player 
	*  @return User
	*/
	public User getPlayer() {
		return player;
	}
	/***
	*  this method set Player
	*   @param User player 
	*/
	public void setPlayer(User player) {
		this.player = player;
	}
	
	/***
	*   this method return AvailableHours
	*   @return AvaliableHour 
	*/
	public AvaliableHour getAvaliableHour() {
		return avaliableHour;
	}
	
	/***
	*  this method set AvaliableHour 
	*   @param AvaliableHour avaliableHour
	*/
	public void setAvaliableHour(AvaliableHour avaliableHour) {
		this.avaliableHour = avaliableHour;
	}
	
	/***
	*  this method return Playground
	*  @return Playground 
	*/
	public Playground getPlayground() {
		return playground;
	}
	
	/***
	*   this method set Playground 
	*   @param Playground playground
	*/
	public void setPlayground(Playground playground) {
		this.playground = playground;
	}
}
