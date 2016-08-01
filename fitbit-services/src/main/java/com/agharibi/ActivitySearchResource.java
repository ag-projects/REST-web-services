package com.agharibi;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.agharibi.model.Activity;
import com.agharibi.repository.ActivityRepository;
import com.agharibi.repository.ActivityRepositoryStub;

@Path("search/activities")
public class ActivitySearchResource {
	
	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response searchForActivities(@QueryParam(value="description") List<String> descriptions) {
		
		System.out.println(descriptions);
		
		List<Activity> activities = activityRepository.findByDescription(descriptions);
		
		if(activities == null || activities.size() <=0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {}).build();
	}
	

}
