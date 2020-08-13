package onlineStore.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import onlineStore.model.Product;
import org.springframework.stereotype.Repository;


@Repository("product")
public class ProductDao implements IProductDao {
	
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public ProductDao(JdbcTemplate jdcbTemplate) {
		this.jdbcTemplate = jdcbTemplate;
	}

	@Override
	public int insertProduct(UUID ID, Product product) {
		final String sql = "INSERT INTO product (productid, price, productname, imagesource, stock, description, producttypeid) VALUES (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, ID, product.getPrice(), product.getProductName(), product.getImageSource(), product.getStock(), product.getDescription(), product.getProductTypeID());
	}

	@Override
	public Optional<Product> selectProductByID(UUID ID) {
		final String sql = "SELECT productid, price, productname, imagesource, stock, description, producttypeid FROM product WHERE productid = ?";
		Product product = jdbcTemplate.queryForObject(sql, new Object[] { ID }, (resultSet, i) -> {
			UUID productID = UUID.fromString(resultSet.getString("productid"));
			float price = resultSet.getFloat("price");
			String productName = resultSet.getString("productname");
			String imageSource = resultSet.getString("imagesource");
			int stock = resultSet.getInt("stock");
			String description = resultSet.getString("description");
			int productTypeID = resultSet.getInt("producttypeid");
			return new Product(productID, productTypeID, price, productName, imageSource, description, stock);
		});
		return Optional.ofNullable(product);
	}

	@Override
	public List<Map<String, Object>> selectProductsByName(String name) {
		final String sql = "SELECT * FROM product WHERE productname LIKE ?";
		List<Map<String, Object>> products = jdbcTemplate.queryForList(sql, '%' + name + '%');
		
		return products;
	}

	@Override
	public List<Map<String, Object>> selectProductsByProductTypeID(int ID) {
		final String sql = "SELECT * FROM product WHERE producttypeid = ?";
		return jdbcTemplate.queryForList(sql, ID);
	}

	@Override
	public int deleteProductById(UUID ID) {
		final String sql = "DELETE FROM product WHERE productid = ?";
		return jdbcTemplate.update(sql, ID);
	}

	@Override
	public int updateProductById(UUID ID, Product product) {
		final String sql = "UPDATE product SET price = ?, productname = ?, imagesource  = ?, stock = ?, description = ? WHERE productid = ?";
		return jdbcTemplate.update(sql, product.getPrice(), product.getProductName(), product.getImageSource(), product.getStock(), product.getDescription(), ID);
	}

}
