package MateAcad.HomeWork20MVC.entities;

import MateAcad.HomeWork20MVC.enums.AccessRights;
import MateAcad.HomeWork20MVC.listeners.ProgrammerListener;
import MateAcad.HomeWork20MVC.listeners.ProgrammerListenerCreatedDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Table(name = "programmers")
@Entity
@Getter
@Setter
@ToString(callSuper = true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(value = ProgrammerListener.class)
public class Programmer extends CreatableEntity {
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "surname")
    private String surName;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthDay;

    @Email
    @Column(name = "email")
    private String email;

    @Enumerated (EnumType.STRING)
    @Column (name = "access_rights")
    private AccessRights accessRights;

    @Column (name = "password")
    private String password;
}
