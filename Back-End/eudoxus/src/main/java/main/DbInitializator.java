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
	private LessonRepository lessonRepository;
    public DbInitializator(LessonRepository lessonRepository,UniversityRepository universityRepository,DepartmentRepository departmentRepository,EkdothsRepository ekdothsRepository,BookRepository bookRepository){
        this.universityRepository = universityRepository;
        this.departmentRepository = departmentRepository;
        this.ekdothsRepository=ekdothsRepository;
        this.bookRepository=bookRepository;
        this.lessonRepository=lessonRepository;
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
    	book10.setISBN("123132-1224124-123134");
    	book10.setTitle("Αρχιτεκτονικη CPU");
    	book10.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book10.setEkdoths(ekdoths);
    	bookRepository.save(book10);
    	Book book11=new Book();
    	book11.setDate(2003);
    	book11.setISBN("1231332-122421124-123134");
    	book11.setTitle("Υπολογιστικα Συστηματα βασεις");
    	book11.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book11.setEkdoths(ekdoths);
    	bookRepository.save(book11);
    	Book book12=new Book();
    	book12.setDate(2003);
    	book12.setISBN("1231332-1224124-123134");
    	book12.setTitle("Υπολογιστικα Συστηματα δεδομενα");
    	book12.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book12.setEkdoths(ekdoths);
    	bookRepository.save(book12);
    	Book book13=new Book();
    	book13.setDate(2003);
    	book13.setISBN("1231332-12241214-123134");
    	book13.setTitle("Project threads");
    	book13.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book13.setEkdoths(ekdoths);
    	bookRepository.save(book13);
    	Book book14=new Book();
    	book14.setDate(2003);
    	book14.setISBN("1231332-12246124-12321134");
    	book14.setTitle("Project buckets");
    	book14.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book14.setEkdoths(ekdoths);
    	bookRepository.save(book14);
    	Book book15=new Book();
    	book15.setDate(2003);
    	book15.setISBN("123111332-12241214-123134");
    	book15.setTitle("Θεωρία Υπολογισμού turing");
    	book15.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book15.setEkdoths(ekdoths);
    	bookRepository.save(book15);
    	Book book16=new Book();
    	book16.setDate(2003);
    	book16.setISBN("123121332-12246124-12321134");
    	book16.setTitle("Θεωρία Υπολογισμού pru");
    	book16.setWriters("Nick Tsiougkranas,Alexandros Niarchos");
    	book16.setEkdoths(ekdoths);
    	bookRepository.save(book16);
    	
    	Lesson lesson1=new Lesson();
    	lesson1.setInstructor("Τσαγλατίδου");
    	lesson1.setName("Εισαγωγή Στην Πληροφορικη και τις Τηλεποικινωνίες");
    	lesson1.setSeason("Χειμερινό");
    	lesson1.setSemester(1);
    	lesson1.addBooks(book1);
    	lesson1.addBooks(book2);
    	lessonRepository.save(lesson1);
    	
    	Lesson lesson2=new Lesson();
    	lesson2.setInstructor("Δελής");
    	lesson2.setName("Προγραμματισμός Συστήματος");
    	lesson2.setSeason("Χειμερινό");
    	lesson2.setSemester(1);
    	lesson2.addBooks(book3);
    	lesson2.addBooks(book4);
    	lessonRepository.save(lesson2);
    	
    	Lesson lesson3=new Lesson();
    	lesson3.setInstructor("Σταματόπουλός");
    	lesson3.setName("Τεχνητή Νοημοσύνη");
    	lesson3.setSeason("Χειμερινό");
    	lesson3.setSemester(3);
    	lesson3.addBooks(book5);
    	lesson3.addBooks(book6);
    	lessonRepository.save(lesson3);
    	
    	Lesson lesson4=new Lesson();
    	lesson4.setInstructor("Ρουσσου");
    	lesson4.setName("ΕΑΜ");
    	lesson4.setSeason("Χειμερινό");
    	lesson4.setSemester(3);
    	lesson4.addBooks(book7);
    	lesson4.addBooks(book8);
    	lessonRepository.save(lesson4);
    	
    	Lesson lesson5=new Lesson();
    	lesson5.setInstructor("Πασχαλης");
    	lesson5.setName("Αρχιτεκτονική Υπολογιστών");
    	lesson5.setSeason("Χειμερινό");
    	lesson5.setSemester(7);
    	lesson5.addBooks(book9);
    	lesson5.addBooks(book10);
    	lessonRepository.save(lesson5);
    	
    	Lesson lesson6=new Lesson();
    	lesson6.setInstructor("Ιωαννίδης");
    	lesson6.setName("Υπολογιστικά Συστήματα");
    	lesson6.setSeason("Χειμερινό");
    	lesson6.setSemester(7);
    	lesson6.addBooks(book11);
    	lesson6.addBooks(book12);
    	lessonRepository.save(lesson6);
    	
    	Lesson lesson7=new Lesson();
    	lesson7.setInstructor("Ιωαννίδης");
    	lesson7.setName("Project");
    	lesson7.setSeason("Χειμερινό");
    	lesson7.setSemester(5);
    	lesson7.addBooks(book13);
    	lesson7.addBooks(book14);
    	lessonRepository.save(lesson7);
    	
    	Lesson lesson8=new Lesson();
    	lesson8.setInstructor("Ροντογιαννης");
    	lesson8.setName("Θεωρία Υπολογισμού");
    	lesson8.setSeason("Χειμερινό");
    	lesson8.setSemester(5);
    	lesson8.addBooks(book15);
    	lesson8.addBooks(book16);
    	lessonRepository.save(lesson8);
    	
    	
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
		department1.addLesson(lesson1);
		department1.addLesson(lesson2);
		department1.addLesson(lesson3);
		department1.addLesson(lesson4);
		department1.addLesson(lesson5);
		department1.addLesson(lesson6);
		department1.addLesson(lesson7);
		department1.addLesson(lesson8);
		departmentRepository.save(department1);
		departmentRepository.save(department2);
		departmentRepository.save(department3);
		departmentRepository.save(department4);
    }
}
