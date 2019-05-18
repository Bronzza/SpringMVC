package MateAcad.HomeWork20MVC.entities;

import MateAcad.HomeWork20MVC.listeners.ProgrammerListenerCreatedDate;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@EntityListeners(value = ProgrammerListenerCreatedDate.class)
public class CreatableEntity extends BaseEntity {
    @Column(name = "created_date")
    private Long createdDate;
}
