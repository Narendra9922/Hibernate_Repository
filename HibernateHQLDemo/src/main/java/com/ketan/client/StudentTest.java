package com.ketan.client;

import javax.swing.JOptionPane;

import com.ketan.DAO.StudentDAO;
import com.ketan.DAO.StudentDAOFactory;
import com.ketan.DO.StudentDO;
import com.ketan.utility.HibernateUtil;

public class StudentTest {

	public static void main(String[] args) {
		StudentDAO dao = null;
		StudentDO student = null;
		int updateStatus = 0;
		
		String name;
		String city;
		String marks;
		String grade;
		String rollno;
		
		rollno = JOptionPane.showInputDialog("Enter Roll Number");
		name = JOptionPane.showInputDialog("Enter First Name");
		city = JOptionPane.showInputDialog("Enter City Name");
		marks = JOptionPane.showInputDialog("Enter Marks");
		grade = JOptionPane.showInputDialog("Enter Grade");
		
		//Get DAO
		dao = StudentDAOFactory.getInstance();
		
		student = new StudentDO();
		student.setSname(name);
		student.setScity(city);
		student.setSmarks(Integer.parseInt(marks));
		student.setSgrade(grade.toCharArray()[0]);
		student.setRollno(Integer.parseInt(rollno));
		
		System.out.println("Student Information Saved with Roll Number : "
						+dao.saveStudentInfo(student));
		
		student = dao.getStudent(Integer.parseInt(rollno));
		JOptionPane.showMessageDialog(null, student);
		//System.out.println(student);
		
		/*updateStatus = dao.updateStuentInfo(1, 95, 'A');
		if(updateStatus == 0)
		{
			System.out.println("Student Not found with Roll Number / not updated");
		}else {
			System.out.println("Student found with Roll Number / Updated successfully");
		}*/
		//close session factory
		HibernateUtil.closeSessionFactory();
	}

}
