package Restassuredtests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	
	public static String getName() {
		String genratedName=RandomStringUtils.randomAlphabetic(5);
		return ("John"+genratedName);
	}
	
	public static String getJob() {
		String genratedJob=RandomStringUtils.randomAlphabetic(5);
		return genratedJob;
	}
	public static String getSalary() {
		String genratedSalary=RandomStringUtils.randomNumeric(5);
		return genratedSalary;
	}
}
