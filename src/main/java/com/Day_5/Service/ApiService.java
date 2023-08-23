package com.Day_5.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Day_5.Models.Book;
import com.Day_5.Repository.ApiRepository;

@Service
public class ApiService {
	
	@Autowired
	ApiRepository ar;
	
	public List<Book> saveinfo(List<Book> b)
	{
		return (List<Book>)ar.saveAll(b);
	}
	
	public List<Book> showinfo()
	{
		return ar.findAll();
	}
	
	public Book getBookById(int id) {
		Optional<Book> BookOptional = ar.findById(id);
        return BookOptional.orElse(null);
	}
	
	public String changeinfobyid(int id,Book b)
	{
		if(ar.existsById(id))
		{
			ar.saveAndFlush(b);
			return "Updated";
		}
		else
		{
			return "Enter Valid Id";
		}
	}
	
	public String deleteid(int id)
	{
		if(ar.existsById(id))
		{
			ar.deleteById(id);
			return "Deleted";
		}
		else
		{
			return "Enter Valid Id";
		}
	}

}
