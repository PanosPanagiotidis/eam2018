package main;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import main.EkdothsRepository;
import main.FoiththsRepository;
import main.Shmeio_DianomhsRepository;
import main.GrammateiaRepository;
import main.DiathethsRepository;
import main.BibliothikiRepository;
import main.UniversityRepository;
import main.DepartmentRepository;

@CrossOrigin
@Controller    // This means that this class is a Controller
public class MainController {
	@Autowired
	private EkdothsRepository ekdothsRepository;
	@Autowired
	private FoiththsRepository foiththsRepository;
	@Autowired
	private Shmeio_DianomhsRepository shmeio_DianomhsRepository;
	@Autowired
	private GrammateiaRepository grammateiaRepository;
	@Autowired
	private DiathethsRepository diathethsRepository;
	@Autowired
	private BibliothikiRepository bibliothikiRepository;
	@Autowired
	private UniversityRepository universityRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private BookRepository bookRepository;
	

	@RequestMapping(method=RequestMethod.PUT,path="/signup_foithths") // Map ONLY GET Requests
	public @ResponseBody boolean signup_foithths (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		if(ekdothsRepository.findByEmail(email)!=null || foiththsRepository.findByEmail(email)!=null || shmeio_DianomhsRepository.findByEmail(email)!=null || grammateiaRepository.findByEmail(email)!=null || bibliothikiRepository.findByEmail(email)!=null || diathethsRepository.findByEmail(email)!=null) {
			return false;
		}
		String password=stk.nextToken();
		stk = new StringTokenizer(credentials,":");
		String university_name=stk.nextToken();
		String department_name=stk.nextToken();
		int AM=Integer.parseInt(stk.nextToken());
		String name=stk.nextToken();
		String surname=stk.nextToken();
		String phone=stk.nextToken();
		int running_semester=Integer.parseInt(stk.nextToken());
		int numofbooks=Integer.parseInt(stk.nextToken());
		University university=universityRepository.findByName(university_name);
		Department department=departmentRepository.findByName(department_name);
		Foithths newfoithths=new Foithths();
		newfoithths.setAM(AM);
		newfoithths.setEmail(email);
		newfoithths.setPassword(password);
		newfoithths.setNum_of_previous_books(numofbooks);
		newfoithths.setPhone(phone);
		newfoithths.setRunning_semester(running_semester);
		newfoithths.setName(name);
		newfoithths.setSurname(surname);
		newfoithths.setDepartment(department);
		newfoithths.setUniversity(university);
		foiththsRepository.save(newfoithths);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="/signup_shmeio_dianomhs") // Map ONLY GET Requests
	public @ResponseBody boolean signup_shmeio_dianomhs (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		if(ekdothsRepository.findByEmail(email)!=null || foiththsRepository.findByEmail(email)!=null || shmeio_DianomhsRepository.findByEmail(email)!=null || grammateiaRepository.findByEmail(email)!=null || bibliothikiRepository.findByEmail(email)!=null || diathethsRepository.findByEmail(email)!=null) {
			return false;
		}
		String password=stk.nextToken();
		stk = new StringTokenizer(credentials,":");
		String name=stk.nextToken();
		String type=stk.nextToken();
		String address=stk.nextToken();
		String phone=stk.nextToken();
		String time_open=stk.nextToken();
		String senior=stk.nextToken();
		Shmeio_Dianomhs newshmeio_dianomhs=new Shmeio_Dianomhs();
		newshmeio_dianomhs.setAddress(address);
		newshmeio_dianomhs.setEmail(email);
		newshmeio_dianomhs.setName(name);
		newshmeio_dianomhs.setPassword(password);
		newshmeio_dianomhs.setPhone(phone);
		newshmeio_dianomhs.setSenior(senior);
		newshmeio_dianomhs.setTime_open(time_open);
		newshmeio_dianomhs.setType(type);
		shmeio_DianomhsRepository.save(newshmeio_dianomhs);
		return true;
	}
	

	@RequestMapping(method=RequestMethod.GET, path="/login")
	public @ResponseBody int loginUser(@RequestHeader("Authorization") String encoded) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		Ekdoths ekdoths=ekdothsRepository.findByEmail(email);
		Foithths foithths=foiththsRepository.findByEmail(email);
		Shmeio_Dianomhs shmeio_dianomhs=shmeio_DianomhsRepository.findByEmail(email);
		Grammateia grammateia=grammateiaRepository.findByEmail(email);
		Diatheths diatheths=diathethsRepository.findByEmail(email);
		Bibliothiki bibliothiki=bibliothikiRepository.findByEmail(email);
		if(ekdoths!=null) {
			if(ekdoths.getPassword().equals(password))
				return 1;
		}
		else if(foithths!=null) {
			if(foithths.getPassword().equals(password))
				return 2;
		}
		else if(shmeio_dianomhs!=null) {
			if(shmeio_dianomhs.getPassword().equals(password))
				return 3;
		}
		else if(grammateia!=null) {
			if(grammateia.getPassword().equals(password))
				return 4;
		}
		else if(diatheths!=null) {
			if(diatheths.getPassword().equals(password))
				return 5;
		}
		else if(bibliothiki!=null) {
			if(bibliothiki.getPassword().equals(password))
				return 6;
		}
		return 0;
	}

	@RequestMapping(method=RequestMethod.GET, path="/get_foithths_details")
	public @ResponseBody Foithths get_foithths_details(@RequestHeader("Authorization") String encoded) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		Foithths foithths=foiththsRepository.findByEmail(email);
		return foithths;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/get_university_details")
	public @ResponseBody University get_university_details(@RequestHeader("Authorization") String encoded) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		Foithths foithths=foiththsRepository.findByEmail(email);
		return foithths.getUniversity();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/get_department_details")
	public @ResponseBody Department get_department_details(@RequestHeader("Authorization") String encoded) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		Foithths foithths=foiththsRepository.findByEmail(email);
		return foithths.getDepartment();
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="/update_foithths") // Map ONLY GET Requests
	public @ResponseBody boolean update_foithths (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		stk = new StringTokenizer(credentials,":");
		String name=stk.nextToken();
		String surname=stk.nextToken();
		String phone=stk.nextToken();
		String newemail=stk.nextToken();
		if(!newemail.equals(email)) {
			if(ekdothsRepository.findByEmail(newemail)!=null || foiththsRepository.findByEmail(newemail)!=null  || shmeio_DianomhsRepository.findByEmail(newemail)!=null || grammateiaRepository.findByEmail(newemail)!=null || bibliothikiRepository.findByEmail(newemail)!=null || diathethsRepository.findByEmail(newemail)!=null) {
				return false;
			}
		}
		Foithths foithths=foiththsRepository.findByEmail(email);
		foithths.setEmail(newemail);
		foithths.setPassword(password);
		foithths.setPhone(phone);
		foithths.setName(name);
		foithths.setSurname(surname);
		foiththsRepository.save(foithths);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/getuniversity_types") // Map ONLY GET Requests
	public @ResponseBody Iterable<University> getuniversity_types (@RequestHeader("Authorization") String encoded) {
		List<University> universities=new ArrayList<University>();
		universities=universityRepository.findAll();
		return universities;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/get_shmeio_details")
	public @ResponseBody Shmeio_Dianomhs get_shmeio_details(@RequestHeader("Authorization") String encoded) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		Shmeio_Dianomhs shmeio_Dianomhs=shmeio_DianomhsRepository.findByEmail(email);
		return shmeio_Dianomhs;
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="/update_shmeio") // Map ONLY GET Requests
	public @ResponseBody boolean update_shmeio (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		stk = new StringTokenizer(credentials,":");
		String name=stk.nextToken();
		String phone=stk.nextToken();
		String newemail=stk.nextToken();
		String address=stk.nextToken();
		String time_open=stk.nextToken();
		String senior=stk.nextToken();
		if(!newemail.equals(email)) {
			if(ekdothsRepository.findByEmail(newemail)!=null || foiththsRepository.findByEmail(newemail)!=null  || shmeio_DianomhsRepository.findByEmail(newemail)!=null || grammateiaRepository.findByEmail(newemail)!=null || bibliothikiRepository.findByEmail(newemail)!=null || diathethsRepository.findByEmail(newemail)!=null) {
				return false;
			}
		}
		Shmeio_Dianomhs shmeio_Dianomhs=shmeio_DianomhsRepository.findByEmail(email);
		shmeio_Dianomhs.setEmail(newemail);
		shmeio_Dianomhs.setPassword(password);
		shmeio_Dianomhs.setPhone(phone);
		shmeio_Dianomhs.setName(name);
		shmeio_Dianomhs.setAddress(address);
		shmeio_Dianomhs.setSenior(senior);
		shmeio_Dianomhs.setTime_open(time_open);
		shmeio_DianomhsRepository.save(shmeio_Dianomhs);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/getdepartment_types") // Map ONLY GET Requests
	public @ResponseBody Iterable<Department> getdepartment_types (@RequestHeader("Authorization") String encoded) throws UnsupportedEncodingException {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		String university_name=java.net.URLDecoder.decode(stk.nextToken(), "UTF-8");
		University university=universityRepository.findByName(university_name);
		return departmentRepository.findAllByUniversity(university);
	}

	@RequestMapping(method=RequestMethod.GET, path="/getseasonbooks")
	public @ResponseBody Iterable<Lesson> getseasonbooks(@RequestHeader("Authorization") String encoded) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		Foithths foithths=foiththsRepository.findByEmail(email);
		if(!foithths.getPassword().equals(password))
			return null;
		List<Lesson> returnlessons=new ArrayList<Lesson>();
		int flag;
		for(Lesson lesson: foithths.getDepartment().getLessons()) {
			flag=1;
			for(Lesson lesson2: foithths.getLessons_taken()) {
				if(!lesson.getName().equals(lesson2.getName())){
					flag=0;
					break;
				}
			}
			if(flag==1)
				returnlessons.add(lesson);
		}
		return returnlessons;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/gethistory")
	public @ResponseBody Iterable<Book> gethistorybooks(@RequestHeader("Authorization") String encoded) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		Foithths foithths=foiththsRepository.findByEmail(email);
		if(!foithths.getPassword().equals(password))
			return null;
		List<Book> returnbooks=new ArrayList<Book>();
		returnbooks=foithths.getBooks_declared();
		return returnbooks;
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/searchbooks")
	public @ResponseBody Iterable<Book> searchbooks(@RequestBody String credentials) {
		List<Book> returnbooks=new ArrayList<Book>();
		StringTokenizer stk = new StringTokenizer(credentials,":");
		String query=stk.nextToken();
		Book book=bookRepository.findByTitle(query);
		if(book!=null)
		{
			returnbooks.add(book);
			return returnbooks;
		}
		book=bookRepository.findByIsbn(query);
		if(book!=null)
		{
			returnbooks.add(book);
			return returnbooks;
		}
		return bookRepository.findByWriters(query);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/insertbooks")
	public @ResponseBody boolean insertbooks(@RequestHeader("Authorization") String encoded,@RequestBody String credentials) throws IOException {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		Shmeio_Dianomhs shmeio_Dianomhs=shmeio_DianomhsRepository.findByEmail(email);
		if(!shmeio_Dianomhs.getPassword().equals(password))
			return false;
		Book book=new Book();
		stk = new StringTokenizer(credentials,":");
		String Isbn;
		while(!(Isbn=stk.nextToken()).equals("end")) {
			book=bookRepository.findByIsbn(Isbn);
			shmeio_Dianomhs.addBook(book);
			shmeio_DianomhsRepository.save(shmeio_Dianomhs);
			book.addShmeio_Dianomhs(shmeio_Dianomhs);
			bookRepository.save(book);
		}
		return true;
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/delivery")
	public @ResponseBody Iterable<Book> delivery(@RequestHeader("Authorization") String encoded,@RequestBody String credentials) throws IOException {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		Shmeio_Dianomhs shmeio_Dianomhs=shmeio_DianomhsRepository.findByEmail(email);
		if(!shmeio_Dianomhs.getPassword().equals(password))
			return null;
		stk = new StringTokenizer(credentials,":");
		String pin=stk.nextToken();
		Foithths foithths=foiththsRepository.findByPin(pin);
		List<Book> books_declared=foithths.getBooks_declared();
//		List<Book> returnBooks=new ArrayList<Book>();
//		for(Book book: books_declared) {
//			System.out.println(book);
//			int flag=1;
//			for(Shmeio_Dianomhs shmeiodianomhs:book.getShmeia_Dianomhs()) {
//				if(shmeiodianomhs.getEmail().equals(shmeio_Dianomhs.getEmail())){
//					flag=0;
//					break;
//				}
//			}
//			if(flag==0) {
//				foithths.addBook(book);
//				foithths.removeBook_declared(book);
//				returnBooks.add(book);
//			}
//		}
//		foiththsRepository.save(foithths);
		return books_declared;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/getallbooks")
	public @ResponseBody Iterable<Book> getallbooks(@RequestHeader("Authorization") String encoded) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		Shmeio_Dianomhs shmeio_Dianomhs=shmeio_DianomhsRepository.findByEmail(email);
		if(!shmeio_Dianomhs.getPassword().equals(password))
			return null;
		return shmeio_Dianomhs.getBooks();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/getavailablebookstoexhange")
	public @ResponseBody Iterable<Book> getavailablebookstoexhange(@RequestHeader("Authorization") String encoded) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		Foithths foithths=foiththsRepository.findByEmail(email);
		if(!foithths.getPassword().equals(password))
			return null;
		List<Book> returnbooks=new ArrayList<Book>();
		for(Book book1: foithths.getBooks_taken()) {
			int flag=1;
			for(Book book2 :foithths.getBooks_exhanged()) {
				if(book1.getIsbn().equals(book2.getIsbn())){
					flag=0;
					break;
				}
			}
			if(flag==1)
				returnbooks.add(book1);
		}
		return returnbooks;
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/exhangebooks")
	public @ResponseBody boolean exhangebooks(@RequestHeader("Authorization") String encoded,@RequestBody String credentials) throws IOException {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		Foithths foithths=foiththsRepository.findByEmail(email);
		if(!foithths.getPassword().equals(password))
			return false;
		stk = new StringTokenizer(credentials,":");
		String Isbn;
		Book book=new Book();
		while(!(Isbn=stk.nextToken()).equals("end")) {
			book=bookRepository.findByIsbn(Isbn);
			foithths.addBook_exhange(book);
			foiththsRepository.save(foithths);
		}
		return true;
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/getexhangersforbook")
	public @ResponseBody Iterable<Foithths> getexhangersforbook(@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		Foithths foithths=foiththsRepository.findByEmail(email);
		if(!foithths.getPassword().equals(password))
			return null;
		stk = new StringTokenizer(credentials,":");
		String Isbn=stk.nextToken();
		List<Foithths> foithtes=foiththsRepository.findAll();
		List<Foithths> returnfoithtes=new ArrayList<Foithths>();
		for(Foithths tempfoithths: foithtes) {
			int flag=1;
			for(Book book:tempfoithths.getBooks_exhanged()) {
				if(book.getIsbn().equals(Isbn)){
					flag=0;
					break;
				}
			}
			if(flag==0)
				returnfoithtes.add(tempfoithths);
		}
		return returnfoithtes;
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/declareBooks")
	public @ResponseBody void declareBooks(@RequestHeader("Authorization") String encoded,@RequestBody String books) throws IOException {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		Foithths foithths=foiththsRepository.findByEmail(email);
		if(!foithths.getPassword().equals(password))
			return ;
		stk = new StringTokenizer(books,":");
		String token;
		while(stk.hasMoreTokens()){
			token = stk.nextToken();
			Book book = bookRepository.findByTitle(token);
			foithths.addBook_declared(book);
		}
		Random r = new Random();
		int lowerBound = 100000;
		int upperBound = 1000000;
		int result = r.nextInt(upperBound-lowerBound) + lowerBound;
		foithths.setPin(Integer.toString(result));
		foiththsRepository.save(foithths);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/getDeclaredBooks")
	public @ResponseBody Iterable<Book> getDeclaredBooks(@RequestHeader("Authorization") String encoded) throws IOException {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		Foithths foithths=foiththsRepository.findByEmail(email);
		if(!foithths.getPassword().equals(password))
			return null;
		return foithths.getBooks_declared();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/getDeclarationId")
	public @ResponseBody int getDeclarationId(@RequestHeader("Authorization") String encoded) throws IOException {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		Foithths foithths=foiththsRepository.findByEmail(email);
		if(!foithths.getPassword().equals(password))
			return -1;
		return foithths.getAM();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/getDepartments")
	public @ResponseBody Iterable<Department> getDepartments() throws IOException {
		return departmentRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/getDistPoints")
	public @ResponseBody Iterable<Shmeio_Dianomhs> getDistPoints() throws IOException {
		return shmeio_DianomhsRepository.findAll();
	}
}
