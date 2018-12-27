package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
/**
 * Database initializer that populates the database with some
 * initial bank accounts using a JPA repository.
 * 
 * This component is started only when app.db-init property is set to true
 */
@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializator implements CommandLineRunner {
	private UniversityRepository universityRepository;
    public DbInitializator(UniversityRepository universityRepository){
        this.universityRepository = universityRepository;
    }
    @Override
    public void run(String... strings) throws Exception {
    	University newUnivesity1=new University();
		University newUnivesity2=new University();
		newUnivesity1.setName("Εθνικο Και Καποδιστριακο Πανεπιστημιο Αθηνων");
		newUnivesity2.setName("Πανεπιστημιο Πειραιως");
		universityRepository.save(newUnivesity1);
		universityRepository.save(newUnivesity2);
    }
}
