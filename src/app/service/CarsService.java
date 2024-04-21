package app.service;

import app.domain.Cars;

public interface CarsService {

    Cars getById(Long id);

    void assignCars(Cars cars);
}
