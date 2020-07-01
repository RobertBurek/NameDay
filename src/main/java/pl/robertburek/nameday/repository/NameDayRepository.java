package pl.robertburek.nameday.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.robertburek.nameday.model.NameDay;

@Repository
public interface NameDayRepository extends CrudRepository<NameDay,Long> {
}
