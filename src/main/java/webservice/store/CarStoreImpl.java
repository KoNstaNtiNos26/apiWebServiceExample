package webservice.store;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebService(endpointInterface = "webservice.store.CarStore", serviceName = "CarStoreImpl")
@Component
public class CarStoreImpl implements CarStore {

    @Autowired
    private DataSource dataSource;

    @Override
    public void addCar(Car car) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            System.out.println(dataSource);
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("insert into carstore (yearold, producer, model, price) values (?, ?, ?, ?)");
            statement.setInt(1, car.getYear());
            statement.setString(2, car.getProducer());
            statement.setString(3, car.getModel());
            statement.setInt(4, car.getPrice());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    @Override
    public Car getCar(String producer, String model) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            System.out.println(dataSource);
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("select * from carstore where producer = ? and model = ?");
            statement.setString(1, producer);
            statement.setString(2, model);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public void deleteCar(String producer, String model) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            System.out.println(dataSource);
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("delete from carstore where producer = ? and model = ?");
            statement.setString(1, producer);
            statement.setString(2, model);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    @Override
    public void updateCar(Car newCar) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            System.out.println(dataSource);
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("update carstore set yearold = ?, producer = ?, model = ?, price = ?");
            statement.setInt(1, newCar.getYear());
            statement.setString(2, newCar.getProducer());
            statement.setString(3, newCar.getModel());
            statement.setInt(4, newCar.getPrice());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
