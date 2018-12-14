package main;

import java.util.Base64;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import main.UserRepository;

@CrossOrigin
@Controller
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET, path="/login")
	public @ResponseBody boolean loginUser(@RequestHeader("Authorization") String encoded) {
		StringTokenizer stk = new StringTokenizer(encoded," ");
		stk.nextToken();
		encoded = stk.nextToken();
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decoded = new String(decodedBytes);
		stk = new StringTokenizer(decoded,":");
		String email=stk.nextToken();
		String password=stk.nextToken();
		User user=new User();
		user = userRepository.findByEmail(email);
		if(user!=null && user.getPassword().equals(password))
			return true;
		else
			return false;
	}
}