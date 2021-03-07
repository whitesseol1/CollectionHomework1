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
	
	
 //객체를 나타내는 메소드(기능)
	//Object -> toString()
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", price=" + price + "]";
	}
	
	
	//객체의 동등성을 비교할 수 있는 메소드(기능)
	//Object -> equals() / hashcode();
	//참조형변수 주소값 말고 이 메소드로 비교
	@Override
	public boolean equals(Object o) {
		//클래스가 cast이 가능한지 확인 -> 다형성
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
	
	//객체의 우선순위를 비교할 수 있는 메소드(기능)
	//Comparable인터페이스에 선언 -> compareTo() 구현
	
	@Override
	public int compareTo(Book b) {
		return title.compareTo(b.title);
	}
	
	@Override
	public int hashCode() { //주소값을 일치시켜주는 메소드
		return Objects.hash(title,author,category,price);
	}
}
