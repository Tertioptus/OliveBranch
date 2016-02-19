package com.olivebranch.mock.any;

import com.olivebranch.mock.Field;
import com.olivebranch.mock.Profile;

public final class ProfileField implements Field {

	private final Profile profile;
	private final String fieldName;

	public ProfileField(Profile profile, String fieldName) {
		this.profile=profile;
		this.fieldName=fieldName;
	}

	public String value() throws Exception {
		return profile.field(fieldName);
	}
}
