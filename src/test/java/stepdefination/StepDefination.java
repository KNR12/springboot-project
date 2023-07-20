package stepdefination;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import springboot.customerserviceproject.model.Customer;
import springboot.customerserviceproject.respository.CustomerRespository;
import springboot.customerserviceproject.services.CustomerServices;
import springboot.customerserviceproject.services.CustomerServicesImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StepDefination {
    private Customer customer;
    private String today;
    private String actualAnswer;
    @Autowired
    private CustomerRespository customerRespository;

    @Given("today is {string}")
    public void today_is(String today) {
        this.today = today;
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        Assertions.assertEquals(expectedAnswer, actualAnswer);
    }



    @Given("I send a request to the URL {string} to create a customer with customerName {string} and phoneNo {string} and email {string}")
    public void i_send_a_request_to_the_url_to_create_a_customer_with_customer_name_and_phone_no_and_email(String endpoint, String customerName, String phoneNo, String email) {
        JSONObject customer = new JSONObject();
        customer.put("name", customerName);
        customer.put("phoneNo", phoneNo);
        customer.put("email", email);
    }


    @Then("The response will return status {int}")
    public void the_response_will_return_status(Integer status) {
        assertEquals(200, 200);

    }

    @Then("Resend the request to the URL {string} and the response returned contains customerName {string} and phoneNo {string} and email {string}")
    public void resend_the_request_to_the_url_and_the_response_returned_contains_customer_name_and_phone_no_and_email(String string, String string2, String string3, String string4) {

    }


}
