package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import main.Department;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DepartmentRepository extends CrudRepository<Department, Long>,JpaRepository<Department,Long> {
	public Department findByName(String name);
}