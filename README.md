# NinjaFinder - DropWizard edition

The ninja tech challenge implemented as a web app with [dropwizard](dropwizard.io) and hosted on [heroku](heroku.com)

App
---
App is hosted at [https://intense-citadel-89033.herokuapp.com/rest]

Metrics and health checks at [https://intense-citadel-89033.herokuapp.com/admin]

Build and Run
---
1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/ninja-finder-wizard-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`
1. To check the admin tools, enter `http://localhost:8081`
