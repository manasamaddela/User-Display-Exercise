package com.matc.entity;
// TODO Add instance variable for the date of birth
// TODO Add a calculation for the user's age. Age should not be stored, it should be calculated only.

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private String firstName;
    private String lastName;
    private String userid;
    private String userAge;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     * @param userAge   the userAge
     */
    public User(String firstName, String lastName, String userid, String userAge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.userAge = userAge;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }
    /**
     * Gets userAge.
     *
     * @return the userAge
     */
    public String getUserAge() {
        return userAge;
    }

    /**
     * Sets userAge.
     *
     * @param userAge the userAge
     */
    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                ", age='" + userAge + '\'' +
                '}';
    }


}
