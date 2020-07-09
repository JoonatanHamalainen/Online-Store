package onlineStore.model;

import java.util.UUID;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderProduct {
	
	private final UUID orderID, productID;
	@NonNull
	private final int quantity;
	public OrderProduct(@JsonProperty("orderID") UUID orderID, @JsonProperty("productID") UUID productID, @JsonProperty("quantity") int quantity) {
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
	}
	
	public UUID getOrderID() {
		return orderID;
	}
	public UUID getProductID() {
		return productID;
	}
	public int getQuantity() {
		return quantity;
	}
}
