package com.kh.practice.list.library.model.vo;

import java.util.Objects;

public class Book implements Comparable<Book>{

	private String title;
	private String author;
	private String category;
	private int price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, String category, int price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
 //��ü�� ��Ÿ���� �޼ҵ�(���)
	//Object -> toString()
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", price=" + price + "]";
	}
	
	
	//��ü�� ����� ���� �� �ִ� �޼ҵ�(���)
	//Object -> equals() / hashcode();
	//���������� �ּҰ� ���� �� �޼ҵ�� ��
	@Override
	public boolean equals(Object o) {
		//Ŭ������ cast�� �������� Ȯ�� -> ������
		if(o instanceof Book) {
			Book b=(Book)o;
			     if(   this. title.equals(b.title) &&
					   this.author.equals(b.getAuthor()) 
	                  &&this.category.equals(b.getCategory()) 
	                  &&this.price==b.getPrice()  ) {
			        
	                	  return true;
			     }
        }
		
		return false;
	}
	
	//��ü�� �켱������ ���� �� �ִ� �޼ҵ�(���)
	//Comparable�������̽��� ���� -> compareTo() ����
	
	@Override
	public int compareTo(Book b) {
		return title.compareTo(b.title);
	}
	
	@Override
	public int hashCode() { //�ּҰ��� ��ġ�����ִ� �޼ҵ�
		return Objects.hash(title,author,category,price);
	}
}
