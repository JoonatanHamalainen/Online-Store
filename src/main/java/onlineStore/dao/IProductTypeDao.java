/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineStore.dao;

import java.util.List;
import java.util.Optional;
import onlineStore.model.ProductType;

/**
 *
 * @author Pate
 */
public interface IProductTypeDao {

    Optional<ProductType> selectProductTypeBy_ID(int ID);

    List<ProductType> selectAllProductTypes();

    int insertProductType(ProductType productType);

    int updateProductTypesNameByID(int ID, ProductType productType);

}
