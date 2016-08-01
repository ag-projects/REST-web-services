package com.agharibi.repository;

import java.util.ArrayList;
import java.util.List;

import com.agharibi.model.Activity;
import com.agharibi.model.User;

public class ActivityRepositoryStub implements ActivityRepository {
	
	
	
	public List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList();
		
		Activity activity1 = new Activity();		
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		activities.add(activity1);
		
		Activity activity2 = new Activity();
		activity2.setDescription("Cycling");
		activity2.setDuration(120);
		activities.add(activity2);
		
		return activities;
	}

	@Override
	public Activity findActivity(String activityId) {
		
		if(activityId.equals("7777")) {
			return null;
		}
		
		
		Activity activity1 = new Activity();	
		activity1.setId("1234");
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		
		User user = new User();
		user.setId("321");
		user.setName("Alexis");
		activity1.setUser(user);
		
		return activity1;
	}

	@Override
	public void create(Activity activity) {
		// Insert into DB
		
	}

	@Override
	public Activity update(Activity activity) {
		//  Search the DB for an activity we the given id
		// Select * from activity where id = ?
		// if resultSet.size() == 0 , insert in to table, else update the table.
		return activity;
		
	}

	@Override
	public void delete(String activityId) {
		// Delete from activity where activityId = ?
		
	}

	@Override
	public List<Activity> findByDescription(List<String> descriptions) {
		// Select * from activities where description in (?,?,?)
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity = new Activity();
		activity.setId("2345");
		
		activity.setDescription("Swimming");
		activity.setDuration(96);
		activities.add(activity);
		
		return activities;
	}
	
	
	

}
