package com.atproject2.domain;

import com.atproject2.service.Status;

//class Programmer extends class Employee, includes the attribute Equipment
public class Programmer extends Employee{
	private int memberId; //Id in the development team
	private Status status = Status.FREE; //the status of employee, free as default
	private Equipment equipment; //equipment for programmer
	
	public Programmer() {
		super();
	}

	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return getDetails()+"\tprogrammer\t"+status+"\t\t\t"+equipment.getDescription();
	}
	
	public String getDetailsForTeam() {
		return getTeamBasicDetails() + "\tProgrammer";
	}
	public String getTeamBasicDetails() {
		return memberId+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary();
	}
}
