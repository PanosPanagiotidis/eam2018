package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Lesson {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private String name;
	private String instructor;
	private int semester;
	private String season;
	@OneToMany
	private List<Book> books;
	Lesson(){
		books=new ArrayList<Book>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void addBooks(Book book) {
		this.books.add(book);
	}
	
}
