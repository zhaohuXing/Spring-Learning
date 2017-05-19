package org.seckill.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.seckill.entity.Seckill;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class RedisDao {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final JedisPool jedisPool;
	
	public RedisDao(String ip, int port) {
		JedisPoolConfig config = new JedisPoolConfig(); 
		jedisPool = new JedisPool(config, ip, port, 60*60, "123456");
	}


	private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);
	public Seckill getSeckill(long seckillId) {
		//redis操作逻辑	
		//
		try {
			//在JedisPool中获取对象
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckill:" + seckillId;		
				//并没有实现内部序列化操作
				//get -> byte[] -> 反序列 -> Object(Seckill)
				//采用自定义的方式序列化
				byte[] bytes = jedis.get(key.getBytes());
				if (bytes != null) {
					Seckill seckill = schema.newMessage();
					ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
					//seckill被反序列化
					return seckill;
				}

			} finally {		
				//关闭jedis
				jedis.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public String putSeckill(Seckill seckill) {
		//set Object(Seckill) -> 序列化 ->byte[] 
		try {
			//在JedisPool中获取对象
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckill:" + seckill.getSeckillId();	
				byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				//设置超时缓存
				int timeout = 60 * 60;
				String result = jedis.setex(key.getBytes(), timeout, bytes);
				return result;
			} finally {
				jedis.close();
			}	
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	} 
}
