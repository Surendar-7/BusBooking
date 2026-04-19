package org.example.respo;

import org.example.tables.seatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface seatRepo extends JpaRepository<seatEntity, Long> {

//    List<seatEntity> findBySeatNoAndBusId(String seatNo, String busId);

    Optional<seatEntity> findBySeatNoAndBusId(String seatNo, String busId);

    seatEntity findBySeatNo(String seatNo);
}
