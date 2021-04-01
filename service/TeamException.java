package com.atproject2.service;

//user-defined exception
public class TeamException extends Exception {
	static final long serialVersionUID = 37589939551L;
	
	public TeamException() {
		super();
	}
	
	public TeamException(String msg) {
		super(msg);
	}
}
