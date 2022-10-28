package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.DAO.UserRepoImpl;
import com.example.demo.entity.Users;

@RestController
public class LoginController {
	
	private int token;

	@Autowired
	UserRepoImpl userRepoImpl;
	
	@GetMapping("/")
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("StartPage");
		return mv;
	}

	@GetMapping(path="login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("Login");
		
		mv.addObject("model", new Users());
		token=-1;
		
		return mv;
		
	}
	
	@PostMapping(path="login")
	public ModelAndView submit(@ModelAttribute("model") Users user ) {
		boolean existsOrNot = userRepoImpl.save(user);
		
		
	if(existsOrNot) {
		token=(int) (Math.random()*10)+1;
		System.out.println("Successful");
		
		ModelAndView mv = new ModelAndView("redirect:/home/");
		return mv;
		
	}else {
		ModelAndView mv = new ModelAndView("redirect:/login?wrongcredentials");

		return mv;
		
	}

	}
	
	@GetMapping("home")
	public ModelAndView homePage() {
		
		
		ModelAndView mv = new ModelAndView();
		if(token>=0) {
			
            mv.setViewName("home") ;          

			return mv;
			
		}
		else {
			
			mv.setViewName("NotAuthorized") ;         

			return mv;
		}
	}
	
	@GetMapping("logout")
	public ModelAndView Logout() {
		ModelAndView mv = new ModelAndView("redirect:/login?loggedout");
		token=-1;
		return mv;
	}
	
}
