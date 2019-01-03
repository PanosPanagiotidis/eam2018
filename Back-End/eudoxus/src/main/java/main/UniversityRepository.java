package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import main.University;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UniversityRepository extends CrudRepository<University, Long>,JpaRepository<University,Long> {
	public University findByName(String name);
	public University findById(int id);
}