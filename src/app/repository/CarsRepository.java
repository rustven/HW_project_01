package app.repository;

import app.domain.Cars;

public interface CarsRepository {

    Cars getById(Long id);
}
