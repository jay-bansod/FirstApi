package com.example.util;

import java.util.Random;

public class RandomTokenizer {
	
	public static String getRandomToken(int size) {
		String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder("");
		Random r = new Random();
		for(int i= 0; i<size;i++) {
			sb.append(source.charAt(r.nextInt(source.length())));
		}
		return sb.toString();
	}
}
