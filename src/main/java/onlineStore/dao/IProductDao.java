package onlineStore.dao;

import java.util.Optional;
import java.util.UUID;

import onlineStore.model.Product;

public interface IProductDao {
	
	int insertProduct(UUID ID, Product product);
	
	default int insertProduct(Product product) {
		UUID id = UUID.randomUUID();
		return insertProduct(id, product);
	}
	
	Optional<Product> selectProductByID(UUID ID);
	
	Optional<Product> selectProductByName(String name);
	
	Optional<Product> selectProductByProductTypeID(UUID ID);
	
	int deleteProductById(UUID ID);
	
	int updateProductById(UUID ID, Product product);

}
