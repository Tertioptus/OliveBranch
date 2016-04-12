package com.olivebranch.mock.any;

import com.olivebranch.mock.Field;
import com.olivebranch.mock.Profile;

public final class ProfileField<KEY> implements Field {

	private final Profile<KEY> profile;
	private final KEY fieldName;

	public ProfileField(Profile<KEY> profile, KEY fieldName) {
		this.profile=profile;
		this.fieldName=fieldName;
	}

	public String value() throws Exception {
		return profile.field(fieldName);
	}
}
