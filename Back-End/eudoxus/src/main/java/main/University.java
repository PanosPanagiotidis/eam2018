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
public class University {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private String name;
	@OneToMany
	private List<Department> departments;
	@OneToMany
	private List<Foithths> foithtes;
	public University() {
		departments=new ArrayList<Department>();
		foithtes=new ArrayList<Foithths>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void addDepartments(Department department) {
		this.departments.add(department);
	}
	public List<Foithths> getFoithtes() {
		return foithtes;
	}
	public void addFoithths(Foithths foithths) {
		this.foithtes.add(foithths);
	}
}
