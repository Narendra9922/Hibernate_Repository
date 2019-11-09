package com.ketan.DAO;

public class StudentDAOFactory {
	public static StudentDAO getInstance() {
		return new StudentDAOImpl();
	}
}
