package com.Day_5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Day_5.Models.Book;

@Repository
public interface ApiRepository extends JpaRepository<Book, Integer>{

}
