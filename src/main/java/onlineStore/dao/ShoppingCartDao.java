package onlineStore.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import onlineStore.model.Product;
import onlineStore.model.ShoppingCart;

@Repository("shoppingCart")
public class ShoppingCartDao implements IShoppingCartDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ShoppingCartDao(JdbcTemplate jdcbTemplate) {
		this.jdbcTemplate = jdcbTemplate;
	}

	public List<Map<String, Object>> selectAllProductsFromCart(String username) {
		final String sql = "SELECT * FROM shoppingcart WHERE username = ?";
		return jdbcTemplate.queryForList(sql, username);
	}

	public int insertProductToCart(ShoppingCart cart) {
		final String sql = "INSERT INTO shoppingcart (quantity, productid, username) VALUES (?,?,?)";
		return jdbcTemplate.update(sql, cart.getQuantity(), cart.getProductID(), cart.getUsername());
	}

	public int deleteProductFromCart(String username, UUID productID) {
		final String sql = "DELETE FROM shoppingcart WHERE username = ? AND productid = ?";
		return jdbcTemplate.update(sql, username, productID);
	}

	public int deleteCartByID(String username) {
		final String sql = "DELETE FROM shoppingcart WHERE username = ?";
		return jdbcTemplate.update(sql, username);
	}

}
