package com.lra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lra.restmodels.LraTransactionInfo;
import com.lra.restmodels.Response;
import com.lra.utilities.ReportService;

@RestController
@RequestMapping("/api")
public class UtilityController {
	
	@Autowired
	ReportService reportservice;
	
	 @RequestMapping(value = "/generateReports", method = RequestMethod.GET)
	    public void generateReports() {
		 LraTransactionInfo lraTranInfo = new LraTransactionInfo();
	        reportservice.export();
	      
	    }

}
