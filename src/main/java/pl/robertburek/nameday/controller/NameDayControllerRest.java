package pl.robertburek.nameday.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.robertburek.nameday.model.NameDay;
import pl.robertburek.nameday.repository.NameDayRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class NameDayControllerRest {

    @Autowired
    NameDayRepository nameDayRepository;

    @GetMapping("/nameDayRest")
    public List<NameDay> getAll() {
        return (List<NameDay>) nameDayRepository.findAll();
    }

    @GetMapping("/nameDayRest/{name}")
    public List<NameDay> getNameAll(@PathVariable String name) {
        log.info("@PathVariable - przekazany parametr: " + name);
        return ((List<NameDay>) nameDayRepository.findAll())
                .stream()
                .filter(nameDay -> (nameDay.getName()).equals(name))
                .collect(Collectors.toList());
    }

    @GetMapping("/nameDayRest/id/{id}")
    public NameDay getNameById(@PathVariable Long id) {
        log.info("@PathVariable - przekazany parametr: " + id);
        return nameDayRepository.findById(id).get();
    }

    @PostMapping("/nameDayRest/save")
    public void saveNameDay(@RequestBody NameDay nameDay) {
        nameDayRepository.save(nameDay);
    }

    @DeleteMapping("/nameDayRest/delete/{index}")
    public void deleteNameDay(@PathVariable Long index) {
        nameDayRepository.deleteById(index);
    }

}
