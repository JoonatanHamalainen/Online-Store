package onlineStore.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import onlineStore.model.Product;

public class ProductDao implements IProductDao {
	
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public ProductDao(JdbcTemplate jdcbTemplate) {
		this.jdbcTemplate = jdcbTemplate;
	}

	@Override
	public int insertProduct(UUID ID, Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Product> selectProductByID(UUID ID) {
		final String sql = "SELECT ProductID, Price, ProductName, ImageSource, Stock, Description FROM Product WHERE ProductID = ?";

		Product product = jdbcTemplate.queryForObject(sql, new Object[] { ID }, (resultSet, i) -> {
			UUID productID = UUID.fromString(resultSet.getString("ProductID"));
			float price = resultSet.getFloat("Price");
			String productName = resultSet.getString("ProductName");
			String imageSource = resultSet.getString("ImageSource");
			int stock = resultSet.getInt("Stock");
			String description = resultSet.getString("Description");
			UUID productTypeID = UUID.fromString(resultSet.getString("ProductTypeID"));
			return new Product(productID, productTypeID, price, productName, imageSource, description, stock);
		});
		return Optional.ofNullable(product);
	}

	@Override
	public Optional<Product> selectProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> selectProductByProductTypeID(UUID ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteProductById(UUID ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProductById(UUID ID, Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

}
