package onlineStore.model;

import java.util.UUID;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingCart {

	private final UUID userID, productID;
	@NonNull
	private final int quantity;
	
	public ShoppingCart(@JsonProperty("userID") UUID userID, @JsonProperty("productID") UUID productID, @JsonProperty("quantity") int quantity) {
		this.userID = userID;
		this.productID = productID;
		this.quantity = quantity;
	}

	public UUID getUserID() {
		return userID;
	}

	public UUID getProductID() {
		return productID;
	}

	public int getQuantity() {
		return quantity;
	}
}
