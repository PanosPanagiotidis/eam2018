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
public class Bibliothiki {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private String name;
	private String address;
	private String email;
	private String password;
	private String phone;
	private String time_open;
	private String senior;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getTime_open() {
		return time_open;
	}
	public void setTime_open(String time_open) {
		this.time_open = time_open;
	}
	public String getSenior() {
		return senior;
	}
	public void setSenior(String senior) {
		this.senior = senior;
	}
}
