package onlineStore.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductTypes {
	
	private final UUID productTypeID;
	@NotBlank
	private final String productTypeName;
	
	public ProductTypes(@JsonProperty("productTypeID") UUID productTypeID, @JsonProperty("productTypeName") String productTypeName) {
		this.productTypeID = productTypeID;
		this.productTypeName = productTypeName;
	}

	public UUID getProductTypeID() {
		return productTypeID;
	}

	public String getProductTypeName() {
		return productTypeName;
	}
}
