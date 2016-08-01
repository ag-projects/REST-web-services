package com.agharibi.client;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Test;

import com.agharibi.ActivitySearchClient;
import com.agharibi.model.Activity;

public class ActivityClientTest {
	
	
	@Test
	public void testSearch() {
		ActivitySearchClient client = new ActivitySearchClient();
		
		String param  = "description";
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("Swimming");
		searchValues.add("Running");
		
		List<Activity> activities = client.search(param, searchValues);
		
		System.out.println(activities);
		assertNotNull(activities);
		
		
	}
	
	@Test
	public void testDelete() {
		ActivityClient client = new ActivityClient();
		client.delete("1244");
	}
	
	@Test
	public void testPut() {
		Activity activity = new Activity();
		activity.setId("3465");
		activity.setDescription("Yoda");
		activity.setDuration(93);
		
		ActivityClient client = new ActivityClient();
		activity = client.update(activity);
		
		assertNotNull(activity);
	
	}
	
	@Test
	public void testCreate() {
		ActivityClient client = new ActivityClient();
		
		Activity activity = new Activity();
		activity.setDescription("Swimming");
		activity.setDuration(92);
		
		activity = client.create(activity);
		assertNotNull(activity);
			
	}

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.get("1244");
		
		System.out.println(activity);
		assertNotNull(activity);
	}
	
	@Test
	public void testGetList() {
		ActivityClient client = new ActivityClient();
		List<Activity> activities = client.get();
		System.out.println(activities);
		assertNotNull(activities);
	}
	
	@Test(expected= RuntimeException.class)
	public void testGetWithBadRequest() {
		ActivityClient client = new ActivityClient();
		client.get("13"); // client id's cannot be less than 3 digits.
	}
	
	@Test(expected= RuntimeException.class)
	public void testGetWithNotFound() {
		ActivityClient client = new ActivityClient();
		client.get("7777");
	}
	
}
