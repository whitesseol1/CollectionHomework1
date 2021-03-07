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
		System.out.println("****** ���� �޴� ******");
		System.out.println("1. �� ���� �߰�");
		System.out.println("2. ���� ��ü ��ȸ");
		System.out.println("3. ���� �˻� ��ȸ");
		System.out.println("4. ���� ����");
		System.out.println("5. ������ �������� ����");
		System.out.println("9. ����");
		System.out.print("�Է� : ");
		  cho=sc.nextInt();
		sc.nextLine();
			switch (cho) {
				case 1 : insertBook(); break;
				case 2 : selectList(); break;
				case 3 : searchBook(); break;
				case 4 : deleteBook(); break;
				case 5 : ascBook(); break;
				case 9 : break;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");break;
				
				}
		}while (cho!=9);
		System.out.println("���α׷��� �����մϴ�.");
	}
	
	public void insertBook() {
		System.out.println("**** ������� ****");
		System.out.print("������ :");
		String title=sc.nextLine();
		System.out.print("���ڸ� :");
		String author=sc.nextLine();
		System.out.print("�帣(1.�ι�/2.�ڿ�����/3.�Ƿ�/4.��Ÿ) :");
				int genre=sc.nextInt();
				sc.nextLine();
			String strGenre="";
				  switch(genre) {
				  case 1 : strGenre="�ι�";break;
				  case 2 : strGenre="�ڿ�����";break;
				  case 3 : strGenre="�Ƿ�";break;
				  case 4 : strGenre="��Ÿ";break;
				  
				  }
		System.out.print("���� : ");
		int price=sc.nextInt();
		
		  //�Է¹��� ������ �����Ͽ� �����ϴ� ��ü�� ���� ���� -> BookController
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
			System.out.println("�����ϴ� ������ �����ϴ�.");
		}
		
	}
	
	public void searchBook() {
		System.out.println("**** ���� �˻� ****");
		System.out.print("������ :");
		String keyword=sc.nextLine();
		ArrayList<Book>result=bc.searchBook(keyword);
		if(result.size()>0) {
			for(Book b : result) {
				System.out.println(b);
			}
		}else {
			System.out.println("�˻��� ����� �����ϴ�.");
		}
		
	}
	
	public void deleteBook() {
		//Book�� ����� ȭ���� �����ִ� ���
		//� Book�� ������ �����ϰ� book�� �����ְ� ������ �� ����
		System.out.println("***** ���� �����ϱ� *****");
		System.out.print("������ ������ :");
		String title=sc.nextLine();
		System.out.print("������ ���ڸ� :");
		String author=sc.nextLine();
		Book b=bc.deleteBook(title, author);
		System.out.println("������ ����");
		System.out.println(b);
		
	}
	
	public void ascBook() {
		//å ��������� ���ĵ� ������ �����ִ� ���
		int result=bc.ascBook();
		System.out.println(result==1? "���ĵǾ����ϴ�." : "������ �����߽��ϴ�.");
		
		
	}
	
	
}
