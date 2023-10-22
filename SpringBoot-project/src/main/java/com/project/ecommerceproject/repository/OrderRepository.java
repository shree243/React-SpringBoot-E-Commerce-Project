package com.project.ecommerceproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ecommerceproject.Entity.OrderEntity;

@Repository
public interface OrderRepository  extends JpaRepository<OrderEntity, Long> {


	@Query("SELECT o FROM OrderEntity o WHERE o.user.id = :userId AND (o.orderStatus = 'PLACED' OR o.orderStatus = 'CONFIRMED' OR o.orderStatus = 'SHIPPED' OR o.orderStatus = 'DELIVERED')")
	public List<OrderEntity> getUsersOrders(@Param("userId") Long userId);

	
}
