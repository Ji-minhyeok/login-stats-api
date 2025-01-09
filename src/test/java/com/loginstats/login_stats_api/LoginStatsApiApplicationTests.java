package com.loginstats.login_stats_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "environment.serviceKey=test")
class LoginStatsApiApplicationTests {
	@Value("${environment.serviceKey}")
	private String apiServiceKey;

	@Test
	void contextLoads() {
	}

}
