package Service;

import Model.Order;

import java.util.Date;
import java.util.List;

public interface IOrderService {
    Order placeOrder(Order order);
    List<Order> getOrderByPeriod(Date startDate, Date endDate);
    List<Order> findAll();



}
