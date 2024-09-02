package se.lexicon.model;

import java.security.SecureRandom;
import java.util.Random;

public class User {
    private String username;
    private String password;
    private boolean expired;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isExpired() {
        return expired;
    }

    public String userInfo(){
        return "Username: " + username + ", Password: " + password;
    }

    private String generateRandomPassword(){
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int passwordLength = 10;
        StringBuilder stringBuilder = new StringBuilder();

        Random random = new SecureRandom();

        for (int i =0; i< passwordLength; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length()); //1
            char randomChar = allowedCharacters.charAt(randomIndex); //B
            stringBuilder.append(randomChar); // 3
        }
        return stringBuilder.toString();
    }

    public void newPassword(){
        this.password = generateRandomPassword();
    }
}
