package org.seckill.dao;

import org.seckill.entity.SuccessKilled;
public interface SuccessKilledDao {

	/**
	 * 插入购买明细，可过滤重复
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int insertSuccessKilled(long seckillId, long userPhone);

	/**
	 * 根据Id查询SuccessKilled并携带秒杀商品的对象
	 * @param sekcillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(long seckillId);

}
