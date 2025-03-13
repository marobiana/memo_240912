package com.memo;

import com.memo.user.bo.UserBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RequiredArgsConstructor
@Slf4j
@SpringBootTest // spring boot
class MemoApplicationTests {

	@Autowired
	UserBO userBO;

	@Test
	void 테스트() {
		String a = "";
		String b = null;

		List<Integer> list = new ArrayList<>(); // []
		List<Integer> list1 = null; // null

		if (ObjectUtils.isEmpty(list)) {

		}

		if (ObjectUtils.isEmpty(a)) {

		}
	}

	@Transactional  // 수행 후 롤백해줌
	//@Test
	void 회원가입() {
		userBO.addUser("testtest111", "password111", "이름테스트111", "이메일1111");
	}

	//@Test
	void contextLoads() {
		log.warn("######## 테스트");
		int a = 10;
		int b = 20;

		assertEquals(30, a + b);
	}

}
