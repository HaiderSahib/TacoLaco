# TacoLaco order web service

The service receive a JSON array with the order list and return the order total


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them
1. IntelliJ IDEA with Spring Boot
2. Tomcat 9 (to deploy the war file)
3. Postman (to test the deployed war file)

### Installing

1. Clone the project source code to your local machine
2. From IntelliJ, click on File->Open and select the project folder 

## Running the tests

1. To run the test, right click on the project name and select "Run 'All Tests'"
2. To test different values, change the tacos name or quantities or add more orders in OrderControllerTest under test package as shown below:

```
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Beef Taco", 2));
        orderList.add(new Order("Chorizo Taco", 1));
```

## Deployment

1. To generate a war file, from IntelliJ, open Maven panel, expand Lifecycle, right click on package then select Run Maven Build
2. The war file will be created under target folder
3. Deploy the war file into Tomacat using Manager App


## Testing the deployed war file using Postman

1. Open Postman
2. Paste the url http://localhost:8080/tacolacowebservice-0.0.1-SNAPSHOT/getOrderTotal/ into the request field
3. Selec Post method
4. Click on Body tap
5. Select raw and JSON
6. Paste the following sample request data

```
[
    {
        "name": "Chicken Taco",
        "quantity": 2
    },
    {
        "name": "Veggie Taco",
        "quantity": 3
    }
]
```
7. Click on Send
8. The response body should display 10.80
