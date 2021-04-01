package com.atproject2.view;

import java.util.Scanner;

//TSUtility class : read from keyboard
public class TSUtility {
	private static Scanner scanner = new Scanner(System.in);
	
	//read from the keyboard. If input between '1' and '4', return the character
	public static char readMenuSelection() {
		char c;
		while(true) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if(c!='1' && c!='2' && c!='3' && c!='4') {
				System.out.println("The selection is wrong, please enter again: ");
			}else break;
		}
		return c;
	}
	
	//wait until press enter key to continue
	public static void readReturn() {
		System.out.print("press enter key to continue...");
		readKeyBoard(100, true);
	}
	
	//read an integer(length<=2) from keyboard, and return it
	public static int readInt() {
		int n;
		while(true) {
			String str = readKeyBoard(2, false);
			try {
				n = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.println("The number is wrong, please enter again: ");
			}
		}
		return n;
	}
	
	//read 'Y' or 'N' from keyboard, and return it
	public static char readConfirmSelection() {
		char c;
		while(true) {
			String str = readKeyBoard(1, false).toUpperCase();
			c = str.charAt(0);
			if(c=='Y' || c=='N') {
				break;
			}else {
				System.out.println("The selection is wrong, please enter again: ");
			}
		}
		return c;
	}
	
	private static String readKeyBoard(int limit, boolean blankReturn) {
		String line = "";
		
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			if(line.length() == 0) {
				if(blankReturn) return line;
				else continue;
			}
			
			if(line.length()<1 || line.length()>limit) {
				System.out.println("The length should <= "+limit+", please enter again: ");
				continue;
			}
			break;
		}
		return line;
	}
}
