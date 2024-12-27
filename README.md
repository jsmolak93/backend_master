# HW3 - Survey Backend
Authors: Russell Bisker, Jonathan Hus, John Smolak

## Overview
This project is a Spring Boot application that provides a backend for the Survey \
Application. It provides REST services (GET, POST, PUT, DELETE) to create, modify, \
and delete surveys. The surveys are persisted in a MySQL database.

## AWS Setup
The Spring Boot application requires an EC2 instance and a MySQL database.
### EC2 Instance
To create and configure the instance using the AWS Console:
- Create instance (AmazonLinux2)
- Modify security groups to allow traffic on Ports 80, 22, and 8080
- Login to the instance and run:
  - sudo yum update -y
  - sudo yum install java-21
#### Service
To create a systemd service to run the spring boot app.
- Copy utilities/survey-app.service to /etc/systemd/system on ec2 instance
- On EC2 instance:
  - sudo systemctl daemon-reload
### MySQL Database
Via the AWS Console, create an RDS instance of MySQL. Create a username and \
password, and note the endpoint. These 3 items need to be included in the \
application.properties file

To create the schema and surveys table, run utilities/create_survey_schema.sql \
on the MySQL database. (One way to do this is by using MySQLWorkbench and \
connecting to the database using the endpoint, username, and password.)

## Build and Deploy
Run the following command to build an executable jar.
- mvn package

Copy jar from target to /var/survey-app on ec2 instance and run:
- sudo systemctl enable survey-app
- sudo systemctl start survey-app
- sudo systemctl status survey-app

## Using the App
To use the app, make REST calls to /api/surveys

Here is a sample JSON that can be sent in the POST method:\
{   
"firstName": "George",\
"lastName": "Washington",\
"address": "1 Cherry Tree Drive",\
"city": "Mt Vernon",\
"state": "VA",\
"zipcode": "20202",\
"telephone": "555-999-9876",\
"email": "george@washington.com",\
"comments": "I cannot tell a lie",\
"survey_date": "2024-01-02",\
"recommendation": "VERY_LIKELY",\
"interest": "INTERNET",\
"likes": ["STUDENTS","SPORTS", "DORM_ROOMS"]
}