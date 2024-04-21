package app.domain;

import java.util.Objects;

public class Cars {

    private Long id;
    private String brand;
    private String model;
    private int year;
    private String article;

    public Cars(Long id, String brand, String model, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return year == cars.year && Objects.equals(id, cars.id) && Objects.equals(brand, cars.brand) && Objects.equals(model, cars.model) && Objects.equals(article, cars.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, year, article);
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return String.format("Автомобиль: %s%nМарка: %s%nГод выпуска: - %dг.%n%s",
                brand, model, year, article);
    }
}

