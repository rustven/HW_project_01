package app.repository;

import app.domain.Cars;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;

@Primary
@Repository

public class CarsRepositoryFile implements CarsRepository{
    @Override
    public Cars getById(Long id) {
        try(BufferedReader reader = new BufferedReader(new FileReader("database.txt"))) {
                return reader.lines()
                        .filter(x -> x.split(";",2)[0].equals(id.toString()))
                        .limit(1)
                        .map(x -> {
                            String[] elem = x.split(";");
                            int year = Integer.parseInt(elem[3]);
                            return new Cars(id, elem[1], elem[2], year);
                        })
                        .findFirst()
                        .orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
