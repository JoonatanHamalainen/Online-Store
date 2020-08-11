/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineStore.service;

import java.util.List;
import java.util.Optional;
import onlineStore.dao.IProductTypeDao;
import onlineStore.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pate
 */
@Service
public class ProductTypeService {

    private final IProductTypeDao productTypeDao;

    @Autowired
    public ProductTypeService(@Qualifier("productType") IProductTypeDao productTypeDao) {
        this.productTypeDao = productTypeDao;
    }

    public Optional<ProductType> getProductTypeBy_ID(int ID) {
        return productTypeDao.selectProductTypeBy_ID(ID);
    }

    public List<ProductType> getAllProductTypes() {
        return productTypeDao.selectAllProductTypes();
    }

    public int addProductType(ProductType productType) {
        return productTypeDao.insertProductType(productType);
    }

    public int updateProductType(int ID, ProductType productType) {
        return productTypeDao.updateProductTypesNameByID(ID, productType);
    }

}
