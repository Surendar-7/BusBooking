package org.example.respo;

import org.example.tables.RegEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RegEntityRepo extends JpaRepository<RegEntity, Long> {

//    RegEntity findByUsername(String username);
//    RegEntity findByEmail(String email);
//    RegEntity findByPassword(String password);
   List<RegEntity> findByusername(String username);

   List<RegEntity> findByEmailAndPassword(String email , String password);


}
