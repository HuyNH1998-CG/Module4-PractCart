package bigg.repository;

import bigg.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IOrderRepository extends PagingAndSortingRepository<Order, Integer> {
}
