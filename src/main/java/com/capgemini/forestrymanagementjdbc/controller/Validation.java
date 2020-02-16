package com.capgemini.forestrymanagementjdbc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public static boolean isStringOnlyAlphabet(String str) {

		return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
	}

	public static boolean isValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isValidDate(String d) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(d); // if date invalid throw exception
			Date today = new Date();
			return date.before(today); // return false if future date
		} catch (Exception e) {
			return true;
		}
	}

	public static boolean isValidDat(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(d); // if date invalid throw exception
			Date today = new Date();
			return date.before(today); // return false if future date
		} catch (Exception e) {
			return true;
		}
	}

	public static boolean isNumber1(String s) {
		try {

			long t = Long.parseLong(s);
			if (t > 0) {

				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static boolean isNumber(String s) {
		try {
			long t = Long.parseLong(s);
			if (t > 0) {

				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;

	}

	public static boolean isValidTel(String s) {
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}

	public static int calculatePasswordStrength(String password) {

		int iPasswordScore = 0;

		if (password.length() < 8)
			return 0;
		else if (password.length() >= 10)
			iPasswordScore += 2;
		else
			iPasswordScore += 1;

		// if it contains one digit, add 2 to total score
		if (password.matches("(?=.*[0-9]).*"))
			iPasswordScore += 2;

		// if it contains one lower case letter, add 2 to total score
		if (password.matches("(?=.*[a-z]).*"))
			iPasswordScore += 2;

		// if it contains one upper case letter, add 2 to total score
		if (password.matches("(?=.*[A-Z]).*"))
			iPasswordScore += 2;

		// if it contains one special character, add 2 to total score
		if (password.matches("(?=.*[~!@#$%^&*()_-]).*"))
			iPasswordScore += 2;

		return iPasswordScore;

	}


}
