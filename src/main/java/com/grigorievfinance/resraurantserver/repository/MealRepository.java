package com.grigorievfinance.resraurantserver.repository;

import com.grigorievfinance.resraurantserver.model.Meal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface MealRepository extends BaseRepository<Meal> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Meal m WHERE m.id=:id AND m.user.id=:userId")
    int delete(int id, int userId);

    @Query("SELECT m FROM Meal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC")
    List<Meal> getAll(int userId);

    @Query("SELECT m FROM Meal m WHERE m.id = :id and m.user.id = :userId")
    Optional<Meal> get(int id, int userId);
}
