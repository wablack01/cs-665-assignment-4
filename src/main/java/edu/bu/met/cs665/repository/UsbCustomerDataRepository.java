/**
 * Name: Walker Black
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: UsbCustomerDataRepository.java
 * Description: This class is responsible for methods and attributes of a customer
 * data repository accessed over usb connection.
 */

package edu.bu.met.cs665.repository;

import edu.bu.met.cs665.model.Customer;
import java.util.HashMap;
import java.util.Map;

/**
 * The UsbCustomerDataRepository represents a data repository for customer
 * records which is accessed by a USB connection.
 */
public class UsbCustomerDataRepository implements CustomerData_USB {
  private final Map<Integer, Customer> customers = new HashMap<>();

  /**
   * Prints customer data for a customer with matching customerId.
   * @param customerId the customer id of the required customer
   */
  @Override
  public void printCustomer(int customerId) {
    Customer customer = customers.get(customerId);
    System.out.printf("CustomerId: %d, Name: %s", customer.getCustomerId(), customer.getName());
  }

  /**
   * Returns data for the customer with matching customerId.
   * @param customerId the customer id of the required customer
   */
  @Override
  public Customer getCustomer_USB(int customerId) {
    return customers.get(customerId);
  }

  /**
   * Adds a Customer to the repository.
   * @param customer the customer to add.
   */
  @Override
  public void addCustomer_USB(Customer customer) {
    customers.put(customer.getCustomerId(), customer);
  }
}
