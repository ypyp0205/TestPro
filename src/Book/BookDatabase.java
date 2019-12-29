package Book;

import java.util.ArrayList;








public class BookDatabase {

private static BookDatabase instance;
	
	private BookDatabase(){}
	
	public static BookDatabase getInstance() {
		if(instance == null){
			instance = new BookDatabase();
		}
		return instance;
	}
		
	public ArrayList<BookVO> tb_user = new ArrayList<>();
	
	{
		BookVO user = new BookVO();
		user.setId("asd");
		user.setPassword("asd");
		user.setName("asd");
		tb_user.add(user);
	}
		
	
	
	
	
}
