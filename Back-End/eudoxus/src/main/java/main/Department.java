package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@OneToMany
	private List<Foithths> foithtes;
	public Department() {
		foithtes=new ArrayList<Foithths>();
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
	public List<Foithths> getFoithtes() {
		return foithtes;
	}
	public void addFoithths(Foithths foithths) {
		this.foithtes.add(foithths);
	}
}
