package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.validation.Forename;
import au.com.iglooit.hellscream.validation.Surname;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 28/08/2014
 * Time: 4:04 PM
 */
public class RegistrationForm {
    @Forename
    private String forename;
    @Surname
    private String surname;

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
