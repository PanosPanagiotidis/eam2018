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
	private DepartmentRepository departmentRepository;
    public DbInitializator(UniversityRepository universityRepository,DepartmentRepository departmentRepository){
        this.universityRepository = universityRepository;
        this.departmentRepository = departmentRepository;
    }
    @Override
    public void run(String... strings) throws Exception {
    	University newUnivesity1=new University();
		University newUnivesity2=new University();
		newUnivesity1.setName("Εθνικο Και Καποδιστριακο Πανεπιστημιο Αθηνων");
		newUnivesity2.setName("Πανεπιστημιο Πειραιως");
		Department department1=new Department();
		Department department2=new Department();
		Department department3=new Department();
		Department department4=new Department();
		department1.setName("Πληροφορική και Τηλεπικοινωνιών");
		department2.setName("Φυσικο");
		department3.setName("Οργανωση και διοικιση Επιχειρησεων");
		department4.setName("Μαρκετινγκ");
		departmentRepository.save(department1);
		departmentRepository.save(department2);
		departmentRepository.save(department3);
		departmentRepository.save(department4);
		newUnivesity1.addDepartments(department1);
		newUnivesity1.addDepartments(department2);
		newUnivesity2.addDepartments(department3);
		newUnivesity2.addDepartments(department4);
		universityRepository.save(newUnivesity1);
		universityRepository.save(newUnivesity2);
    }
}
