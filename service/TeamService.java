package com.atproject2.service;

import com.atproject2.domain.Architect;
import com.atproject2.domain.Designer;
import com.atproject2.domain.Employee;
import com.atproject2.domain.Programmer;

//management of developers in team: add delete...
public class TeamService {
	
	private static int counter = 1; //assign to memberId
	private final int MAX_MEMBER = 5; //limit the number of team
	private Programmer[] team = new Programmer[MAX_MEMBER]; //save team members
	private int total; //record the actual number of members in team
	
	public TeamService() {
		super();
	}
	
	//get all members in the developing team
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for(int i=0; i<team.length; i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	
	//add specific employee into the developing team
	public void addMember(Employee e) throws TeamException {
		//team is full
		if(total >= MAX_MEMBER) {
			throw new TeamException("The team is full, can't add any more employees.");
		}
		//the employee is not a programmer
		if(!(e instanceof Programmer)) {
			throw new TeamException("The employee is not a programmer, can't add that.");
		}
		//the employee is already in the team
		if(isExist(e)) {
			throw new TeamException("The employee is already in the team.");
		}
		//the employee is already in other team
		//the employee is on vacation
		Programmer p = (Programmer) e; //there can't be ClassCastException, check it before this case
		if("BUSY".equalsIgnoreCase(p.getStatus().getNAME())){
			throw new TeamException("The employee is already in other team"); 
		}else if("VACATION".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("The employee is on vacation");
		}
		
		//there is 1 architect at most
		//there are 2 designers at most
		//there are 3 programmers at most
		int numOfArch=0, numOfDes=0, numOfPro=0;
		for(int i=0; i<total; i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
			}else if(team[i] instanceof Designer) {
				numOfDes++;
			}else if(team[i] instanceof Programmer) {
				numOfPro++;
			}
		}
		if(p instanceof Architect) {
			if(numOfArch >= 1) {
				throw new TeamException("there is 1 architect at most");
			}
		}else if(p instanceof Designer) {
			if(numOfDes >= 2) {
				throw new TeamException("there are 2 designers at most");
			}
		}else if(p instanceof Programmer) {
			if(numOfPro >= 3) {
				throw new TeamException("there are 3 programmers at most");
			}
		}
		
		//add p(e) into the team
		team[total++] = p;
		//set p
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
	}
	//check the specific employee is already in the team
	private boolean isExist(Employee e) {
		for(int i=0; i<total; i++) {
			if(team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}
	
	//delete member from the team
	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for(; i<total; i++) {
			if(team[i].getMemberId() == memberId) { //found the member
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		if(i >= total) { //didn't find the member
			throw new TeamException("Specific member not found, delete failure");
		}
		for(int j=i+1; j<total; j++) { //cover, delete member with memberId
			team[j-1] = team[j];
		}
		team[--total] = null; //the last element index is total-1
	}
}
