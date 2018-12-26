package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import main.Grammateia;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface GrammateiaRepository extends CrudRepository<Grammateia, Long>,JpaRepository<Grammateia,Long> {
	public Grammateia findByEmail(String email);
}
