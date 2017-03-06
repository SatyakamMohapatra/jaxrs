package com.satya.jersey.messages.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.satya.jersey.messages.dao.DatabaseClass;
import com.satya.jersey.messages.model.ProfileModel;

public class ProfileServices {

	private Map<String, ProfileModel> profiles = DatabaseClass.getProfiles();

	public ProfileServices() {
		profiles.put("satya", new ProfileModel(1l,"satya","Satyakam","Mohapatra"));
	}

	public List<ProfileModel> getAllProfiles() {
		return new ArrayList<>(profiles.values());
	}

	public ProfileModel getProfile(String ProfileName) {
		return profiles.get(ProfileName);
	}

	public ProfileModel addProfile(ProfileModel profileModel) {
		profileModel.setCreated(new Date().toString());
		profileModel.setProfileid((long) (profiles.size() + 1));
		profiles.put(profileModel.getProfileName(), profileModel);
		return profileModel;
	}

	public ProfileModel updateProfile(ProfileModel profileModel) {
		profileModel.setCreated(new Date().toString());
		if (profileModel.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profileModel.getProfileName(), profileModel);
		return profileModel;
	}

	public ProfileModel deleteProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
