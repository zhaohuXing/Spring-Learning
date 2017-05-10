package org.seckill.dao;

import org.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
/**
 * 	配合spring和test整合，junit启动时加载SpringIOC容器
 * 	spring-test, junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class SeckillDaoTest {


	@Autowired
	private SeckillDao seckillDao;
	@Test
	public void testQueryById() throws Exception {
		long id = 1;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);		
	}

	@Test
	public void testQueryAll() throws Exception {
		List<Seckill> seckills = seckillDao.queryAll(0, 100);
		for (Seckill seckill : seckills) {
			System.out.println(seckill);	
		}	
	} 

	@Test
	public void testReduceNumber() throws Exception {
		Date killTime = new Date();
		int updateCount = seckillDao.reduceNumber(1L, killTime);
		System.out.println(updateCount);
	}
}
