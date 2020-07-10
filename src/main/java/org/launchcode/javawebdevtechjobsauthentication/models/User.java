package org.launchcode.javawebdevtechjobsauthentication.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import com.sun.istack.NotNull;


@Entity
public class User extends AbstractEntity{

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(@NotNull String username, @NotNull String pwHash) {
        this.username = username;
        this.pwHash = encoder.encode(pwHash);
    }

    public String getUsername() {return username;}

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}

