package com.kh.practice.list.library.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {
	
	private Scanner sc=new Scanner(System.in);
	private BookController bc=new BookController();

	public void mainMenu() {
		int cho=0;
		
		do {
		System.out.println("==== Welcome KH Library ====");
		System.out.println("****** 메인 메뉴 ******");
		System.out.println("1. 새 도서 추가");
		System.out.println("2. 도서 전체 조회");
		System.out.println("3. 도서 검색 조회");
		System.out.println("4. 도서 삭제");
		System.out.println("5. 도서명 오름차순 정렬");
		System.out.println("9. 종료");
		System.out.print("입력 : ");
		  cho=sc.nextInt();
		sc.nextLine();
			switch (cho) {
				case 1 : insertBook(); break;
				case 2 : selectList(); break;
				case 3 : searchBook(); break;
				case 4 : deleteBook(); break;
				case 5 : ascBook(); break;
				case 9 : break;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");break;
				
				}
		}while (cho!=9);
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void insertBook() {
		System.out.println("**** 도서등록 ****");
		System.out.print("도서명 :");
		String title=sc.nextLine();
		System.out.print("저자명 :");
		String author=sc.nextLine();
		System.out.print("장르(1.인문/2.자연과학/3.의료/4.기타) :");
				int genre=sc.nextInt();
				sc.nextLine();
			String strGenre="";
				  switch(genre) {
				  case 1 : strGenre="인문";break;
				  case 2 : strGenre="자연과학";break;
				  case 3 : strGenre="의료";break;
				  case 4 : strGenre="기타";break;
				  
				  }
		System.out.print("가격 : ");
		int price=sc.nextInt();
		
		  //입력받은 내용을 종합하여 저장하는 객체에 보내 저장 -> BookController
		Book b=new Book(title,author,strGenre,price);
		bc.insertBook(b);
	}
	
	public void selectList() {
		ArrayList<Book> list=bc.selectList();
		if(list.size()>0) {
			for(Book b : list) {
				System.out.println(b);
			}
		}else {
			System.out.println("존재하는 도서가 없습니다.");
		}
		
	}
	
	public void searchBook() {
		System.out.println("**** 도서 검색 ****");
		System.out.print("도서명 :");
		String keyword=sc.nextLine();
		ArrayList<Book>result=bc.searchBook(keyword);
		if(result.size()>0) {
			for(Book b : result) {
				System.out.println(b);
			}
		}else {
			System.out.println("검색한 결과가 없습니다.");
		}
		
	}
	
	public void deleteBook() {
		//Book을 지우는 화면을 보여주는 기능
		//어떤 Book을 지울지 결정하게 book을 보여주고 선택할 수 있음
		System.out.println("***** 도서 삭제하기 *****");
		System.out.print("삭제할 도서명 :");
		String title=sc.nextLine();
		System.out.print("삭제할 저자명 :");
		String author=sc.nextLine();
		Book b=bc.deleteBook(title, author);
		System.out.println("삭제한 도서");
		System.out.println(b);
		
	}
	
	public void ascBook() {
		//책 제목순으로 정렬된 내용을 보여주는 기능
		int result=bc.ascBook();
		System.out.println(result==1? "정렬되었습니다." : "정렬을 실패했습니다.");
		
		
	}
	
	
}
