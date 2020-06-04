# api-server

Spring boot project

It supports a query language for JSON [Jmespath](http://jmespath.org/), just like AWS CLI.



## Project structure

The project tries to organize things around *Features*, Not Roles.

* Roles

  ```
  ├── controler
  |   ├── VenueController.java
  |   ├── CustomerController.java
  |   └── EventsController.java
  ├── service
  |   ├── VenueService.java
  |   ├── CustomerService.java
  |   └── EventsService.java
  ├── repositories
  |   ├── VenueRepository.java
  |   ├── CustomerRepository.java
  |   └── EventsRepository.java
  ```  
 To understand how the venue endpoint works, you have to open up three different directories.
 
 Instead of this, the project is being organized around features. It makes understanding a lot easier:
 
 * Features
   ```
   ├── venue
   |   ├── VenueController.java
   |   ├── VenueService.java
   |   └── VenueRepository.java
   ├── customer
   |   ├── CustomerController.java
   |   ├── CustomerService.java
   |   └── CustomerRepository.java
   ├── events
   |   ├── EventController.java
   |   ├── EventsService.java
   |   └── EventsRepository.java
   ```  
