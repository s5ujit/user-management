package com.appliedsni.services;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.appliedsni.dto.ReportDto;
import com.appliedsni.utility.ServerUrl;

@RestController
@RequestMapping(ServerUrl.ROOT_URL)
public class ReportController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);
	@SuppressWarnings("unchecked")
	@GetMapping(value=ServerUrl.REPORTS)
	List<ReportDto> getReport(){
		RestTemplate restTemplate = new RestTemplate();
		List<ReportDto> quote=new ArrayList<>();
		try{
			quote = (List<ReportDto>) restTemplate.getForObject("http://85.25.195.78:8080/stocktrade-server/secure/service/reports", List.class);
       
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return quote;
	}
}
