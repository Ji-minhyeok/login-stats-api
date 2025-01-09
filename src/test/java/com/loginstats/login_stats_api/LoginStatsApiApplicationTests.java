package com.loginstats.login_stats_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "API_SERVICE_KEY=1234")
class LoginStatsApiApplicationTests {
	@Value("${API_SERVICE_KEY}")
	private String apiServiceKey;

	@Test
	void contextLoads() {
	}

}
