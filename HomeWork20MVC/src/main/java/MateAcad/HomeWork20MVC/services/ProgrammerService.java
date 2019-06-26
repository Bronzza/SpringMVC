package MateAcad.HomeWork20MVC.services;

import MateAcad.HomeWork20MVC.entities.Programmer;
import MateAcad.HomeWork20MVC.repositories.ProgrammerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProgrammerService {

    private ProgrammerRepository programmerRepository;

    public List<Programmer> getAllProgrammers() {
        return programmerRepository.findAll();
    }

    public List<Programmer> getProgrammerBySurName(String surname) {
        return programmerRepository.findAllBySurName(surname);
    }

    public void saveProgrammer(Programmer programmer) {
        programmerRepository.save(programmer);
    }

    public List<Programmer> findByDayAndMonthOfBirthday(int month, int day) {
        return programmerRepository.findByMatchMonthAndMatchDay(month, day);
    }

    public void deleteProgrammerById(Long id) {
        programmerRepository.deleteById(id);
    }

    public Programmer findProgrammerById(Long id) {
        return programmerRepository.findById(id).orElse(null);
    }
}
