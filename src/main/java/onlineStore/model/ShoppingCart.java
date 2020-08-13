package onlineStore.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingCart {

	private final UUID productID;
	@NonNull
	private final int quantity;
	@NotBlank
	private final String username;
	
	public ShoppingCart(@JsonProperty("username") String username, @JsonProperty("productID") UUID productID, @JsonProperty("quantity") int quantity) {
		this.username = username;
		this.productID = productID;
		this.quantity = quantity;
	}

	public UUID getProductID() {
		return productID;
	}

	public int getQuantity() {
		return quantity;
	}


	public String getUsername() {
		return username;
	}
}
