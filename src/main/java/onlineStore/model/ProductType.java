package onlineStore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductType {

    private final int productTypeID;

    private final String productTypeName;

    public ProductType(@JsonProperty("productTypeID") int productTypeID, @JsonProperty("productTypeName") String productTypeName) {
        this.productTypeID = productTypeID;
        this.productTypeName = productTypeName;
    }

    public int getProductTypeID() {
        return productTypeID;
    }

    public String getProductTypeName() {
        return productTypeName;
    }
}
