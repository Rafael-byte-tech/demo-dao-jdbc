package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramB {

	public static void main(String[] args) {
		// TEST PROGRAM
		Scanner sc = new Scanner(System.in);
		Integer id;
		String name;
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		/*
		System.out.println("===== TEST 1: department insertion =====");
		Department newDepartment = new Department(null, "Department2");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted. New Id = " + newDepartment.getId());
		*/
		
		/*
		System.out.println("===== TEST 2: find department by id =====");
		System.out.print("Insert Id to find department: ");
		id = sc.nextInt();
		Department department = departmentDao.findById(2);
		System.out.println(department);
        */
		
		/*
		System.out.println("===== TEST 3: department update");
		System.out.print("Insert Id for update test: ");
		id = sc.nextInt();
		department = departmentDao.findById(id);
		System.out.print("Insert name: ");
		name = sc.next();
		department.setName(name);
		departmentDao.update(department);
		System.out.println("update completed");
		*/
		
		System.out.println("===== TEST 4: department deletion");
		System.out.print("Enter Id for delete test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deletion completed");
	}

}
