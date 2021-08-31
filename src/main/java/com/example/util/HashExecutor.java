package com.example.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashExecutor {

	public static String getSHA512Hash(String input) {

		try {
			MessageDigest md = MessageDigest.getInstance("sha-512");
			byte b[] = md.digest(input.getBytes());
			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, b);

			// Convert message digest into hex value
			String hashtext = no.toString(16);

			// Add preceding 0s to make it 32 bit
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
