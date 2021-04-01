package com.atproject2.view;

import com.atproject2.domain.Employee;
import com.atproject2.domain.Programmer;
import com.atproject2.service.NameListService;
import com.atproject2.service.TeamException;
import com.atproject2.service.TeamService;

//development team selection
//main module, show and deal with users' operation
public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	
	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
		
		System.out.println("\nThank you for visiting <<development team selection software>>!");
	}
	
	public void enterMainMenu() {
		boolean flag = true;
		char menu = 0;
		while(flag) {
			if(menu != '1') {
				listAllEmployees();
			}
			System.out.println("1-team employee list, 2-add employee into team, 3-delete team employee, 4-exit");
			System.out.print("Please choose(1-4): ");
			menu = TSUtility.readMenuSelection();
			switch(menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("Are you sure to exit(Y/N): ");
				char confirmed = TSUtility.readConfirmSelection();
				if(confirmed == 'Y') {
					flag = false;
				}
				break;
			}
		}
	}
	
	//show all employees information
	private void listAllEmployees() {
		System.out.println("------------------------------- development team selection software -------------------------------\n");
		
		Employee[] employees = listSvc.getAllEmployees();
		if(employees==null || employees.length==0) {
			System.out.println("There is not any employees in the company");
		}else {
			System.out.println("ID\tName\tAge\tSalary\tPosition\tStatus\tBonus\tStock\tEquipment");
			for(int i=0; i<employees.length; i++) {
				System.out.println(employees[i]);
			}
		}
		
		System.out.println("\n------------------------------- development team selection software -------------------------------\n");
	}
	
	private void getTeam() {
		System.out.println("---------------------------------- development team members list ----------------------------------\n");
		
		Programmer[] team = teamSvc.getTeam();
		if(team==null || team.length==0) {
			System.out.println("There is not any members in the team");
		}else {
			System.out.println("TID/ID\tName\tAge\tSalary\tPosition\tBonus\tStock\n");
			for(int i=0; i<team.length; i++) {
				System.out.println(team[i].getDetailsForTeam()); 
			}
		}
		
		System.out.println("\n---------------------------------- development team members list ----------------------------------\n");
	}
	
	private void addMember() {
		System.out.println("---------------------------------- add development team member -----------------------------------\n");
		System.out.print("Please enter employee ID to be added: ");
		int id = TSUtility.readInt();
		try {
			Employee emp = listSvc.getEmployee(id);
			teamSvc.addMember(emp);
			System.out.println("add successfully");
		} catch (TeamException e) {
			System.out.println("add failure, because: "+ e.getMessage());
		}
		//enter key to continue
		TSUtility.readReturn();
		
		System.out.println("\n---------------------------------- add development team member ------------------------------------\n");
	}
	
	private void deleteMember() {
		System.out.println("---------------------------------- delete development team member ---------------------------------\n");
		System.out.print("Please enter employee ID to be deleted: ");
		int memberId = TSUtility.readInt();
		
		System.out.print("Are you sure to delete(Y/N): ");
		char isDelete = TSUtility.readConfirmSelection();
		if(isDelete == 'N') {
			return;
		}
		try {
			teamSvc.removeMember(memberId);
			System.out.println("delete successfully");
		} catch (TeamException e) {
			System.out.println("delete failure, because: "+e.getMessage());
		}
		//enter key to continue
		TSUtility.readReturn();
		
		System.out.println("\n---------------------------------- delete development team member ---------------------------------\n");
	}
}
