package onlineStore.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import onlineStore.model.Product;
import org.springframework.stereotype.Repository;


@Repository("postgres")
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
