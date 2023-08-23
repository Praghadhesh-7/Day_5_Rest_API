package com.Day_5.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Day_5.Models.Book;
import com.Day_5.Service.ApiService;

@RestController
public class ApiController {

	@Autowired
	ApiService aser;
	
	@PostMapping("addbook")
	public List<Book> add(@RequestBody  List<Book> b)
	{
		return aser.saveinfo(b);
	}
	 
	@GetMapping("book/{id}")
	public ResponseEntity<Book> showDetail(@PathVariable int id) {
	    Book book = aser.getBookById(id);
	    
	    if (book != null) {
	        return new ResponseEntity<>(book, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("show")
	public List<Book> show()
	{
		return aser.showinfo();
	}
	
	@PutMapping("updatebyid")
	public String modifybyid(@RequestParam int id,@RequestBody Book b)
	{
		return aser.changeinfobyid(id,b);	
	}
	
	@DeleteMapping("deletebyid")
	public String deleteMyParamId(@RequestParam int id)
	{
		return (aser.deleteid(id));
	}
}
