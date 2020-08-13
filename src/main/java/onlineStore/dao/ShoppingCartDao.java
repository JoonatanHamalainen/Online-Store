package onlineStore.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import onlineStore.model.Product;

@Repository("shoppingCart")
public class ShoppingCartDao implements IShoppingCartDao {
	

	public List<Product> selectAllProductsFromCart() {
		return null;
	}

	public int insertProductToCart(UUID userID, UUID productID) {
		return 0;
	}

	public int deleteProductFromCart(UUID userID, UUID productID) {
		return 0;
	}

	public int deleteCartByID(UUID userID) {
		return 0;
	}

}
