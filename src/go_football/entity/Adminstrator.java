package go_football.entity;

/***
* this class Adminstrator inherited from class user 
*/
public class Adminstrator extends User {

	/***
	 *this is Adminstrator constructor 
	 *@param String name 
	 *@param String password
	 *@param String email
	 *@param String phone
	 *@param String location 
	 */
	public Adminstrator(String name, String password, String email, String phone, String location) {
		super(name, password, email, phone, location);
	}
	
}
