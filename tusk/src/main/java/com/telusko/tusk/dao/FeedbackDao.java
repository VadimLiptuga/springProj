package com.telusko.tusk.dao;

import org.springframework.stereotype.Component;

import com.telusko.tusk.entity.Feedback;

@Component
public class FeedbackDao {
	
	public void addFeedback(Feedback fb) {
		System.out.println("in addFeedback" + fb);
	}

}
