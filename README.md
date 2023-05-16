# Suburb and Postcode API

This project is a Java Spring service that provides APIs for mobile clients to retrieve and add suburb and postcode combinations. The APIs include:

- An API to retrieve all suburb information.
- An API to retrieve the suburb information by id.
- An API to retrieve the suburb information by postcode.
- An API to retrieve a postcode given a suburb name.
- A secured API to add new suburb and postcode combinations.

# Usage

## Retrieving all suburb and postcode information

To retrieve all suburb and postcode information , send a GET request to the following endpoint:
GET /suburbs

## Retrieving suburb and postcode information by id

To retrieve suburb and postcode information , send a GET request to the following endpoint:
GET /suburbs/{id}
Replace {id} with the id you want to search for.

## Retrieving suburb information by postcode

To retrieve suburb information by postcode, send a GET request to the following endpoint:
GET /suburbs/{postcode}
Replace {postcode} with the postcode you want to search for. The API will return a JSON response with information about the suburb(s) associated with the postcode.

## Retrieving postcode by suburb name

To retrieve a postcode given a suburb name, send a GET request to the following endpoint:

GET /suburbs/{suburb}
Replace {suburb} with the suburb name you want to search for. The API will return a JSON response with the postcode(s) associated with the suburb.

## Adding new suburb and postcode combinations

To add a new suburb and postcode combination, send a POST request to the following endpoint:

POST /suburbs/createSuburbs
Include a JSON body with the following structure:

{
"suburb": "New Suburb Name",
"postcode": " New Postcode"
}
The API will add the new combination to the database and return a JSON response with the new data.

# Security

The API for adding new combinations is secured by requiring authentication and authorization. Users must provide valid credentials in order to access the API(editor or viewer).

# Reusability

This project has been developed with reusability in mind. The code is designed to be modular and follow best practices and industry standards, making it easy to adapt for use in other projects.

## FUTURE GOALS

Testing for controller / service layers
