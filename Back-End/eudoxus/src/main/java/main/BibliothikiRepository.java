package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import main.Bibliothiki;


public interface BibliothikiRepository extends CrudRepository<Bibliothiki, Long>,JpaRepository<Bibliothiki,Long> {
	public Bibliothiki findByEmail(String email);
}
