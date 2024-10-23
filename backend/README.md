# Sales APP Spring Boot + Java 17

## Backend Java

This project is a simple API with two methods GET:

The first method list data from a database.

The second method send notifications through Twilio
https://www.twilio.com/en-us

## Twilio Config
````
1- Create an account on https://www.twilio.com/en-us'
2- Get a number in the panel https://console.twilio.com/

application.properties

twilio.sid=${TWILIO_SID}
twilio.key=${TWILIO_KEY}
twilio.phone.from=${TWILIO_PHONE_FROM}
twilio.phone.to=${TWILIO_PHONE_TO}

````
## Frontend Vite + React:

````
On your local machine open the project
inside the folder frontend open new terminal

In your project, you can install the vite CLI using:

npm install -D vite

Run the project:

npm run dev  

The index.html will be served on http://localhost:5173
````

https://vite.dev/guide/