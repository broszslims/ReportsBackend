/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lra.config;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import de.chandre.quartz.spring.AutowiringSpringBeanJobFactory;

/**
 *
 * @author aokoh
 */
@Configuration
public class WavesEODJobConfig {
    @Autowired
    Environment env;

    @Bean
    public JobDetailFactoryBean eodJobDetail() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(WavesEODJob.class);
        jobDetailFactory.setDescription("EOD Job service...");
        jobDetailFactory.setDurability(true);
        jobDetailFactory.setName("WavesEODSchedulerJob");
        return jobDetailFactory;
    }

    @Bean
    public CronTriggerFactoryBean eodJobTrigger(JobDetail eodJobDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(eodJobDetail);
        trigger.setCronExpression(env.getProperty("REPORTS_INTERVAL"));
        trigger.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_FIRE_ONCE_NOW);
        return trigger;
    }

    @Bean
    public SchedulerFactoryBean eodJobScheduler(Trigger eodJobTrigger, JobDetail eodJobDetail) {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();

        schedulerFactory.setJobFactory(eodJobFactory());
        schedulerFactory.setJobDetails(eodJobDetail);
        schedulerFactory.setTriggers(eodJobTrigger);

        return schedulerFactory;
    }

    @Bean
    public SpringBeanJobFactory eodJobFactory() {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        return jobFactory;
    }

    @Autowired
    BeanFactory beanFactory;
}
