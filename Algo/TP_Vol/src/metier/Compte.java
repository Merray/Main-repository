package metier;

public abstract class Compte {

	private String login, passWord;
	
	
	

	public Compte(String login, String passWord) {
		this.login = login;
		this.passWord = passWord;
	}

	public void setLogin(String login){
		this.login = login;
	}
	
	public String getLogin() {	
		return this.login;		
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String toString() {
		return "Compte [login=" + login + ", passWord=" + passWord + "]";
	}
	
	
	
}
