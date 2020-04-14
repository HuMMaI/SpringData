package org.lviv.lgs.homework;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE University u SET u.name = :name, u.accreditationLevel = :accreditationLevel, u.numberOfStudents = :numberOfStudents, u.address = :address WHERE u.id = :id")
    void update(
            @Param("name") String name,
            @Param("accreditationLevel") int accreditationLevel,
            @Param("numberOfStudents") int numberOfStudents,
            @Param("address") String address,
            @Param("id") int id
    );
}
