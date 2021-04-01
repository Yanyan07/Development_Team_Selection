package com.atproject2.domain;

//class Designer extends super class Programmer
public class Designer extends Programmer{
	private  double bonus;

	public Designer() {
		super();
	}

	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return getDetails()+"\tdesigner\t"+getStatus()+"\t"+bonus+"\t\t"+getEquipment().getDescription();
	}
	
	public String getDetailsForTeam() {
		return getTeamBasicDetails()+"\tDesigner\t"+getBonus();
	}
}
