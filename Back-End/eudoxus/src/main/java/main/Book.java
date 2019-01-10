package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String title;
	public String isbn;
	public String writers;
	public int date;
	public String image;
	@ManyToOne
	public Ekdoths ekdoths;
	@ManyToMany
	public List<Shmeio_Dianomhs> shmeia_Dianomhs;
	public Book() throws IOException {
		shmeia_Dianomhs=new ArrayList<Shmeio_Dianomhs>();
		String path=(new File(".").getCanonicalPath() + "\\book.png");
		this.setImage(path);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	@JsonIgnore
	public List<Shmeio_Dianomhs> getShmeia_Dianomhs(){
		return shmeia_Dianomhs;
	}
}
