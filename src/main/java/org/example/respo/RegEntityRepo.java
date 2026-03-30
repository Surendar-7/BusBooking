package org.example.respo;

import org.example.tables.RegEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegEntityRepo extends JpaRepository<RegEntity, Long> {

    RegEntity findByUserName(String UserName);
    RegEntity findByEmail(String Email);
    RegEntity findByPassword(String Password);
    RegEntity findByEmailAndPassword(String email , String password);
}
