package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import main.Ekdoths;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EkdothsRepository extends CrudRepository<Ekdoths, Long>,JpaRepository<Ekdoths,Long> {
	public Ekdoths findByEmail(String email);
}
