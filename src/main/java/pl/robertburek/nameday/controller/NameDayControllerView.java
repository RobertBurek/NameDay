package pl.robertburek.nameday.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.robertburek.nameday.model.NameDay;
import pl.robertburek.nameday.repository.NameDayRepository;

import java.util.List;
import java.util.stream.Collectors;

import static pl.robertburek.nameday.NamedayApplication.nameDays;

/**
 * Created by Robert Burek
 */

@Controller
@Slf4j
public class NameDayControllerView {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    NameDayRepository nameDayRepository;

    @GetMapping("/loginOpenID")
    public String getLoginOpenID() {
        return "redirect:/nameDay";
    }

    @GetMapping("/nameDay")
    public String getAllNameDays(Model model) {
        nameDays = (List<NameDay>) nameDayRepository.findAll();
        model.addAttribute("nameDays", nameDays);
        model.addAttribute("nameDayNew", new NameDay());
        model.addAttribute("nameDayFind", new NameDay());
        return "nameday";
    }

    @GetMapping("/nameDay/find")
    public String getAllFind(Model model) {

        model.addAttribute("nameDays", nameDays);
        model.addAttribute("nameDayNew", new NameDay());
        model.addAttribute("nameDayFind", new NameDay());
        return "nameday";
    }

    @PostMapping("/nameDay")
    public String postFindNameDay(@ModelAttribute NameDay nameDayFind, Model model) {
        log.info("Szukać będziemy: " + nameDayFind.getName());
        nameDays = (List<NameDay>) nameDayRepository.findAll();
        if (!nameDayFind.getName().equals("")) {
            nameDays = nameDays.stream()
                    .filter(nameDay -> (nameDay.getName()).equals(nameDayFind.getName()))
                    .collect(Collectors.toList());
        }
        log.info("Lista znalezionych imion: " + nameDays.toString());
        return "redirect:/nameDay/find#position";
    }

    @PostMapping("/nameDay/save")
    public String saveNameDay(@ModelAttribute NameDay nameDayNew) {
        nameDayRepository.save(nameDayNew);
        log.info("Nowe dane: Imie = " + nameDayNew.getName() + ", data imienin = " + nameDayNew.getDayMonth());
        log.info(nameDayNew.toString());
        nameDays = (List<NameDay>) nameDayRepository.findAll();
        return "redirect:/nameDay/find#position";
    }

    @GetMapping("/nameDay/del")
    public String deleteNameDay(@RequestParam Long index) {
        log.info("Usuwanie danych: " + nameDayRepository.findById(index).get());
        nameDayRepository.deleteById(index);
        nameDays = (List<NameDay>) nameDayRepository.findAll();
        return "redirect:/nameDay/find#position";
    }

    @GetMapping("/nameDay/edit")
    public String editNameDay(@RequestParam Long index, Model model) {
        nameDays = (List<NameDay>) nameDayRepository.findAll();
        NameDay modifiedNameDay = nameDayRepository.findById(index).get();
        List<NameDay> newListNameDays =
                nameDays.stream().filter(nameDay -> (nameDay.getName()).equals(modifiedNameDay.getName())).collect(Collectors.toList());
        log.info("Lista znalezionych imion: " + newListNameDays.toString());
        model.addAttribute("nameDays", newListNameDays);
        model.addAttribute("nameDayNew", modifiedNameDay);
        model.addAttribute("nameDayFind", new NameDay());
        return "namedayedit";
    }

    @PostMapping("/nameDay/edit")
    public String findNameDay(@ModelAttribute NameDay nameDayFind, Model model) {
        log.info("Szukać będziemy: " + nameDayFind.getName());
        nameDays = (List<NameDay>) nameDayRepository.findAll();
        List<NameDay> newListNameDays;
        if (!nameDayFind.getName().equals("")) {
            newListNameDays = nameDays.stream()
                    .filter(nameDay -> (nameDay.getName()).equals(nameDayFind.getName()))
                    .collect(Collectors.toList());
        } else {
            newListNameDays = nameDays;
        }
        log.info("Lista znalezionych imion: " + newListNameDays.toString());
        model.addAttribute("nameDays", newListNameDays);
        model.addAttribute("nameDayNew", nameDayFind);
        model.addAttribute("nameDayFind", new NameDay());
        return "namedayedit";
    }

    @PostMapping("/nameDay/save/edit")
    public String saveNameDayEdit(@ModelAttribute NameDay nameDayNew) {
        nameDayRepository.save(nameDayNew);
        log.info("Nowe dane: Imie = " + nameDayNew.getName() + ", data imienin = " + nameDayNew.getDayMonth());
        log.info(nameDayNew.toString());
        nameDays = (List<NameDay>) nameDayRepository.findAll();
        return "redirect:/nameDay/edit?index=" + nameDayNew.getId();
    }

}
