package com.ghrairi.TounsiKids.repository;


import com.ghrairi.TounsiKids.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Orders,Long> {
}
