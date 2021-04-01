package com.atproject2.service;

public class Data {
	public static final int EMPLOYEE = 10;
	public static final int PROGRAMMER = 11;
	public static final int DESIGNER = 12;
	public static final int ARCHITECT = 13;
	
	public static final int PC = 21;
	public static final int NOTEBOOK = 22;
	public static final int PRINTER = 23;
	
	//Employee  : 10, id, name, age, salary
	//Programmer: 11, id, name, age, salary
	//Designer  : 12, id, name, age, salary, bonus
	//Architect : 13, id, name, age, salary, bonus, stock
	public static final String[][] EMPLOYEES = {
			{"10","1","Eric","22","3000"},
			{"13","2","Kyle","32","18000","15000","2000"},
			{"11","3","Stan","23","7000"},
			{"11","4","Kenny","24","7300"},
			{"12","5","Butters","28","10000","5000"},
			{"11","6","Clyde","22","6800"},
			{"12","7","Wendy","29","10800","5200"},
			{"13","8","Token","30","19800","15000","2500"},
			{"12","9","Craig","26","9800","5500"},
			{"11","10","Heidi","21","6600"},
			{"11","11","Tweek","25","7100"},
			{"12","12","Nicole","27","9600","4800"}
	};
	
	//EQUIPMENTS array and EMPLOYEES array are one-to-one correspondence
	//PC      : 21, model, display
	//NoteBook: 22, model, price
	//Printer : 23, name, type
	public static final String[][] EQUIPMENTS = {
			{},
			{"22", "Lenovo", "6000"},
			{"21", "Dell", "NEC17inch"},
			{"21", "Dell", "Samsung17inch"},
			{"21", "Canon", "laser"},
			{"21", "ASUS", "Samsung17inch"},
			{"21", "ASUS", "Samsung17inch"},
			{"23", "Epson", "matrix"},
			{"22", "hp", "5800"},
			{"21", "Dell", "NEC17inch"},
			{"21", "ASUS", "Samsung17inch"},
			{"22", "hp", "5800"}
	};
}
