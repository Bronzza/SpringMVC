package MateAcad.HomeWork20MVC.listeners;

import MateAcad.HomeWork20MVC.entities.CreatableEntity;

import javax.persistence.PrePersist;
import java.util.Date;

public class ProgrammerListenerCreatedDate {
    @PrePersist
    public void prePersist(CreatableEntity entity) {
        entity.setCreatedDate(new Date().getTime());
    }
}
