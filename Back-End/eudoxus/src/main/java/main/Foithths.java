package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Foithths {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private int AM;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String phone;
	private int running_semester;
	private int num_of_previous_books;
	public int getAM() {
		return AM;
	}
	public void setAM(int aM) {
		AM = aM;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRunning_semester() {
		return running_semester;
	}
	public void setRunning_semester(int running_semester) {
		this.running_semester = running_semester;
	}
	public int getNum_of_previous_books() {
		return num_of_previous_books;
	}
	public void setNum_of_previous_books(int num_of_previous_books) {
		this.num_of_previous_books = num_of_previous_books;
	}
}
