package org.seckill.dao;

import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
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
public class SuccessKilledDaoTest {


	@Autowired
	private SuccessKilledDao successKilledDao;

	@Test
	public void testInsertSuccessKilled() throws Exception {
		int count =	successKilledDao.insertSuccessKilled(1L, 15589517517L);
		System.out.println(count);
	}

	@Test
	public void testQueryByIdWithSeckill() throws Exception {
		SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1L, 15589517517L);
		System.out.println(successKilled.getSeckill());
	}
}
