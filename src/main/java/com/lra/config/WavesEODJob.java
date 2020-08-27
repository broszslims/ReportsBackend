/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import com.lra.utilities.ReportService;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author aokoh
 */
@Service
@DisallowConcurrentExecution
public class WavesEODJob extends QuartzJobBean {
    @Autowired
    ReportService reportService;

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException
    {
        System.out.println("Executing Reporting Job");
        try {
        	reportService.export();
        } catch(Exception ex) {
            throw new JobExecutionException(ex);
        }
        System.out.println("Finished Executing Reporting Job");
    } 
}
