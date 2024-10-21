package pl.eud.pjatk.MPR_Projekt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // <- 1
public class Capybara {
    @Id // <- 2
    @GeneratedValue(strategy = GenerationType.AUTO) // <- 3
    private Long id;
    private String name;
    private String color;

    public Capybara(String Name, String color){
        this.name = name;
        this.color = color;
    }

    public Capybara(){} // <- 5


    public Long getId() {
        return id;
    } // <- 4

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void IteColor(String color) {
        this.color = color;
    }


    public void setColor(String color) {
        this.color = color;
    }
}

