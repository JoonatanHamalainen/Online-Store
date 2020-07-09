package onlineStore.model;

import java.sql.Date;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
	
	private final UUID orderID, userID;
	@NotBlank
	private final String deliveryStatus;
	@NonNull
	private final float totalPrice;
	@NonNull
	private final Date date;
	
	public Order(@JsonProperty("orderID") UUID orderID, @JsonProperty("userID") UUID userID, @JsonProperty("deliveryStatus") String deliveryStatus, @JsonProperty("totalPrice") float totalPrice, @JsonProperty("date") Date date) {
		this.orderID = orderID;
		this.userID = userID;
		this.deliveryStatus = deliveryStatus;
		this.totalPrice = totalPrice;
		this.date = date;
	}

	public UUID getOrderID() {
		return orderID;
	}

	public UUID getUserID() {
		return userID;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public Date getDate() {
		return date;
	}
}
