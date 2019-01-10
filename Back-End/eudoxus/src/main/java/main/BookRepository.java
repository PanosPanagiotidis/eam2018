package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import main.Book;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BookRepository extends CrudRepository<Book, Long>,JpaRepository<Book,Long> {
	public Book findByTitle(String title);
	public Book findByIsbn(String isbn);
	public Iterable<Book> findByWriters(String writers);
	
}
