package com.qa.utils;

import java.util.Scanner;

public class UserInput {
	private Scanner scan = new Scanner(System.in);

	public String getString() {
		return scan.nextLine();
	}

	public int getInt() {
		int num = 0;
		try {
			num = Integer.parseInt(getString());
		} catch (NumberFormatException e) {
			System.out.println("Please try again!");
			getInt();
		}
		return num;
	}

}
