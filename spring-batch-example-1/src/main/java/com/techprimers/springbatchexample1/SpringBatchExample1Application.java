package com.techprimers.springbatchexample1;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;
@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchExample1Application {
	
	@Autowired
	JobLauncher joblauncher;
	
	@Autowired
	Job job;

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchExample1Application.class, args);
		
	}
	
	@Scheduled(cron="*/1 * * * * *")
	public void perform() throws Exception
	{
		JobParameters params = new JobParametersBuilder().addString("JobId", String.valueOf(System.currentTimeMillis())).toJobParameters();
		joblauncher.run(job,params);
		
	}
	
}
