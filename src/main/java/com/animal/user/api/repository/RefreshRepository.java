package com.animal.user.api.repository;

import com.animal.user.api.model.Refresh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RefreshRepository extends JpaRepository<Refresh, Long> {

    Boolean existsByRefresh(String Refresh);

    @Transactional
    void deleteByRefresh(String Refresh);

}
