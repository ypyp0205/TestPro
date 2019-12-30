package Book;

import java.util.Scanner;

import VO.BookVO;
import Dao.BookBasketDao;
import Dao.BookDao;
import Dao.LoginDao;

public class BookServiceImpl implements BookService{

	@Override
	public void registBook() {
		String name;
        String categoryName;
        String  publishCompanyName;
        String  authorName;
        int  countOfbook;
        Scanner scanner=new Scanner(System.in);
        System.out.print("책이름 입력: ");
        name=scanner.nextLine();
        System.out.print("카테고리 입력: ");
        categoryName=scanner.nextLine();
        System.out.print("출판사 이름:");
        publishCompanyName=scanner.nextLine();
        System.out.print("저자 이름 :");
        authorName=scanner.nextLine();
        System.out.println("등록할 책의갯수");
        countOfbook=Integer.parseInt(scanner.nextLine());
        BookVO bookVO=new BookVO();
        bookVO.setName(name);
        bookVO.setCategoryName(categoryName);
        bookVO.setPublishCompanyName(publishCompanyName);
        bookVO.setAuthorName(authorName);
        bookVO.setCountOfbook(countOfbook);
        BookList.add(bookVO);
		
	}

	@Override
	public void searchBook() {
		Scanner s = new Scanner(System.in);
    	String yn;
    	System.out.println("검색어를 입력해주세요>");
    	String userSearch = s.nextLine();

        boolean b1 = false;    
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
    	int noSearch = 0;
        
    	System.out.print("\""+userSearch + "\"" + "으로 ");
    	System.out.println("검색하신 결과입니다.");
    	System.out.println("==============================================");
    	
        for(int i = 0; i < BookList.size(); i++){
        b1 = BookList.get(i).getCategoryName().toLowerCase().replace(" ", "").contains(userSearch.replace(" ", "").toLowerCase());  
        b2 = BookList.get(i).getName().toLowerCase().replace(" ", "").contains(userSearch.replace(" ", "").toLowerCase());
        b3 = BookList.get(i).getAuthorName().toLowerCase().replace(" ", "").contains(userSearch.replace(" ", "").toLowerCase());
        b4 = BookList.get(i).getPublishCompanyName().toLowerCase().replace(" ", "").contains(userSearch.replace(" ", "").toLowerCase());
        
        if(b1 == true || b2 == true || b3 == true || b4 == true){
        	
        	System.out.println("카테고리 : " +  BookList.get(i).getCategoryName());
        	System.out.println("책이름 : " +  BookList.get(i).getName());
        	System.out.println("작가 : " +  BookList.get(i).getAuthorName());
        	System.out.println("출판일 : " +  BookList.get(i).getRegDate());
        	System.out.println("출판사 : " +  BookList.get(i).getPublishCompanyName());
        	System.out.println("재고 : " +  BookList.get(i).getCountOfbook());
        	String getName = BookList.get(i).getName();
        	System.out.println("==============================================");
        	System.out.println("장바구니에 추가 하시겠습니까.");
            yn = s.nextLine();            
        	if(yn.equals("Y")){
        	BookBasketDao.BookBasket(getName);
        	}else{
        	searchBook();
        	}
        	
        	
           }else if(b1 != true && b2 != true && b3 != true){
        	   noSearch++;
           }

        }//for문 종료
        
        if(noSearch == BookList.size()){
        System.out.println("검색하신 도서가 없습니다.");
    	System.out.println("==============================================");
        }
    			
	}

	@Override
	public void searchBuyBook() {
		 String name;
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("구매를 위한 검색을 시작합니다.");
	        System.out.print("책이름을 입력해주세요");
	        name = scanner.nextLine();
	        if (LoginDao.loginSessionVO.getRoll().equals("admin")) {
	            //System.out.println("관리자용 구매 페이지");
	            int searchIdx = -1;
	            for (int i = 0; i < BookDao.BookList.size(); i++) {
	                if (BookDao.BookList.get(i).getName().equals(name)) {
	                    searchIdx = i;
	                }
	                if (searchIdx == -1) {
	                    System.out.println("해당도서는 우리 서점에 없습니다. 이 도서를 등록할까요");
	                    registBook();
	                }
	                System.out.println(BookDao.BookList.get(searchIdx).getName());
	                System.out.println(BookDao.BookList.get(searchIdx).getCountOfbook());
	                System.out.println(BookDao.BookList.get(searchIdx).getPublishCompanyName());
	                if (BookDao.BookList.get(searchIdx).getCountOfbook() == 0) {
	                    int bookInsert;
	                    System.out.println("해당 출판사의 도서를 몇권을 더 주문할까요?");
	                    bookInsert = Integer.parseInt(scanner.nextLine());
	                    System.out.println("알겠습니다. 도서를 주문하였습니다. 해당 협력사에게 주문을 요청하였습니다.");
	                }
	                else if (BookDao.BookList.get(searchIdx).getCountOfbook() > 0) {//베스트 셀러인경우 0이 아닐떄도  재고를 추가해주는 기능 아래서 구현하기 
	                    
	                }
	        
	            }
	        } else if (LoginDao.loginSessionVO.getRoll().equals("user")) {
	            //System.out.println("일반유저용 구매 페이지");
			}
		
	}

	@Override
	public void bookRating() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
}
