package com.example.customcontrollerarguments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository; 
	
	@GetMapping("list")
	public List<Author> getAuthor(){
		return authorRepository.findAll();
	}
	
	@PostMapping(path = "create")
	public Author createLigand(@RequestBody Author author){
		return authorRepository.save(author);
	}
	
	@PostMapping("/upload")
	  public ResponseEntity<String> uploadFile(@XMLCONVERTOR Author author) {
	    String message = "";
	    try {
	    	
	      System.out.println("This is a test" + author.getAuthorName());
	      authorRepository.save(author);

	      message = "Uploaded the file and created author successfully: id " + author.getAuthorId()+ " authorName " + author.getAuthorName();
	      return ResponseEntity.status(HttpStatus.OK).body(message);
	    } catch (Exception e) {
	      message = "Could not upload the file: " + author.getAuthorName() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	    }
	  }

}