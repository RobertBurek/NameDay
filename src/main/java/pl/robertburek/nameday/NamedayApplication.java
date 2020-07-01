package pl.robertburek.nameday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.robertburek.nameday.model.NameDay;

import java.util.List;

@SpringBootApplication
public class NamedayApplication {

    public static List<NameDay> nameDays;

    public static void main(String[] args) {
        SpringApplication.run(NamedayApplication.class, args);
    }

//    public NamedayApplication() {
//        this.nameDays = new ArrayList<>();
//        nameDays.add(new NameDay("Roberta", "17-04"));
//        nameDays.add(new NameDay("Moniki", "04-05"));
//        nameDays.add(new NameDay("Moniki", "18-01"));
//        nameDays.add(new NameDay("Moniki", "27-08"));
//        nameDays.add(new NameDay("Moniki", "10-09"));
//        nameDays.add(new NameDay("Roberta", "21-02"));
//        nameDays.add(new NameDay("Roberta", "27-03"));
//        nameDays.add(new NameDay("Roberta", "29-04"));
//        nameDays.add(new NameDay("Roberta", "13-05"));
//        nameDays.add(new NameDay("Roberta", "07-06"));
//        nameDays.add(new NameDay("Roberta", "18-07"));
//        nameDays.add(new NameDay("Roberta", "17-09"));
//        nameDays.add(new NameDay("Roberta", "01-11"));
//        nameDays.add(new NameDay("Jerzego", "27-01"));
//        nameDays.add(new NameDay("Jerzego", "14-02"));
//        nameDays.add(new NameDay("Jerzego", "19-02"));
//        nameDays.add(new NameDay("Jerzego", "20-04"));
//        nameDays.add(new NameDay("Jerzego", "23-04"));
//        nameDays.add(new NameDay("Jerzego", "27-07"));
//        nameDays.add(new NameDay("Jerzego", "24-08"));
//        nameDays.add(new NameDay("Jerzego", "20-10"));
//        nameDays.add(new NameDay("Jerzego", "02-11"));
//    }

}
