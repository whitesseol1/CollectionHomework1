package com.kh.practice.list.library.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.kh.practice.list.library.model.vo.Book;

public class BookController {

	private List<Book> bookList=new ArrayList();
	
	public BookController() {
		bookList.add(new Book("�ڹ��� ����", "���� ��", "��Ÿ", 20000)  );		
		bookList.add(new Book("���� ���� �˰���", "������","��Ÿ", 15000) );
		bookList.add(new Book("��ȭ�� ���", "������", "�ι�", 17500)  );
		bookList.add(new Book("�� ������", "�ڽſ�", "�Ƿ�", 21000)  );
		
	}
	
	public void insertBook(Book bk) {
		//bookcontroller�� ������� list�� ���� �����ϴ� ���
		//�ܺο��� ������ ���� �޾ƿ;���. -> �Ű����� ����!
		bookList.add(bk);
	}
	
	public ArrayList<Book> selectList() {
		//list�� �ִ� �� ������ִ� ��� -> ��û�� ������ �����ִ� ���
		
		return (ArrayList<Book>)bookList;
	}
	
	public ArrayList<Book> searchBook(String keyword) {
		  //list�� ����Ǿ��ִ� ���� ������ִ� ��� ������ ����
		//ȣ���ϴ� ������ ������ �̸��� �������� �κ���ġ�ϴ� å�鸸 �����ֱ�
		
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
		// �ƴϸ� iterator �Ἥ �ϱ�, for each�� ����������
		return result;
	}
	
	public int ascBook() {
		Collections.sort(bookList);
		
		
		return 1;
	}
	
	
	
}
