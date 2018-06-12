package com.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.models.Book;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Set;


@RestController
@RequestMapping(value = "/redis")
public class RedisController {

	private final BookService bookService;

	@Autowired
	RedisController (BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping(value = "/add")
	public Book add(@RequestBody Book book) throws JsonProcessingException {
		return bookService.addToRedis(book.getKey(), book);
	}

	@GetMapping(value = "/get/{key}")
	public Book get(@PathVariable String key) throws IOException {
		return bookService.getFromRedisByKey(key);
	}

	@GetMapping(value = "/all")
	public Set<String> listAll() throws IOException {
		return bookService.listAll();
	}

	@DeleteMapping(value = "/delete/{key}")
	public String delete(@PathVariable String key) throws IOException {
		return bookService.deleteFromRedisByKey(key);
	}

}
