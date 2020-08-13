package onlineStore.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import onlineStore.model.ShoppingCart;

public interface IShoppingCartDao {
	
	List<Map<String, Object>> selectAllProductsFromCart(String username);
	
	int insertProductToCart(ShoppingCart cart);
	
	int deleteProductFromCart(String username, UUID productID);
	
	int deleteCartByID(String username);
	
	
	
	
}
