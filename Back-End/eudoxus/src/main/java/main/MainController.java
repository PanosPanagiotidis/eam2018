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

@CrossOrigin
@Controller    // This means that this class is a Controller
public class MainController {
	@Autowired
	private EkdothsRepository ekdothsRepository;
	@Autowired
	private EkdothsRepository foiththsRepository;
	@Autowired
	private EkdothsRepository shmeio_DianomhsRepository;
	@Autowired
	private EkdothsRepository grammateiaRepository;
	@Autowired
	private EkdothsRepository diathethsRepositoryRepository;
	@Autowired
	private EkdothsRepository bibliothikiRepository;
	
	@RequestMapping(method=RequestMethod.PUT,path="/signup_ekdoths") // Map ONLY GET Requests
	public @ResponseBody boolean signup_ekdoths (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
		Ekdoths newekdoths=new Ekdoths();
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
		String address=stk.nextToken();
		String phone=stk.nextToken();
		String time_open=stk.nextToken();
		String senior=stk.nextToken();
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
		Ekdoths newekdoths=new Ekdoths();
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
		String address=stk.nextToken();
		String phone=stk.nextToken();
		String time_open=stk.nextToken();
		String senior=stk.nextToken();
		return true;
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="/signup_shmeio_dianomhs") // Map ONLY GET Requests
	public @ResponseBody boolean signup_shmeio_dianomhs (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
		Ekdoths newekdoths=new Ekdoths();
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
		String address=stk.nextToken();
		String phone=stk.nextToken();
		String time_open=stk.nextToken();
		String senior=stk.nextToken();
		return true;
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="/signup_grammateia") // Map ONLY GET Requests
	public @ResponseBody boolean signup_grammateia (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
		Ekdoths newekdoths=new Ekdoths();
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
		String address=stk.nextToken();
		String phone=stk.nextToken();
		String time_open=stk.nextToken();
		String senior=stk.nextToken();
		return true;
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="/signup_diatheths") // Map ONLY GET Requests
	public @ResponseBody boolean signup_diatheths (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
		Ekdoths newekdoths=new Ekdoths();
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
		String address=stk.nextToken();
		String phone=stk.nextToken();
		String time_open=stk.nextToken();
		String senior=stk.nextToken();
		return true;
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="/signup_bibliothiki") // Map ONLY GET Requests
	public @ResponseBody boolean signup_bibliothiki (@RequestHeader("Authorization") String encoded,@RequestBody String credentials) {
		Ekdoths newekdoths=new Ekdoths();
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
		String address=stk.nextToken();
		String phone=stk.nextToken();
		String time_open=stk.nextToken();
		String senior=stk.nextToken();
		return true;
	}
}
