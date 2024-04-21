package app.controller;

import app.domain.Cars;
import app.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarsController {


    private CarsService service;

    public CarsController(CarsService service) {
        this.service = service;
    }

    public Cars getById(Long id) {
        return service.getById(id);
    }
}
