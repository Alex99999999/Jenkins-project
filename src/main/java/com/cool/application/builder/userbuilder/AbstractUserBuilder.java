package com.cool.application.builder.userbuilder;

import com.cool.application.entity.User;

public abstract class AbstractUserBuilder {

    private static User user;
    private static final String DEFAULT_PHONE_NUMBER = "+000000000000";
    protected static String familyName;
    protected static String givenName;
    protected static String phoneNumber;
    protected static int age;

    public static class Builder {

        public Builder() {
            user = new User();
        }

        public Builder withFamilyName() {
            user.setFamilyName(familyName);
            return this;
        }

        public Builder withGivenName() {
            user.setGivenName(givenName);
            return this;
        }

        public Builder withPhoneNumber() {
            user.setPhoneNumber(phoneNumber);
            return this;
        }

        public Builder withAge() {
            user.setAge(age);
            return this;
        }

        public User build() {
            return user;
        }
    }

}
