package com.workshop.rest;

import com.workshop.rest.server.RestClientApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestClientApplication.class)
@WebAppConfiguration
public class RestClientApplicationTests {

	@Test
	public void contextLoads() {
	}

}
