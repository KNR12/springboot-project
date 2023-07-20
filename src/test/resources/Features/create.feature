Feature: Customer Management

Scenario: Add new Customer for products
  Given I send a request to the URL "/create" to create a customer with customerName "konda" and phoneNo "9703934325" and email "konda@gmail.com"
  Then The response will return status 201
  And Resend the request to the URL "/create" and the response returned contains customerName "konda" and phoneNo "9703934325" and email "konda@gmail.com"

Feature: Send request to get the lead queue

  Scenario: Get all leads
    Given There are getting leads from lead queue
    When I request to get lead queue to "http://localhost:8080/api/v1/crm/applications"
    Then response will return status code 200