package com.visitevassouras.crm.repository;

import com.visitevassouras.crm.model.Atrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtrativoRepository extends JpaRepository<Atrativo, Long> {

}
