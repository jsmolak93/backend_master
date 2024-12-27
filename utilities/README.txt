This file describes how to create a systemd service to run the spring boot app.

Followed the instructions here:
https://docs.spring.io/spring-boot/docs/1.4.0.RC1/reference/html/deployment-install.html

- Added plugin to pom.xml to make an executable jar
- mvn package
- Copy jar to /var/survey-app on ec2 instance
- Copy survey-app.service to /etc/systemd/system on ec2 instance
- sudo systemctl enable survey-app
- sudo systemctl start survey-app
- sudo systemctl status survey-app

Might need to do:
- sudo systemctl daemon-reload