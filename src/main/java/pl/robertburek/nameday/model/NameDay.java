package pl.robertburek.nameday.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "namedays")
public class NameDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dayMonth;

//    @OneToOne(fetch = FetchType.LAZY)
//    private Customer customer;

    public NameDay() {
    }

    public NameDay(String name, String nameDay) {
        this.name = name;
        this.dayMonth = nameDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayMonth() {
        return dayMonth;
    }

    public void setDayMonth(String dayMonth) {
        this.dayMonth = dayMonth;
    }
}
