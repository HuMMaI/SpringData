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
    void updateById(
            @Param("name") String name,
            @Param("accreditationLevel") int accreditationLevel,
            @Param("numberOfStudents") int numberOfStudents,
            @Param("address") String address,
            @Param("id") int id
    );

    @Modifying
    @Transactional
    @Query("UPDATE University u SET u.name = :name WHERE u.id = :id")
    void updateNameById(@Param("name") String name, @Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE University u SET u.accreditationLevel = :accreditationLevel WHERE u.id = :id")
    void updateAccreditationLevelById(@Param("accreditationLevel") int accreditationLevel, @Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE University u SET u.numberOfStudents = :numberOfStudents WHERE u.id = :id")
    void updateNumberOfStudentsById(@Param("numberOfStudents") int numberOfStudents, @Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE University u SET u.address = :address WHERE u.id = :id")
    void updateAddressById(@Param("address") String address, @Param("id") int id);

    @Query("SELECT u.name AS name, u.numberOfStudents AS numberOfStudents FROM University u WHERE u.id = :id")
    UniversityDto getNameAndNumberOfStudentsById(@Param("id") int id);
}
