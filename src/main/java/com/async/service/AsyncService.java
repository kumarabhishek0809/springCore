package com.async.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.async.executor.AsyncExecutor;
import com.asynch.model.ViolationDetails;

@Service
public class AsyncService {
	
	@Autowired
	private AsyncExecutor asyncExecutor;

	@Async
	public Map<Long,ViolationDetails> getViolation() {
		// TODO Auto-generated method stub
		List<Long> list = Arrays.asList(100l,200l,300l,400l,500l,600l,700l);
		Executor executor = asyncExecutor.getAsyncExecutor();
		Map<Long,ViolationDetails>  returnMap = new HashMap<>();
		for(Long estCode : list){
			ViolationDetails violationDetails = new ViolationDetails(estCode);
			returnMap.put(estCode, violationDetails);
			executor.execute((Runnable)new ViolationWorker(violationDetails));
		}
		return returnMap;		
	}
}
class ViolationWorker implements Runnable{
	
	private ViolationDetails violationDetails;
	
	public ViolationWorker(ViolationDetails violationDetails){
		this.violationDetails = violationDetails;
	}
	
	@Override
	public void run() {
		violationDetails.setViolation(System.currentTimeMillis());
		System.out.println(violationDetails.getEstablishmentID() + "    " + violationDetails.getViolation());
	}
}

/*
class ViolationWorker implements Callable<ViolationDetails>{
	
	private ViolationDetails violationDetails;
	
	public ViolationWorker(ViolationDetails violationDetails){
		this.violationDetails = violationDetails;
	}
	
	@Override
	public ViolationDetails call() throws Exception {
		Thread.sleep(10001);
		violationDetails.setViolation(System.currentTimeMillis());
		System.out.println(violationDetails.getEstablishmentID() + "    " + violationDetails.getViolation());
		return violationDetails;
	}
	*/
	 
