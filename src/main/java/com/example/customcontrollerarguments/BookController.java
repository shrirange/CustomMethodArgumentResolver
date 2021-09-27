package com.example.customcontrollerarguments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository; 
	
	@GetMapping("list")
	public List<Book> getBook(){
		return bookRepository.findAll();
	}
	
	@PostMapping("create")
	public Book createLigand(@RequestBody Book book){
		return bookRepository.save(book);
	}
	
	

}
