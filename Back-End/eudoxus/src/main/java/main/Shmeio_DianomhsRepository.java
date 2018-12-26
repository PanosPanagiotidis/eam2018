package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import main.Shmeio_Dianomhs;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface Shmeio_DianomhsRepository extends CrudRepository<Shmeio_Dianomhs, Long>,JpaRepository<Shmeio_Dianomhs,Long> {
	public Shmeio_Dianomhs findByEmail(String email);
}