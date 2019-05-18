package MateAcad.HomeWork20MVC.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Programmer extends CreatableEntity {
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "surname")
    private String surName;

    @Column (name = "birthday")
    private LocalDate birthDay;

   @Email
   @Column (name = "email")
    private String email;
}
