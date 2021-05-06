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
		Integer id;
	
		SellerDao sellerDao = DaoFactory.createSellerDao(); //DATA ACCESS OBJECT
		
		System.out.println("===== TEST 1: seller find by id =====");
		System.out.print("Enter Id for test: ");
		id = sc.nextInt();
		Seller seller = sellerDao.findById(id);
		System.out.println(seller);
		
		System.out.println("===== TEST 2: seller find by department =====");
		System.out.print("Enter department Id for test: ");
		id = sc.nextInt();
		Department department = new Department(id, null);
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
		id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deletion completed.");
	
		sc.close();
	}
}
