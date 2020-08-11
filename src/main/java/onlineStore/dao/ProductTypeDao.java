/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineStore.dao;

import java.util.List;
import java.util.Optional;
import onlineStore.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pate
 */
@Repository("productType")
public class ProductTypeDao implements IProductTypeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductTypeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<ProductType> selectProductTypeBy_ID(int ID) {

        final String sql = "SELECT * FROM producttypes WHERE producttypeid = ?";
        ProductType productType = jdbcTemplate.queryForObject(sql, new Object[]{ID}, (resultSet, i) -> {
            int productTypeID = resultSet.getInt("producttypeid");
            String productTypeName = resultSet.getString("producttypename");
            return new ProductType(productTypeID, productTypeName);
        });
        return Optional.ofNullable(productType);
    }

    @Override
    public List<ProductType> selectAllProductTypes() {

        final String sql = "SELECT * FROM producttypes";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int productTypeID = resultSet.getInt("producttypeid");
            String productTypeName = resultSet.getString("producttypename");
            return new ProductType(productTypeID, productTypeName);
        });

    }

    @Override
    public int insertProductType(ProductType productType) {
        final String sql = "INSERT INTO producttypes (producttypeid, producttypename)"
                + " VALUES (?, ?)";
        return jdbcTemplate.update(sql, productType.getProductTypeID(), productType.getProductTypeName());
    }

    @Override
    public int updateProductTypesNameByID(int ID, ProductType productType) {
        final String sql = "UPDATE producttypes SET producttypename = ? WHERE producttypeid = ?";
        return jdbcTemplate.update(sql, productType.getProductTypeName(), ID);
    }

}
