package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.SupplierDAO;
import com.niit.backend.Supplier;

public class SupplierDAOTest {

	static SupplierDAO supplierDAO; 
	@BeforeClass
	public static void intialize(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		
		context.refresh();
		
		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
	}
	
	
	@Test
	public void addSupplierTest(){
		Supplier supplier = new Supplier();
		supplier.setSupplierName("Lenova");
		supplier.setSupplierName("Gurugon");
		assertTrue("problem in adding supplier:",supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void updateSupplierTest(){
		Supplier supplier = supplierDAO.getSupplier(14);
		supplier.setSupplierName("Samsung");
		supplier.setSupplierName("Gurugon");
		assertTrue("problem in updating supplier:",supplierDAO.updateSupplier(supplier));
	}

	@Ignore
	@Test
	public void deleteSupplierTest(){
		Supplier supplier = supplierDAO.getSupplier(14);
		supplier.setSupplierName("Samsung");
		assertTrue("problem in deleting supplier:",supplierDAO.deleteSupplier(supplier));
	}
	
	@Test
	public void listSupplier(){
		
		List<Supplier> listsupplier = supplierDAO.listSuppliers();
		assertNotNull("problem in listing supplier:",listsupplier);
		
		for(Supplier supplier:listsupplier){
			System.out.print(supplier.getSupplierId()+":::");
			System.out.print(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierId());
		}
 	}
}