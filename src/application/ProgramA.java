package application;

import java.util.Date; 
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class ProgramA {

	public static void main(String[] args) {
		//TEST PROGRAM
		Scanner sc = new Scanner(System.in);
	
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===== TEST 1: seller find by id =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("===== TEST 2: seller find by department =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		System.out.println("===== TEST 3: seller find All =====");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("===== TEST 4: seller insert =====");
		Seller newSeller = new Seller(null, "Amanda", "manmanda@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted. New id = " + newSeller.getId());
		
		System.out.println("===== TEST 5: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Ashley Campbell");
		sellerDao.update(seller);
		System.out.println("Update completed.");

		System.out.println("===== TEST 6: seller deletion =====");
		System.out.println("Enter id for delete test: ");
		Integer id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deletion completed.");
		
		//PRÓXIMO
		/*
		IMPLEMENTAR A CLASSE "DepartmentDaoJDBC"
		MEXER NA CLASSE "DaoFactory" PARA INCLUIR UM MÉTODO PARA INSTANCIAR A CLASSE "DepartmentDao"
	    CRIE OUTRO PROGRAMA PRINCIPAL PARA TESTAR DE PREFERECIA.
		*/
		sc.close();
	}
}
