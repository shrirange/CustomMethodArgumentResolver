package com.example.customcontrollerarguments;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class PublisherController {
	
	@Autowired
	private PublisherRepository publisherRepository; 
	
	@GetMapping("list")
	public List<Publisher> getPublisher(){
		return publisherRepository.findAll();
	}
	
	@PostMapping("create")
	public Publisher createLigand(@RequestBody Publisher publisher){
		return publisherRepository.save(publisher);
	}
	
	

}