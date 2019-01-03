package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Department {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private String name;
	@OneToOne
	private Grammateia grammateia;
	@ManyToOne
	private University university;
	@OneToMany
	private List<Lesson> lessons;
	public Department(){
		lessons=new ArrayList<Lesson>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grammateia getGrammateia() {
		return grammateia;
	}
	public void setGrammateia(Grammateia grammateia) {
		this.grammateia=grammateia;
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void addLesson(Lesson lesson) {
		this.lessons.add(lesson);
	}
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
}
