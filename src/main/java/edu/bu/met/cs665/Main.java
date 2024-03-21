/**
 * Name: Walker Black
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: Main.java
 * Description: This class is the entry point to the application.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.adapter.UsbToHttpsAdapter;
import edu.bu.met.cs665.model.Customer;
import edu.bu.met.cs665.repository.CustomerData_HTTPS;
import edu.bu.met.cs665.repository.CustomerData_USB;
import edu.bu.met.cs665.repository.HttpsCustomerDataRepository;
import edu.bu.met.cs665.repository.UsbCustomerDataRepository;

/**
 * This is the Main class.
 */
public class Main {

  /**
   * A main method to run examples.
   */
  public static void main(String[] args) {
    Customer customer = new Customer(1, "Test");
    CustomerData_USB usbCustomerDataRepository = new UsbCustomerDataRepository();
    CustomerData_HTTPS httpsCustomerDataRepository = new HttpsCustomerDataRepository();
    CustomerData_USB usbToHttpsAdapter = new UsbToHttpsAdapter(httpsCustomerDataRepository);

    usbCustomerDataRepository.addCustomer_USB(customer);
    httpsCustomerDataRepository.addCustomer_HTTPS(customer);

    Customer usbCustomer =  usbCustomerDataRepository.getCustomer_USB(customer.getCustomerId());
    Customer httpsCustomer = httpsCustomerDataRepository.getCustomer_HTTPS(customer.getCustomerId());
    Customer adapterCustomer = usbToHttpsAdapter.getCustomer_USB(customer.getCustomerId());

    System.out.println(customer.equals(usbCustomer)
            && customer.equals(httpsCustomer)
            && customer.equals(adapterCustomer)
    );
  }
}
