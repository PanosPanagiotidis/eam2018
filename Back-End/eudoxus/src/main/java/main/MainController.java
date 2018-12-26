package main;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
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
	

	@RequestMapping(method=RequestMethod.PUT,path="/signup_ekdoths") // Map ONLY GET Requests
	public @ResponseBody boolean signup_ekdoths (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
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
		String address=stk.nextToken();
		String phone=stk.nextToken();
		String time_open=stk.nextToken();
		String senior=stk.nextToken();
		Ekdoths newekdoths=new Ekdoths();
		newekdoths.setEmail(email);
		newekdoths.setPassword(password);
		newekdoths.setName(name);
		newekdoths.setAddress(address);
		newekdoths.setPhone(phone);
		newekdoths.setTime_open(time_open);
		newekdoths.setSenior(senior);
		ekdothsRepository.save(newekdoths);
		return true;
	}
	
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
		foiththsRepository.save(newfoithths);
		university.addFoithths(newfoithths);
		department.addFoithths(newfoithths);
		departmentRepository.save(department);
		universityRepository.save(university);
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
	
	@RequestMapping(method=RequestMethod.PUT,path="/signup_grammateia") // Map ONLY GET Requests
	public @ResponseBody boolean signup_grammateia (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
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
		String phone=stk.nextToken();
		String time_open=stk.nextToken();
		String senior=stk.nextToken();
		University university=universityRepository.findByName(university_name);
		Department newdepartment=new Department();
		Grammateia newgrammateia=new Grammateia();
		newgrammateia.setEmail(email);
		newgrammateia.setPassword(password);
		newgrammateia.setPhone(phone);
		newgrammateia.setSenior(senior);
		newgrammateia.setTime_open(time_open);
		grammateiaRepository.save(newgrammateia);
		newdepartment.setName(department_name);
		newdepartment.setGrammateia(newgrammateia);
		departmentRepository.save(newdepartment);
		university.addDepartments(newdepartment);
		universityRepository.save(university);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="/signup_diatheths") // Map ONLY GET Requests
	public @ResponseBody boolean signup_diatheths (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
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
		Diatheths newdiatheths=new Diatheths();
		newdiatheths.setEmail(email);
		newdiatheths.setPassword(password);
		diathethsRepository.save(newdiatheths);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="/signup_bibliothiki") // Map ONLY GET Requests
	public @ResponseBody boolean signup_bibliothiki (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
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
		String address=stk.nextToken();
		String phone=stk.nextToken();
		String time_open=stk.nextToken();
		String senior=stk.nextToken();
		Bibliothiki newbibliothiki=new Bibliothiki();
		newbibliothiki.setEmail(email);
		newbibliothiki.setPassword(password);
		newbibliothiki.setName(name);
		newbibliothiki.setAddress(address);
		newbibliothiki.setPhone(phone);
		newbibliothiki.setTime_open(time_open);
		newbibliothiki.setSenior(senior);
		bibliothikiRepository.save(newbibliothiki);
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
}
