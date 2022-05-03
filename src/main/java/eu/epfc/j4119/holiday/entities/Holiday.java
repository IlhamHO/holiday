package eu.epfc.j4119.holiday.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employee;
    private String start;
    private String end;
    private String status;
}
