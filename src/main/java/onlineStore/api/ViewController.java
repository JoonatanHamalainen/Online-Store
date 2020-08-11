package onlineStore.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	@RequestMapping("/login")
	public String login() {
	    return "login";
	}
        
        	@RequestMapping("/welcome")
	public String welcome() {
	    return "welcome";
	}
}
