package com.demoblaze.Utilities;
import java.util.Random;

public class RandomUtility {
	

	    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    private static final int STRING_LENGTH = 10; // Change this value to set the desired length of the random string

	    public static String generateRandomString() {
	        Random random = new Random();
	        StringBuilder stringBuilder = new StringBuilder(STRING_LENGTH);

	        for (int i = 0; i < STRING_LENGTH; i++) {
	            int randomIndex = random.nextInt(CHARACTERS.length());
	            char randomChar = CHARACTERS.charAt(randomIndex);
	            stringBuilder.append(randomChar);
	        }

	        return stringBuilder.toString();
	    }

//	    public static void main(String[] args) {
//	        String randomString = generateRandomString();
//	        System.out.println("Random String: " + randomString);
//	    }
//	


}
