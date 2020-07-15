package onlineStore.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductType {
	
	private final int productTypeID;
	@NotBlank
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
