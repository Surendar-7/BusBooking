package org.example.respo;

import org.example.tables.BusDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BusDetailRepo extends JpaRepository<BusDetailEntity, Long> {

    List<BusDetailEntity> findByfromplace(String fromplace);
    List<BusDetailEntity> findBytoplace();

//    List<BusDetailEntity> findByFromLocationAndToLocation(String fromplace, String to);

    List<BusDetailEntity> findByFromLocationAndToLocation(String from, String to);
    List<BusDetailEntity>  findByToLocation(String tolocation);

    List<BusDetailEntity> findByToPlace(String toLocation);
}
