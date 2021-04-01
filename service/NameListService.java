package com.atproject2.service;

import com.atproject2.domain.Architect;
import com.atproject2.domain.Designer;
import com.atproject2.domain.Employee;
import com.atproject2.domain.Equipment;
import com.atproject2.domain.NoteBook;
import com.atproject2.domain.PC;
import com.atproject2.domain.Printer;
import com.atproject2.domain.Programmer;
import static com.atproject2.service.Data.*; //import all static data in Data class

//encapsulate the data from class Data into Employee[], and provide methods to operate Employee[]
public class NameListService {
	private Employee[] employees;

	//initialize employees and its elements
	public NameListService() {
		//1. create employees array the same size as class Data
//		employees = new Employee[Data.EMPLOYEES.length];
		employees = new Employee[EMPLOYEES.length];
		
		//2. create different objects of Employee, Programmer, Designer and Architect according to Data class
		for(int i=0; i<employees.length; i++) {
			
			//get the type of employees
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			
			//get 4 basic information of Employee: id, name, age, salary
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			
			Equipment equipment;
			double bonus;
			int stock;
			switch(type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}
	//get the equipment of EMPLOYEES[][] at index position
	private Equipment createEquipment(int index) {
		int choice = Integer.parseInt(EQUIPMENTS[index][0]);
		String model = EQUIPMENTS[index][1];
		switch(choice) {
		case PC: //21
			String display = EQUIPMENTS[index][2];
			return new PC(model, display);
		case NOTEBOOK: //22
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(model, price);
		case PRINTER: //23
			String type = EQUIPMENTS[index][2];
			return new Printer(model, type);
		}
		return null;
	}
	
	//get all employees
	public Employee[] getAllEmployees() {
		return employees;
	}
	
	//get Employee object with specific id
	public Employee getEmployee(int id) throws TeamException {
		if(id>0 && id<=employees.length) { //id starts from 1
			return employees[id-1];
		}
		throw new TeamException("can't find the employee with "+ id);
	}
}
