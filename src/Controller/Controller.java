package Controller;

import java.util.Scanner;

import user.UserService;
import user.UserServiceImpl;



public class Controller {

	UserService userSurvice = UserServiceImpl.getInstance();
	
	public static void main(String[] args) {
		/*
		 * Controller	: 메뉴 선택
		 * Service		: 메뉴 기능 수행
		 * Dao			: 데이터 베이스 접속
		 * Vo			: 데이터를 담는 클래스
		 */
		new Controller().begin();
	}
	
	private void begin() {
		Scanner s = new Scanner(System.in);
		
		int menu;
		
		do{
			System.err.println("---------메뉴---------");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원목록");
			System.out.println("0. 프로그램 종료");
			System.out.println("---------------------");
			System.out.println("메뉴에 해당하는 번호 입력");
			
			menu = Integer.parseInt(s.nextLine());
			
			switch (menu) {
			case 1:  //회원가입
				userSurvice.join();
				break;
			case 2:  //로그인
				userSurvice.login();
				break;
			case 3:  //회원목록
				userSurvice.userList();
				break;
			case 0:  //프로그램 종료
				System.out.println("프로그램 종료");
				break;
			}
			}while (menu != 0);
				
			
			
		
	}
}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		



