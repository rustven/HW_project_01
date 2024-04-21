package app.repository;

import app.domain.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CarsRepositoryMap implements CarsRepository{


    private Map<Long, Cars> database  = new HashMap<>();

    public CarsRepositoryMap() {

        database.put(1L, new Cars (1L,"BMW", "X5", 2020));
        database.put(2L, new Cars (2L,"Audi", "A4", 2019));
        database.put(3L, new Cars (3L,"Mercedes", "MLS", 2021));
        database.put(4L, new Cars (4L,"Ford", "S-Max", 2019));
        database.put(5L, new Cars (5L,"Skoda", "Kodiaq", 2022));
    }

    @Override
    public Cars getById(Long id) {
        return database.get(id);
    }
}
