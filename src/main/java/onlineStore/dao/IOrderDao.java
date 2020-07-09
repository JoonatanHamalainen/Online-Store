package onlineStore.dao;

import java.sql.Date;
import java.util.UUID;

public interface IOrderDao {
	
	int addOrder(UUID orderID, Date date, String deliveryStatus, float totalPrice, UUID userID);
	

}
