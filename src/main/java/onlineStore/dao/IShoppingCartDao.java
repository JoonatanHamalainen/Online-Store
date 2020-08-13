package onlineStore.dao;

import java.util.List;
import java.util.UUID;

import onlineStore.model.Product;

public interface IShoppingCartDao {
	
	List<Product> selectAllProductsFromCart();
	
	int insertProductToCart(UUID userID, UUID productID);
	
	int deleteProductFromCart(UUID userID, UUID productID);
	
	int deleteCartByID(UUID userID);
	
	
	
	
}
