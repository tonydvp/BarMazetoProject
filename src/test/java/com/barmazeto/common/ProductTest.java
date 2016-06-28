package com.barmazeto.common;

import com.barmazeto.dao.ProductDAO;
import com.barmazeto.exceptions.DAOException;
import org.junit.Test;

public class ProductTest {

	@Test
	public void test() throws DAOException {
		//Product product = new Product("Shumensko", 1.25, ProductType.BEER);
		//System.out.println(product);
		ProductDAO dao = new ProductDAO();
		//dao.addProduct(product);
		// Collection<Product> products = com.barmazeto.dao.getAllProducts();
		// for (Product product2 : products) {
		// System.out.println(product2);
		// }
	}
}
