package pl.eud.pjatk.MPR_Projekt.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.eud.pjatk.MPR_Projekt.model.Capybara;
import pl.eud.pjatk.MPR_Projekt.services.CapybaraService;

import java.util.List;
import java.util.Optional;


@RestController
public class MyRestController {

    private CapybaraService capybaraService;

    @Autowired
    public MyRestController(CapybaraService capybaraService) {
        this.capybaraService = capybaraService;

    }
    @GetMapping("capybara/all")
    public List<Capybara> getAll() {
        return this.capybaraService.getCapybaraList();
    }

    @GetMapping("capybara/{id}")
    public Optional<Capybara> getById(@PathVariable Long id){
        return this.capybaraService.getCapybaraById(id);
    }

    @GetMapping("capybara/name/{name}")
    public List<Capybara> getByName(@PathVariable String name){
        return this.capybaraService.getCapybaraByName(name);
    }

    @GetMapping("capybara/color/{color}")
    public List<Capybara> getByColor(@PathVariable String color){
        return this.capybaraService.getCapybaraByColor(color);
    }

    @PostMapping
    public void create(@RequestBody Capybara capybara){
        this.capybaraService.createCapybara(capybara);
    }

    @DeleteMapping("capybara/{id}")
    public void delete(@PathVariable int id){
        this.capybaraService.deleteCapybaraById((long) id);
    }

    @PatchMapping("/{id}")
    public void ubdate(@PathVariable int id, @RequestBody Capybara capybara) {
        this.capybaraService.updateCapybara((long) id, capybara);
    }

}
