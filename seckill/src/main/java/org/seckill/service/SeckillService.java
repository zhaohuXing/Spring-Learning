package org.seckill.service;

import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import java.util.List;

/**
 * 	在"使用者"的角度去设计接口
 * 	关注点： 方法定义粒度，参数，返回类型，异常
 */
public interface SeckillService {
	
	/**
	 * 查询所有秒杀记录
	 */
	List<Seckill> getSeckillList();

	/**
	 * 通过seckillId查询一条秒杀记录
	 * @param seckillId
	 * @return 
	 */
	Seckill getById(long seckillId);

	/**
	 * 秒杀开启：输出接口地址
	 * 秒杀未开启：系统时间和秒杀时间
	 */
	Exposer exportSeckillUrl(long seckillId);

	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
		throws RepeatKillException, SeckillCloseException, SeckillException;
}
