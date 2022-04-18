package by.academy_it.task10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@PrimaryKeyJoinColumn(name = "Task_ID")
public class WorkTask extends Task {
    @Column
    private String coast;


}
