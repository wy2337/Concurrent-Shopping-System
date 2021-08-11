Here we are designing a concurrent shopping system to handle discounting products. It must be able to handle spiking traffic, since discounted products will have many users trying to order it at once. We will have to use mutex locks to ensure concistency in our database, and we will use RocketMQ as a queue for our orders. 

To accomplish this we will use Java Spring Boot, with a MyBatis ORM and a MySQL database. For a cache will we use Redis. We are using JUnit to write our tests. 
Later we will also implement a frontend. 
