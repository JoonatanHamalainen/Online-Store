/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineStore.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
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

}
