package com.techvalley.sdp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.techvalley.sdp.job.DataSyncJob;
import com.techvalley.sdp.job.SDPUnsubscriptionJob;
import com.techvalley.sdp.job.Sdp1880Job;
import com.techvalley.sdp.job.Sdp1881Job;
import com.techvalley.sdp.job.Sdp1882Job;
import com.techvalley.sdp.job.Sdp1883Job;
import com.techvalley.sdp.job.Sdp1884Job;
import com.techvalley.sdp.job.Sdp1885Job;
import com.techvalley.sdp.job.SdpHelpJob;
import com.techvalley.sdp.job.SdpSubscriptionJob;

public class SdpJobListener implements ServletContextListener {

	 Scheduler scheduler = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContext) {
		
		System.out.println("Context Destroyed");
        try 
        {
                scheduler.shutdown();
        } 
        catch (SchedulerException e) 
        {
                e.printStackTrace();
        }
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContext) {
		
		try {
            // Setup the Job class and the Job group
            JobDetail DataSyncJob = JobBuilder.newJob(DataSyncJob.class)
            		.withIdentity("DataSyncCronJob", "Group").build();

            
            JobDetail Sdp1880SenderJob = JobBuilder.newJob(Sdp1880Job.class)
            		.withIdentity("Sdp1880CronJob", "Group").build();
            
            JobDetail Sdp1881SenderJob = JobBuilder.newJob(Sdp1881Job.class)
            		.withIdentity("Sdp1881CronJob", "Group").build();

            JobDetail Sdp1882SenderJob = JobBuilder.newJob(Sdp1882Job.class)
            		.withIdentity("Sdp1882CronJob", "Group").build();

            JobDetail Sdp1883SenderJob = JobBuilder.newJob(Sdp1883Job.class)
            		.withIdentity("Sdp1883CronJob", "Group").build();
            
            JobDetail Sdp1884SenderJob = JobBuilder.newJob(Sdp1884Job.class)
            		.withIdentity("Sdp1884CronJob", "Group").build();

            JobDetail Sdp1885SenderJob = JobBuilder.newJob(Sdp1885Job.class)
            		.withIdentity("Sdp1885CronJob", "Group").build();

            JobDetail SdpSubscriptionSenderJob = JobBuilder.newJob(SdpSubscriptionJob.class)
            		.withIdentity("SdpSubscriptionCronJob", "Group").build();
            
            JobDetail SDPUnsubscriptionSenderJob = JobBuilder.newJob(SDPUnsubscriptionJob.class)
            		.withIdentity("SdpUnsubscriptionCronJob", "Group").build();
            
            JobDetail SDPHelpSenderJob = JobBuilder.newJob(SdpHelpJob.class)
            		.withIdentity("SdpHelpCronJob", "Group").build();
            
            
            
            // Create a Trigger that fires every 5 minutes.
            Trigger DataSyncTrigger = TriggerBuilder.newTrigger()
            .withIdentity("DataSyncTrigger", "Group")
            .withSchedule(CronScheduleBuilder.cronSchedule("0/35 * * * * ?"))
            .build();
            
            
            Trigger Sdp1880JobTrigger = TriggerBuilder.newTrigger()
            		.withIdentity("Sdp1880CronJobTrigger", "Group")
            		.withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
            		.build();
            
            Trigger Sdp1881JobTrigger = TriggerBuilder.newTrigger()
            		.withIdentity("Sdp1881CronJobTrigger", "Group")
            		.withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
            		.build();
            
            Trigger Sdp1882JobTrigger = TriggerBuilder.newTrigger()
            		.withIdentity("Sdp1882CronJobTrigger", "Group")
            		.withSchedule(CronScheduleBuilder.cronSchedule("0/25 * * * * ?"))
            		.build();
            
            Trigger Sdp1883JobTrigger = TriggerBuilder.newTrigger()
            		.withIdentity("Sdp1883CronJobTrigger", "Group")
            		.withSchedule(CronScheduleBuilder.cronSchedule("0/25 * * * * ?"))
            		.build();
            
            Trigger Sdp1884JobTrigger = TriggerBuilder.newTrigger()
            		.withIdentity("Sdp1884CronJobTrigger", "Group")
            		.withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
            		.build();
            
            Trigger Sdp1885JobTrigger = TriggerBuilder.newTrigger()
            		.withIdentity("Sdp1885CronJobTrigger", "Group")
            		.withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
            		.build();
            
            Trigger SdpSubscriptionJobTrigger = TriggerBuilder.newTrigger()
            		.withIdentity("SdpSubscriptionCronJobTrigger", "Group")
            		.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
            		.build();
            
            Trigger SdpUnsubscriptionJobTrigger = TriggerBuilder.newTrigger()
            		.withIdentity("SdpUnsubscriptionCronJobTrigger", "Group")
            		.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
            		.build();
            
            Trigger SdpHelpJobTrigger = TriggerBuilder.newTrigger()
            		.withIdentity("SdpHelpCronJobTrigger", "Group")
            		.withSchedule(CronScheduleBuilder.cronSchedule("0/35 * * * * ?"))
            		.build();

            // Setup the Job and Trigger with Scheduler & schedule jobs
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();           
            scheduler.scheduleJob(Sdp1880SenderJob, Sdp1880JobTrigger);
            scheduler.scheduleJob(Sdp1881SenderJob, Sdp1881JobTrigger);
            scheduler.scheduleJob(Sdp1882SenderJob, Sdp1882JobTrigger);
            scheduler.scheduleJob(Sdp1883SenderJob, Sdp1883JobTrigger);
            scheduler.scheduleJob(Sdp1885SenderJob, Sdp1885JobTrigger);
            scheduler.scheduleJob(SDPHelpSenderJob, SdpHelpJobTrigger);
            
           // scheduler.scheduleJob(Sdp1884SenderJob, Sdp1884JobTrigger); 
           // scheduler.scheduleJob(SdpSubscriptionSenderJob, SdpSubscriptionJobTrigger);
           // scheduler.scheduleJob(SDPUnsubscriptionSenderJob, SdpUnsubscriptionJobTrigger); 
           // scheduler.scheduleJob(DataSyncJob, DataSyncTrigger); 
            
            
            
    }
    catch (SchedulerException e) {
            e.printStackTrace();
    }
		
	}

}
