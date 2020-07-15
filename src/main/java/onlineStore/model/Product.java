package onlineStore.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	
	private final UUID productID;
	@NonNull
	private final float price;
	@NotBlank
	private final String productName, imageSource, description;
	@NonNull
	private final int stock, productTypeID;
	
	public Product(@JsonProperty("productID") UUID productID, @JsonProperty("productTypeID") int productTypeID, @JsonProperty("price") float price,@JsonProperty("productName") String productName, @JsonProperty("imageSource") String imageSource, @JsonProperty("description") String description, @JsonProperty("stock") int stock) {
		this.productID = productID;
		this.productTypeID = productTypeID;
		this.price = price;
		this.productName = productName;
		this.imageSource = imageSource;
		this.description = description;
		this.stock = stock;
	}

	public String getProductName() {
		return productName;
	}

	public UUID getProductID() {
		return productID;
	}

	public int getProductTypeID() {
		return productTypeID;
	}

	public float getPrice() {
		return price;
	}

	public String getImageSource() {
		return imageSource;
	}

	public String getDescription() {
		return description;
	}

	public int getStock() {
		return stock;
	}
}
