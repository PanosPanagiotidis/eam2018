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
	private EkdothsRepository ekdothsRepository;
	private BookRepository bookRepository;
    public DbInitializator(UniversityRepository universityRepository,DepartmentRepository departmentRepository,EkdothsRepository ekdothsRepository,BookRepository bookRepository){
        this.universityRepository = universityRepository;
        this.departmentRepository = departmentRepository;
        this.ekdothsRepository=ekdothsRepository;
        this.bookRepository=bookRepository;
    }
    @Override
    public void run(String... strings) throws Exception {
    	Ekdoths ekdoths=new Ekdoths();
    	ekdoths.setAddress("Μακεδονίας 39");
    	ekdoths.setEmail("ekdoths@gmail.com");
    	ekdoths.setName("Ψυχογιος");
    	ekdoths.setPassword("123");
    	ekdoths.setPhone("6983302144");
    	ekdoths.setSenior("Ψυχογιός");
    	ekdoths.setTime_open("24/7");
    	ekdothsRepository.save(ekdoths);
    	Book book1=new Book();
    	book1.setDate(2001);
    	book1.setISBN("1231-12412-12314");
    	book1.setTitle("Εισαγωγή στην Πληροφορικη");
    	book1.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book1.setEkdoths(ekdoths);
    	bookRepository.save(book1);
    	Book book2=new Book();
    	book2.setDate(2002);
    	book2.setISBN("1231-12412-1231245");
    	book2.setTitle("Εισαγωγή στις Τηλεποικινωνίες");
    	book2.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book2.setEkdoths(ekdoths);
    	bookRepository.save(book2);
    	Book book3=new Book();
    	book3.setDate(2003);
    	book3.setISBN("123132-12412-12314");
    	book3.setTitle("Προγραμματισμος Συστήματος μνημη");
    	book3.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book3.setEkdoths(ekdoths);
    	bookRepository.save(book3);
    	Book book4=new Book();
    	book4.setDate(2004);
    	book4.setISBN("12312-12412-12314");
    	book4.setTitle("Προγραμματισμος Συστήματος Σύστημα");
    	book4.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book4.setEkdoths(ekdoths);
    	bookRepository.save(book4);
    	Book book5=new Book();
    	book5.setDate(2003);
    	book5.setISBN("123132-125312-12314");
    	book5.setTitle("Τεχνητη Νοημοσύνη Πακμαν");
    	book5.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book5.setEkdoths(ekdoths);
    	bookRepository.save(book5);
    	Book book6=new Book();
    	book6.setDate(2003);
    	book6.setISBN("123132-124212-12314");
    	book6.setTitle("Τεχνητη νοημοσύνη κοριντορ");
    	book6.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book6.setEkdoths(ekdoths);
    	bookRepository.save(book6);
    	Book book7=new Book();
    	book7.setDate(2003);
    	book7.setISBN("1231732-12412-12314");
    	book7.setTitle("ΕΑΜ ιστοσελίδες");
    	book7.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book7.setEkdoths(ekdoths);
    	bookRepository.save(book7);
    	Book book8=new Book();
    	book8.setDate(2003);
    	book8.setISBN("1231132-12412-12314");
    	book8.setTitle("ΕΑΜ εφαρμογες");
    	book8.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book8.setEkdoths(ekdoths);
    	bookRepository.save(book8);
    	Book book9=new Book();
    	book9.setDate(2003);
    	book9.setISBN("123132-1224124-12314");
    	book9.setTitle("Αρχιτεκτονικη μνημης");
    	book9.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book9.setEkdoths(ekdoths);
    	bookRepository.save(book9);
    	Book book10=new Book();
    	book10.setDate(2003);
    	book10.setISBN("123132-1224124-12314");
    	book10.setTitle("Αρχιτεκτονικη CPU");
    	book10.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book10.setEkdoths(ekdoths);
    	bookRepository.save(book10);
    	
    	University newUnivesity1=new University();
		University newUnivesity2=new University();
		newUnivesity1.setName("Εθνικο Και Καποδιστριακο Πανεπιστημιο Αθηνων");
		newUnivesity2.setName("Πανεπιστημιο Πειραιως");
		universityRepository.save(newUnivesity1);
		universityRepository.save(newUnivesity2);
		Department department1=new Department();
		Department department2=new Department();
		Department department3=new Department();
		Department department4=new Department();
		department1.setName("Πληροφορική και Τηλεπικοινωνιών");
		department2.setName("Φυσικο");
		department3.setName("Οργανωση και διοικιση Επιχειρησεων");
		department4.setName("Μαρκετινγκ");
		department1.setUniversity(newUnivesity1);
		department2.setUniversity(newUnivesity1);
		department3.setUniversity(newUnivesity2);
		department4.setUniversity(newUnivesity2);
		departmentRepository.save(department1);
		departmentRepository.save(department2);
		departmentRepository.save(department3);
		departmentRepository.save(department4);
    }
}
