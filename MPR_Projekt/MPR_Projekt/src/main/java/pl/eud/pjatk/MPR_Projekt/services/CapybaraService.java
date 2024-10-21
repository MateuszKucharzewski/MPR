package pl.eud.pjatk.MPR_Projekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.eud.pjatk.MPR_Projekt.Repository.CapybaraRepository;
import pl.eud.pjatk.MPR_Projekt.model.Capybara;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CapybaraService {

    private CapybaraRepository capybaraRepository;


    List<Capybara> capybaraList = new ArrayList<>();
    @Autowired
    public CapybaraService(CapybaraRepository repository) {
        this.capybaraRepository = repository;

        this.capybaraRepository.save(new Capybara("Michał", "brown"));
        this.capybaraRepository.save(new Capybara("Bartosz", "gray"));
        this.capybaraRepository.save(new Capybara("Marcel", "beige"));
    }

    public List<Capybara> getCapybaraByName(String name) {
        return this.capybaraRepository.findByName(name);
    }

    public List<Capybara> getAllCapybaras() {
        return (List<Capybara>) this.capybaraRepository.findAll();
    }

    public List<Capybara> getCapybaraList() {
        return this.capybaraList;
    }

    public void createCapybara(Capybara capybara) {
        this.capybaraRepository.save(capybara);
    }

    public void deleteCapybaraById(Long id) {
        this.capybaraRepository.deleteById(id);
    }

    public void updateCapybara(Long id, Capybara capybara) {
        Optional<Capybara> existingCapybara = this.capybaraRepository.findById(id);
        if (existingCapybara.isPresent()) {
            Capybara updatedCapybara = existingCapybara.get();
            updatedCapybara.setName(capybara.getName());
            updatedCapybara.setColor(capybara.getColor());
            // Set other fields as needed
            this.capybaraRepository.save(updatedCapybara);
        }
    }

    public Optional<Capybara> getCapybaraById(Long id) {
        return this.capybaraRepository.findById(id);
    }

    public List<Capybara> getCapybaraByColor(String color) {
        return this.capybaraRepository.findByColor(color);
    }
}