package client;

import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import webservice.store.Car;
import webservice.store.CarStore;

public class Client {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.getFeatures().add(new LoggingFeature());
        factory.setAddress("http://localhost:8080/ws/store");
        CarStore client = (CarStore)factory.create(CarStore.class);
        Car car = new Car();
        car.setModel("model");
        car.setYear(1989);
        car.setPrice(20000);
        car.setProducer("lada");
        client.addCar(car);
    }
}
