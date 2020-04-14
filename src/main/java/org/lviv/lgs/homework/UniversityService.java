package org.lviv.lgs.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {
    private UniversityRepository universityRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public University save(University university){
        return universityRepository.save(university);
    }

    public University findById(int id){
        Optional<University> university = universityRepository.findById(id);

        if (university.isPresent()){
            return university.get();
        } else {
            String message = String.format("Can't find university with id = %d", id);
            throw new RuntimeException(message);
        }
    }

    public List<University> findAll(){
        return universityRepository.findAll();
    }

    public void deleteById(int id){
        universityRepository.deleteById(id);
    }

    public void update(int id, University university){
        universityRepository.update(
                university.getName(),
                university.getAccreditationLevel(),
                university.getNumberOfStudents(),
                university.getAddress(),
                id
        );
    }
}
