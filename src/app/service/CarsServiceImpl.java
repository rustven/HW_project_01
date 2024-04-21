package app.service;

import app.domain.Cars;
import app.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class CarsServiceImpl implements CarsService{

//    @Autowired
    private String articlePrefix ;
    private CarsRepository repository;

    public CarsServiceImpl(
            @Value(("${article.prefix2}")) String articlePrefix,
            @Qualifier("carsRepositoryMap") CarsRepository repository) {
        this.repository = repository;
        this.articlePrefix = articlePrefix;
    }

    @Override
    public Cars getById(Long id) {
        Cars cars = repository.getById(id);
        assignCars(cars);
        return cars;
    }

    @Override
    public void assignCars(Cars cars) {
        String article = String.format("%S %C-%d",
                articlePrefix,
                cars.getBrand().charAt(0),
                cars.getYear());
        cars.setArticle(article);
    }
}
