package com.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.models.Book;

import java.io.IOException;
import java.util.Set;

public interface BookService {

	Book addToRedis(String key, Book book) throws JsonProcessingException;
	Book getFromRedisByKey(String key) throws IOException;
	Set<String> listAll();
	String deleteFromRedisByKey(String key);
}
