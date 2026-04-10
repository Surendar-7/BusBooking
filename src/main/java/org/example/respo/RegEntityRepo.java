package org.example.respo;

import org.example.tables.RegEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RegEntityRepo extends JpaRepository<RegEntity, Long> {

   List<RegEntity> findByEmailAndPassword(String email , String password);


}
