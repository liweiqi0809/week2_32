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
		// ����10������� ��ӵ�list����
		ArrayList<User> list = new ArrayList<User>();
		for (int i = 0; i <100000; i++) {
			User user = new User(i,"����","��","1234567","3175388773.qq.com","2001-09-02");
			list.add(user);
		}
		//��ʼʱ��1
		long start = System.currentTimeMillis();
		//����redis10�������
		redisTemplate.opsForList().leftPushAll("users",list.toArray());
		// ����ʱ��
		long end = System.currentTimeMillis();
		System.out.println("���л���ʽ:JDK�ķ�ʽ");
		System.out.println("������������10�������");
		System.out.println("����ʱ����:"+(end-start));
	}
	
	
	
	
}
