package webservice.store;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "CarStore")
public interface CarStore {
    @WebMethod
    void addCar(@WebParam(name = "car") Car car);
    @WebMethod
    Car getCar(String producer, String model);
    @WebMethod
    void deleteCar(String producer, String model);
    @WebMethod
    void updateCar(@WebParam(name = "car") Car newCar);
}
