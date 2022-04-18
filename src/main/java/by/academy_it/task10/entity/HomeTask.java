package by.academy_it.task10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@DiscriminatorValue("H")
public class HomeTask extends Task {
    @Column
    private String startDate;
    @Column
    private String endDate;

    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "executant_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "executant_surname")),
    })
    @Embedded
    Person executantPerson;

    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "cheking_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "cheking_surname")),
    })
    @Embedded
    Person chekingPerson;

}
