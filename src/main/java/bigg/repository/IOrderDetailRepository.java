package bigg.repository;

import bigg.model.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface IOrderDetailRepository extends CrudRepository<OrderDetail, Integer> {
}
