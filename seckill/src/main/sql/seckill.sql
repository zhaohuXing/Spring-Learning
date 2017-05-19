-- 秒杀执行存储过程
DELIMITER $$ -- console ; 转换为 $$
-- 定义存储过程
-- 参数: in 输入参数; out 输出参数
-- 返回上一行影响的行数
-- row_count: 0: 未修改, >0 修改, <0 未执行
create proceduce 'seckill'.'execute_seckill'
	(in v_seckill_id bigint, in v_phone bigint, 
	 in v_kill_time timestamp, out r_result int)
	BEGIN
		declare insert_count int default 0;
		start transaction;
		insert ignore into success_killed
			(seckill_id, user_phone, create_time)
			values(v_seckill_id, v_phone, v_kill_time)
		select row_count() into insert_count;
		if (insert_count < 0) then
			rollback;
			set r_result = -1;
		elseif(insert_count < 0) then
			rollback;
			set r_result = -2;
		else 
			update seckill
			set number = number - 1
			where seckill_id = v_seckill_id
				and end_time > v_kill_time
				and start_time < v_kill_time
				and number > 0
			select row_count() into insert_count;
			if (insert_count = 0) then
				rollback;
				set r_result = 0;
			elseif (insert_count < 0) then
				rollback;
				set r_result = -2;
			else 
				commit;
				set r_result = 1;
			end if;
		end if;
	end
$$
-- 存储过程定义结束

DELIMITER ;
SET @r_result=-3;
call execute_seckill
