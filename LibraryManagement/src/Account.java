
public abstract class Account {
	private String id;
	private String password;
	private AccountStatus status;
	private Person person;
	
	public boolean resetPassword(String id, String email, String newPassword) {
		if(id.equals(this.id) && email.equals(person.getEmail())) {
			this.password = newPassword;
			return true;
		}
		return false;
	};
}
