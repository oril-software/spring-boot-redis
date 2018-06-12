package com.service.impl;


import com.controllers.RedisController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Book;
import com.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static com.constants.Constants.*;

@Service
public class BookServiceImpl implements BookService {

	private final Logger logger = LoggerFactory.getLogger(RedisController.class);
	private RedisTemplate<String, String> redisTemplate;
	private ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	BookServiceImpl (RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public Book addToRedis(String key, Book book) throws JsonProcessingException {
		logger.info(ADD_REQUEST_LOG_MSG + book);
		redisTemplate.opsForValue().set(book.getKey(), objectMapper.writeValueAsString(book));
		return book;
	}

	@Override
	public Book getFromRedisByKey(String key) throws IOException {
		logger.info(GET_ONE_REQUEST_LOG_MSG + key);
		return objectMapper.readValue(redisTemplate.opsForValue().get(key), Book.class);
	}

	@Override
	public Set<String> listAll() {
		logger.info(LIST_ALL_REQUEST_LOG_MSG);
		return redisTemplate.keys(ALL_KEYS);
	}

	@Override
	public String deleteFromRedisByKey(String key) {
		logger.info(DELETE_ONE_REQUEST_LOG_MSG + key);
		redisTemplate.delete(key);
		return KEY_DELETED + key;
	}
}
