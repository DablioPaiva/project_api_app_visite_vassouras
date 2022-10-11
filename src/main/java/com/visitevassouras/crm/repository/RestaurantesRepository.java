package com.visitevassouras.crm.repository;

import com.visitevassouras.crm.entity.Restaurantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantesRepository extends JpaRepository<Restaurantes, Long> {

}
