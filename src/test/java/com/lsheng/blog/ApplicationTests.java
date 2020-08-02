package com.lsheng.blog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsheng.blog.entity.User;
import com.lsheng.blog.mapper.UserMapper;
import com.lsheng.blog.service.UserService;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {

	}

	@Autowired
	private UserService userService;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		IPage<User> page = new Page<>();
		page.setCurrent(1);
		page.setSize(5);
		IPage<User> userList = userService.page(page);
		Assert.assertEquals(5, userList.getRecords().size());
		userList.getRecords().forEach(System.out::println);
	}

	@Test
	public void testInsert() {
		User user = new User();
		user.setUserName("admin");
		user.setPassword("admin");

		userService.save(user);
	}

	@Test
	public void testBulkInsert() {
		List<User> users = Lists.newArrayList();
		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setUserName("admin");
			user.setPassword("admin");
			users.add(user);
		}

		userService.saveBatch(users, 10);
	}

}
