package org.seckill.dao;

import org.seckill.entity.Seckill;
import java.util.Date;
import java.util.List;
public interface SeckillDao {
	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return 
	 */
	int reduceNumber(long seckillId, Date killTime);

	/**
	 * 查询秒杀活动
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);

	/**
	 * 查询所有的秒杀活动
	 * @param offet
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(int offet, int limit);

}
