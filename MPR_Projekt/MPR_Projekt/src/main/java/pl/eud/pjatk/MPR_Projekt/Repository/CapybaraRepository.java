package pl.eud.pjatk.MPR_Projekt.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.eud.pjatk.MPR_Projekt.model.Capybara;

import java.util.List;

@Repository // Komunikacaj z bazą danych
//@Component
public interface CapybaraRepository extends CrudRepository<Capybara, Long> {

    public List<Capybara> findByName(String name);

    public List<Capybara> findByColor(String color);

}
