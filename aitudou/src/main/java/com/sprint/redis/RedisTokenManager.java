package com.sprint.redis;

import com.alibaba.fastjson.JSONObject;
import com.sprint.dao.model.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
@Component
@Log4j
public class RedisTokenManager {

	@Value("${redis.prefix.signUp}")
	private String signUpPrefix; 

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public String getTokenOfSignUp(User user) {
		String token = UUID.randomUUID().toString();
		String value = JSONObject.toJSONString(user);
		// 设置Key-Value存入redis
		stringRedisTemplate.opsForValue().set(signUpPrefix + token, value);
		//设置Key的生存周期
		stringRedisTemplate.expire(signUpPrefix + token, 12, TimeUnit.HOURS);
		return token;
	} 

	public User getUserOfSignUp(String token) {
		//通过key获取redis中的value
		String value = stringRedisTemplate.opsForValue().get(signUpPrefix + token);
		if (value == null) {
			log.info("用户注册, Token已失效：" + token);
			return null;
		}
		return JSONObject.parseObject(value, User.class);
	}
}
