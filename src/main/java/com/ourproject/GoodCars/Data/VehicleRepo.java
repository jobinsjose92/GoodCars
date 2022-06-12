package com.ourproject.GoodCars.Data;

import com.ourproject.GoodCars.Model.cars;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepo extends CrudRepository<cars,Long > {
}
