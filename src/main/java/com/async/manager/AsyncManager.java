package com.async.manager;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.async.service.AsyncService;
import com.asynch.model.ViolationDetails;

public class AsyncManager {
	
	@Autowired
	private AsyncService asyncService;
	
	public void doAsyncTask(){
		try {
			Map<Long, ViolationDetails> violation = asyncService.getViolation();
			if(!org.springframework.util.CollectionUtils.isEmpty(violation)){
				violation.entrySet().forEach( violationEntry -> {System.out.println(violationEntry.getKey() +"" +violationEntry.getValue());});
			}
			System.out.println("Non Async Exit ");
		} catch (Exception e) {
		}

	}
}
