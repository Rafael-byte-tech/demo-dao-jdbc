package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramB {

	public static void main(String[] args) {
		// TEST PROGRAM
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== TEST 1: department insert =====");
		Department newDepartment = new Department(null, "Department2");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted. New Id = " + newDepartment.getId());

	}

}
