package com.kh.practice.list.library.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.kh.practice.list.library.model.vo.Book;

public class BookController {

	private List<Book> bookList=new ArrayList();
	
	public BookController() {
		bookList.add(new Book("자바의 정석", "남궁 성", "기타", 20000)  );		
		bookList.add(new Book("쉽게 배우는 알고리즘", "문병로","기타", 15000) );
		bookList.add(new Book("대화의 기술", "강보람", "인문", 17500)  );
		bookList.add(new Book("암 정복기", "박신우", "의료", 21000)  );
		
	}
	
	public void insertBook(Book bk) {
		//bookcontroller의 멤버변수 list에 값을 저장하는 기능
		//외부에서 저장할 값을 받아와야함. -> 매개변수 선언!
		bookList.add(bk);
	}
	
	public ArrayList<Book> selectList() {
		//list에 있는 값 출력해주는 기능 -> 요청한 곳으로 보내주는 기능
		
		return (ArrayList<Book>)bookList;
	}
	
	public ArrayList<Book> searchBook(String keyword) {
		  //list에 저장되어있는 값을 출력해주는 기능 조건이 있음
		//호출하는 곳에서 보내준 이름을 기준으로 부분일치하는 책들만 보내주기
		
		ArrayList<Book> searchList=new ArrayList();
		
		for(Book b : bookList) {
			 if( b.getTitle().contains(keyword) ) {
			 searchList.add(b);
			 }
		}
		return searchList;
	}
	
	public Book deleteBook(String title, String author) {
		Book result=null;
		
		for(Book b : bookList) {
			if(b.getTitle().equals(title) &&
			    b.getAuthor().equals(author)	) {
					result=b;
					
					bookList.remove(b);
					break;
			}
		}
		// 아니면 iterator 써서 하기, for each문 에러때문에
		return result;
	}
	
	public int ascBook() {
		Collections.sort(bookList);
		
		
		return 1;
	}
	
	
	
}
