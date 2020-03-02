package com.lwq.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.lwq.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:redis.xml")
public class TestWeek{
	@Autowired
	RedisTemplate  redisTemplate;
	
	@Test
	public void testJDK() {
		// 生成10万个对象 添加到list集合
		ArrayList<User> list = new ArrayList<User>();
		for (int i = 0; i <100000; i++) {
			User user = new User(i,"李四","男","1234567","3175388773.qq.com","2001-09-02");
			list.add(user);
		}
		//开始时间1
		long start = System.currentTimeMillis();
		//保存redis10万个对象
		redisTemplate.opsForList().leftPushAll("users",list.toArray());
		// 结束时间
		long end = System.currentTimeMillis();
		System.out.println("序列化方式:JDK的方式");
		System.out.println("保存是数量是10万个对象");
		System.out.println("所耗时间是:"+(end-start));
	}
	
	
	
	
}
