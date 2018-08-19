## Car2Go: RESTful WebService for Car Rental Service.


### Technology stack:

* Spring Boot;
* Spring Web;
* Spring Data;
* H2 / PostgreSQL database;
* Hibernate;

#####To run this application use:

```bash
mvn spring-boot:run
```

### Database Schema
![alt tag](https://drive.google.com/open?id=1l5lpPuyoXWvZgZ48YtGjJMDtrK8EwCOs)

### Use cases: 

#### Customers:
1. Listing all Customers: 
    1. GET Method.
    2. URL: [http://localhost:8080/car2go/customers](http://localhost:8080/car2go/customers)

2. Adding Customer
    1. POST Method (Content-Type: application/json).
    2. URL: [http://localhost:8080/car2go/customers](http://localhost:8080/car2go/customers)
    3. BODY:
    ```json
    {
        "firstName": "Sandeep",
        "lastName": "Gholve",
        "birthDate": "16-08-1983",
        "gender": "MALE",
        "drivingLicenseNumber": "ABCD1234",
        "drivingLicenseIssueDate": "01-01-2012"
    }
    ```
3. Updating existing Customer Information
    1. PUT Method (Content-Type: application/json).
    2. URL: [http://localhost:8080/car2go/customers/{customerId}](http://localhost:8080/car2go/customers/{customerId})
    3. BODY:
    ```json
    {
        "firstName": "Sandeep",
        "lastName": "Gholve",
        "birthDate": "16-08-1983",
        "gender": "MALE",
        "drivingLicenseNumber": "ABCD1234",
        "drivingLicenseIssueDate": "01-01-2012"
    }
    ```

4. Deleting existing Customer
       1. DELETE Method (Content-Type: application/json).
       2. URL: [http://localhost:8080/car2go/customers/{customerId}](http://localhost:8080/car2go/customers/{customerId})

#### Cars:
1. Listing all Cars: 
    1. GET Method.
    2. URL: [http://localhost:8080/car2go/cars](http://localhost:8080/car2go/cars)

2. Adding Car
    1. POST Method (Content-Type: application/json).
    2. URL: [http://localhost:8080/car2go/cars](http://localhost:8080/car2go/cars)
    3. BODY:
    ```json
    {
        "brand": "Mercedes-Benz",
        "model": "S-Klasse Limousine",
        "color": "Black",
        "mileage": 7,
        "productionYear": 2017
    }
    ```
3. Updating existing Car Information
    1. PUT Method (Content-Type: application/json).
    2. URL: [http://localhost:8080/car2go/cars/{carId}](http://localhost:8080/car2go/cars/{carId})
    3. BODY:
    ```json
    {
        "brand": "Mercedes-Benz",
        "model": "S-Klasse Limousine",
        "color": "Black",
        "mileage": 7,
        "productionYear": 2017
    }
    ```

4. Deleting existing Car
       1. DELETE Method (Content-Type: application/json).
       2. URL: [http://localhost:8080/car2go/cars/{carId}](http://localhost:8080/car2go/cars/{carId})

5. Getting Car's current location
    1. GET Method.
    2. URL: [http://localhost:8080/car2go/cars/{carId}/location](http://localhost:8080/car2go/cars/{carId}/location)

6. Updating existing Car location
    1. PUT Method (Content-Type: application/json).
    2. URL: [http://localhost:8080/car2go/cars/{carId}/location/{locationId}](http://localhost:8080/car2go/cars/{carId}/location/{locationId})
    3. BODY: EMPTY

7. Deleting Car's current location
       1. DELETE Method (Content-Type: application/json).
       2. URL: [http://localhost:8080/car2go/cars/{carId}/location](http://localhost:8080/car2go/cars/{carId}/location)

8. Getting Car's current category
    1. GET Method.
    2. URL: [http://localhost:8080/car2go/cars/{carId}/category](http://localhost:8080/car2go/cars/{carId}/category)

9. Updating existing Car category
    1. PUT Method (Content-Type: application/json).
    2. URL: [http://localhost:8080/car2go/cars/{carId}/category/{categoryId}](http://localhost:8080/car2go/cars/{carId}/category/{categoryId})
    3. BODY: EMPTY

7. Deleting Car's current category
       1. DELETE Method (Content-Type: application/json).
       2. URL: [http://localhost:8080/car2go/cars/{carId}/location](http://localhost:8080/car2go/cars/{carId}/category)

#### Car Categories:
**[Work In Progress]**
1. All CRUD operation on URL: http://localhost:8080/car2go/categories/cars
2. Also listing all Cars belong to current categories

#### Equipment Categories:
**[Work In Progress]**
1. All CRUD operation on URL: http://localhost:8080/car2go/categories/equipments

#### Locations:
**[Work In Progress]**
1. All CRUD operation on URL: http://localhost:8080/car2go/locations
2. Also listing all Cars belong to current location
