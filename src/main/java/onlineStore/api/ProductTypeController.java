/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineStore.api;

import java.util.List;
import javax.validation.Valid;
import onlineStore.model.ProductType;
import onlineStore.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pate
 */
@RequestMapping("api/v1/productTypes")
@RestController
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    //-------------- GET MAPPINGS -----------
    @GetMapping(path = "{ID}")
    public ProductType getProductTypeBy_ID(@PathVariable("ID") int ID) {
        return productTypeService.getProductTypeBy_ID(ID)
                .orElse(null);
    }

    @GetMapping
    public List<ProductType> getAllProductTypes() {
        return productTypeService.getAllProductTypes();
    }

    //-------------- POST MAPPINGS -----------
    @PostMapping
    public int addProductType(@Valid @NonNull @RequestBody ProductType productType) {
        return productTypeService.addProductType(productType);
    }

    //-------------- PUT MAPPINGS -----------
    @PutMapping(path = "{id}")
    public int updateProductType(@PathVariable("id") int ID, @Valid @NonNull @RequestBody ProductType productType) {
        return productTypeService.updateProductType(ID, productType);
    }

}
