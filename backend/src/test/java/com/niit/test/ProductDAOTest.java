package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ProductDAO;
import com.niit.backend.Product;

public class ProductDAOTest {

	static ProductDAO productdao; 
	
	@BeforeClass
	public static void intialize(){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productdao = (ProductDAO)context.getBean("productDAO");
	}
	
	
	@Test
	public void addProductTest(){
		
		Product product = new Product();
		product.setProductName("Samsung");
		product.setProductDesc("All model mobile");
		product.setQuantity(10);
		product.setPrice(15000);
		product.setSupplierId(13);
		product.setCategoryId(1);
		
		assertTrue("error in adding product:",productdao.addProduct(product));
		
	}
	
	@Ignore
	@Test
	public void updateProductTest(){
		
		Product product = productdao.getProduct(19);
		product.setProductName("Lenova");
		product.setProductDesc("All model mobile");
		product.setQuantity(5);
		product.setPrice(10000);
		product.setSupplierId(13);
		product.setCategoryId(1);
		
		assertTrue("error in updating product:",productdao.updateProduct(product));
		
	}
	
	@Ignore
	@Test
	public void deleteProductTest(){
		
		Product product = productdao.getProduct(16);
		product.setProductName("Redmi");
		product.setProductDesc("All model mobile");
		product.setQuantity(5);
		product.setPrice(10000);
		product.setSupplierId(13);
		product.setCategoryId(1);
		
		assertTrue("error in deleting product:",productdao.deleteProduct(product));
		
	}
	
	@Test
	public void listProductTest(){
		
		List<Product> listproduct = productdao.listProducts();
		assertNotNull("problem in listing:",listproduct);
		
		for(Product product:listproduct){
			System.out.print(product.getProductDesc()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.println(product.getProductDesc());
		}
	}

}