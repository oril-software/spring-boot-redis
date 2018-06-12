package com.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import static com.constants.Constants.LOCALHOST;
import static com.constants.Constants.REDIS_PORT;

@Configuration
public class RedisConfiguration {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory () {
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.setUsePool(true);
		connectionFactory.setHostName(LOCALHOST);
		connectionFactory.setPort(REDIS_PORT);
		return connectionFactory;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate () {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		return redisTemplate;
	}



}
