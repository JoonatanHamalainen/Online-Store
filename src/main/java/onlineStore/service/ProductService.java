package onlineStore.service;

import java.util.List;
import java.util.Map;
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
	public ProductService(@Qualifier("product") IProductDao dao) {
		this.dao = dao;
	}
	
	public int addProduct(Product product) {
		return dao.insertProduct(product);
	}
	
	public Optional<Product> getProductByID(UUID ID) {
		return dao.selectProductByID(ID);
	}
	
	public List<Map<String,Object>> getProductsByName(String name) {
		return dao.selectProductsByName(name);
	}
	
	public List<Map<String,Object>> getProductByProductsTypeID(int ID) {
		return dao.selectProductsByProductTypeID(ID);
	}
	
	public int deleteProduct(UUID id) {
		return dao.deleteProductById(id);
	}
	
	public int updateProduct(UUID id, Product product) {
		return dao.updateProductById(id, product);
	}
	
}
