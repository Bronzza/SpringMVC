package MateAcad.HomeWork20MVC.repositories;


import MateAcad.HomeWork20MVC.entities.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface ProgrammerRepository extends JpaRepository<Programmer, Long > {
    List<Programmer> findByBirthDayAfter(LocalDate date);

    List<Programmer> findAllBySurName(String surName);

    @Query(value = "SELECT * FROM programmers " +
            "WHERE email IS NOT NULL " +
            "AND extract(MONTH FROM birthday) = :m " +
            "AND extract(DAY FROM birthday) = :d",
            nativeQuery = true)
    List<Programmer> findByMatchMonthAndMatchDay(@Param("m") int month, @Param("d") int day);
}
