package onlineStore.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import onlineStore.dao.IProductDao;
import onlineStore.model.Product;

@Service
public class ProductService {
	
	private final IProductDao dao;
	
	@Autowired
	public ProductService(@Qualifier("onlineStore") IProductDao dao) {
		this.dao = dao;
	}
	
	public int addProduct(Product product) {
		return dao.insertProduct(product);
	}
	
	public Optional<Product> getProductByID(UUID ID) {
		return dao.selectProductByID(ID);
	}
	
	public Optional<Product> getProductByName(String name) {
		return dao.selectProductByName(name);
	}
	
	public Optional<Product> getProductByProductTypeID(UUID ID) {
		return dao.selectProductByProductTypeID(ID);
	}
	
	public int deleteProduct(UUID id) {
		return dao.deleteProductById(id);
	}
	
	public int updateProduct(UUID id, Product product) {
		return dao.updateProductById(id, product);
	}
	
}
