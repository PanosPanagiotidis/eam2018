package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import main.Diatheths;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DiathethsRepository extends CrudRepository<Diatheths, Long>,JpaRepository<Diatheths,Long> {
	public Diatheths findByEmail(String email);
}
