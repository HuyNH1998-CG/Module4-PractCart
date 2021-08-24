package bigg.service;

import bigg.model.Order;
import bigg.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    IOrderRepository iOrderRepository;
    public void save(Order order){
        iOrderRepository.save(order);
    }
}
