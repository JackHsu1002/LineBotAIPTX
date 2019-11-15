package com.sabretn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sabretn.ai.service.PTXService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PTXServiceTest {
	@Autowired
	private PTXService ptxService;
	
	@Test
	public void test() {
//		ptxService.getFIDSDeparture("TPE");
//		ptxService.getFIDSArrivals("TNN");
		ptxService.getAirportWeather("KHH");
	}
}
