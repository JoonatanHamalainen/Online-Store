package onlineStore.dao;

import java.util.List;
import java.util.Map;
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
	
	List<Map<String, Object>> selectProductsByName(String name);
	
	List<Map<String, Object>> selectProductsByProductTypeID(int iD);
	
	int deleteProductById(UUID ID);
	
	int updateProductById(UUID ID, Product product);

}
