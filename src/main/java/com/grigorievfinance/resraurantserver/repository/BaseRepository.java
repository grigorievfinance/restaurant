package com.grigorievfinance.resraurantserver.repository;

import com.grigorievfinance.resraurantserver.util.ValidationUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Integer> {
    default T getExisted(int id) {
        return ValidationUtil.checkNotFoundWithId(findById(id), id);
    }
}
