package MateAcad.HomeWork20MVC.listeners;

import MateAcad.HomeWork20MVC.entities.Programmer;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class ProgrammerListener {
    @PrePersist
    public void prePersist(Programmer entity) {
        entity.setBirthDay(entity.getBirthDay().plusDays(1));
    }

    @PreUpdate
    public void preUpdate(Programmer entity) {
        entity.setBirthDay(entity.getBirthDay().plusDays(1));
    }
}
