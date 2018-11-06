package com.gleb.controller.constrain.model;

import com.gleb.validator.annotatione.FieldMatch;

import javax.validation.constraints.NotNull;

@FieldMatch.Field({
        @FieldMatch(
                message = "Password doesn't match",
                field = "password",
                fieldMatch = "verifiedPassword")
})
public class RegisterUserDto {

    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String verifiedPassword;
    private String token;
    private String firstName;
    private String lastName;

    private RegisterUserDto() {

    }

    private RegisterUserDto(String email, String password, String verifiedPassword, String token, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.verifiedPassword = verifiedPassword;
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifiedPassword() {
        return verifiedPassword;
    }

    public void setVerifiedPassword(String verifiedPassword) {
        this.verifiedPassword = verifiedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static RegisterUserDto empty() {
        return new RegisterUserDto();
    }
}
