package group13.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import group13.repositories.TreatsRepository;

@Controller
@CrossOrigin
public class TreatsController {
	
	@Autowired
	private TreatsRepository repository;
	
	
	
	
	

}
