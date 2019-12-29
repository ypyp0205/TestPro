package user;

import java.util.ArrayList;








public class UserDatabase {

private static UserDatabase instance;
	
	private UserDatabase(){}
	
	public static UserDatabase getInstance() {
		if(instance == null){
			instance = new UserDatabase();
		}
		return instance;
	}
		
	public ArrayList<UserVO> tb_user = new ArrayList<>();
	
	{
		UserVO user = new UserVO();
		user.setId("asd");
		user.setPassword("asd");
		user.setName("asd");
		tb_user.add(user);
	}
		
	
	
	
	
}
