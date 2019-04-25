package io.conor.repository;

import org.springframework.data.repository.CrudRepository;

import io.conor.model.UserOrder;

public interface OrderRepository extends CrudRepository<UserOrder,Integer> {

}
