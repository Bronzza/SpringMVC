package MateAcad.HomeWork20MVC.services;

import MateAcad.HomeWork20MVC.entities.Programmer;
import MateAcad.HomeWork20MVC.repositories.ProgrammerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProgrammerService {

    ProgrammerRepository programmerRepository;

    public List<Programmer> getAllProgrammers(){
       return programmerRepository.findAll();
    }

    public List<Programmer> getProgrammerBySurName(String surname){
        return programmerRepository.findAllBySurName(surname);
    }

    public void saveProgrammer (Programmer programmer){
        programmerRepository.save(programmer);
    }

    public List<Programmer> findByDayAndMonthOfBirthday(int month, int day){
        return programmerRepository.findByMatchMonthAndMatchDay(month, day);
    }

    public void deleteProgrammerById(Long id){
        programmerRepository.deleteById(id);
    }

    public Programmer findProgrammerById(Long id){
        Optional<Programmer> programmer = programmerRepository.findById(id);
        return (programmer.orElse(null));
    }


}
