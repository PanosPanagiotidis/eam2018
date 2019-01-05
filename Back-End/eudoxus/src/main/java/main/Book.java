package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String title;
	public String ISBN;
	public String writers;
	public int date;
	@ManyToOne
	public Ekdoths ekdoths;
	@ManyToMany
	public List<Shmeio_Dianomhs> shmeia_Dianomhs;
	public Book() {
		shmeia_Dianomhs=new ArrayList<Shmeio_Dianomhs>();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getWriters() {
		return writers;
	}
	public void setWriters(String writers) {
		this.writers = writers;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public Ekdoths getEkdoths() {
		return ekdoths;
	}
	public void setEkdoths(Ekdoths ekdoths) {
		this.ekdoths = ekdoths;
	}
	public void addShmeio_Dianomhs(Shmeio_Dianomhs shmeio_Dianomhs) {
		this.shmeia_Dianomhs.add(shmeio_Dianomhs);
	}
	public List<Shmeio_Dianomhs> getShmeia_Dianomhs(){
		return shmeia_Dianomhs;
	}
}
