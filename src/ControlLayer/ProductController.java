/**
 * 
 */
package ControlLayer;

import java.util.ArrayList;

import DBLayer.*;
import ModelLayer.*;

/**
 * @author S�ren
 *
 */
public class ProductController {

	private Product p;
	private ProductDB pDB;
	private ProductIFDB pIFDB;

	/**
	 * 
	 */
	public ProductController() {
		// TODO Auto-generated constructor stub
	}

	public Product findProduct(int productID){
		pDB = new ProductDB();
		return pDB.findProduct(productID);
	}
	public ArrayList<Product> findAllProducts()
	{
		pDB = new ProductDB();
		ArrayList<Product> allProd = new ArrayList<Product>();
		allProd = pDB.getAllProducts();
		return allProd;
	}

	public int updateProduct(int oldProductID, int newProductID, String name, int minStock, int purchasePrice, float rentPrice, float salesPrice, String countryOfOrigin, int type, int supplierID, boolean isActive)
	{
		pDB = new ProductDB();
		Product prod = new Product();
		prod.setId(newProductID);
		prod.setName(name);
		prod.setMinStock(minStock);
		prod.setPurchasePrice(purchasePrice);
		prod.setRentPrice(rentPrice);
		prod.setSalesPrice(salesPrice);
		prod.setCountryOfOrigin(countryOfOrigin);
		prod.setType(type);
		prod.setSupplierID(supplierID);
		prod.setActive(isActive);
		return  pDB.updateProduct(prod,oldProductID);     
		
	}
	public void insertNew(int productID, String name, int minStock, int purchasePrice, float rentPrice, float salesPrice, String countryOfOrigin, int type, int supplierID, boolean isActive) throws Exception
	{    
		Product prod = new Product();
		prod.setName(name);
		prod.setMinStock(minStock);
		prod.setPurchasePrice(purchasePrice);
		prod.setRentPrice(rentPrice);
		prod.setSalesPrice(salesPrice);
		prod.setCountryOfOrigin(countryOfOrigin);
		prod.setType(type);
		prod.setSupplierID(supplierID);
		prod.setActive(isActive);
		try{
			DbConnection.startTransaction();
			pDB = new ProductDB();
			pDB.insertProduct(prod);
			DbConnection.commitTransaction();
		}
		catch(Exception e)
		{
			DbConnection.rollbackTransaction();
			throw new Exception("Product not inserted");
		}
	}
	public void deleteProduct(int productID) throws Exception{
		pDB = new ProductDB();
		Product prod = findProduct(productID);
		prod.setActive(false);
		
		try{
			pDB.updateProduct(prod, productID);
		}
		catch(Exception e)
		{
			throw new Exception("Product not deleted");
		}
	}

}
