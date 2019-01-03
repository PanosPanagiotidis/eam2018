package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import main.Lesson;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LessonRepository extends CrudRepository<Lesson, Long>,JpaRepository<Lesson,Long> {
	public Lesson findByName(String name);
}
