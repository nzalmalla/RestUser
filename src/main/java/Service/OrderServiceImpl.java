package Service;

import Model.Order;
import Repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Order placeOrder(Order order) {
        if(order !=null) {
            return repository.save(order);
        }
        return null;
    }

    @Override
    public List<Order> getOrderByPeriod(Date startDate, Date endDate) {
        System.out.println(startDate);
        System.out.println(endDate);
        if(startDate!=null && endDate!=null) {

            return repository.findByCreatedAtBetween(startDate, endDate);
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }
}
