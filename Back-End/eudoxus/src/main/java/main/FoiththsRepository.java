package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import main.Foithths;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FoiththsRepository extends CrudRepository<Foithths, Long>,JpaRepository<Foithths,Long> {
	public Foithths findByEmail(String email);
	public Foithths findByPin(String pin);
}
