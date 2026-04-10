package org.example.respo;

import org.example.tables.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BusDetailRepo extends JpaRepository<BusEntity, Long> {

    List<BusEntity> findByFromPlaceAndToPlace(String fromplace , String toplace);



}
