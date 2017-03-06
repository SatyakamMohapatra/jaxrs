package com.satya.jersey.messages;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.satya.jersey.messages.model.ProfileModel;
import com.satya.jersey.messages.services.ProfileServices;

@Path("/Profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfilesResources {

	ProfileServices profiles = new ProfileServices();

	@GET
	public List<ProfileModel> getXMLMesages() {
		return profiles.getAllProfiles();
	}

	@GET
	@Path("/{ProfileName}")
	public ProfileModel getProfileByProfileName(@PathParam("ProfileName") String profileName) {
		System.out.println("recived profileName is " + profileName);
		return profiles.getProfile(profileName);
	}

	@POST
	public ProfileModel addProfile(ProfileModel profileModel) {
		return profiles.addProfile(profileModel);
	}

	@PUT
	@Path("/{ProfileName}")
	public ProfileModel updateProfile(@PathParam("ProfileName") String profileName, ProfileModel profileModel) {
		//profileModel.setProfileid();
		System.out.println(profiles.getProfile(profileName).getProfileid());
		profileModel.setProfileName(profileName);
		profileModel.setCreated(new Date().toString());
		return profiles.updateProfile(profileModel);
	}
	
    @DELETE
    @Path("/{ProfileName}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteProfile(@PathParam("ProfileName") String profileName){
    	ProfileModel profileModel = profiles.deleteProfile(profileName);
    	if(profileModel != null ){
    		return "Id "+profileName+" Found and deleted sucessfully";
    	}else{
    		return "Id "+profileName+" Not Found";
    	}	
    }
}
