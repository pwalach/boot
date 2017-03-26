package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Car;

public interface CarService extends Serializable {

	Car findByBrandAndColorAllIgnoringCase(String brand, String color);

	Car save(Car car);

	List<Car> findFirst10ByColor(String color);

	Page<Car> findAll(Pageable pageable);

}