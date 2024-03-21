/**
 * Name: Walker Black
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: TestDataAccess.java
 * Description: This class is responsible for testing the data access methods of the application
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.adapter.UsbToHttpsAdapter;
import edu.bu.met.cs665.model.Customer;
import edu.bu.met.cs665.repository.CustomerData_HTTPS;
import edu.bu.met.cs665.repository.CustomerData_USB;
import edu.bu.met.cs665.repository.HttpsCustomerDataRepository;
import edu.bu.met.cs665.repository.UsbCustomerDataRepository;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * TestDataAccess class tests the data access methods of each component
 */
public class TestDataAccess {

  private final int CUSTOMER_ID = 1;
  private final String CUSTOMER_NAME = "John";
  private final Customer customer = new Customer(CUSTOMER_ID, CUSTOMER_NAME);
  private final String customerString = String.format("CustomerId: %d, Name: %s", CUSTOMER_ID, CUSTOMER_NAME);

  public TestDataAccess() {
  }

  /**
   * Test the printCustomer methods of CustomerData_USB and CustomerData_HTTP
   * repositories by capturing the standard output
   */
  @Test
  public void testPrintCustomer() {
    //set up streams to test print function
    PrintStream stdOut = System.out;
    ByteArrayOutputStream printedContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(printedContent));

    CustomerData_USB usbRepository = new UsbCustomerDataRepository();
    CustomerData_HTTPS httpsRepository = new HttpsCustomerDataRepository();
    usbRepository.addCustomer_USB(customer);
    httpsRepository.addCustomer_HTTPS(customer);

    usbRepository.printCustomer(CUSTOMER_ID);
    Assert.assertEquals(customerString, printedContent.toString());
    printedContent.reset();

    httpsRepository.printCustomer(CUSTOMER_ID);
    Assert.assertEquals(customerString, printedContent.toString());

    //restore output stream
    System.setOut(stdOut);
  }

  /**
   * Test that getCustomer_USB() and getCustomer_HTTPS() return
   * the correct from their respective repositories
   */
  @Test
  public void testGetCustomer() {
    CustomerData_USB usbRepository = new UsbCustomerDataRepository();
    CustomerData_HTTPS httpsRepository = new HttpsCustomerDataRepository();
    usbRepository.addCustomer_USB(customer);
    httpsRepository.addCustomer_HTTPS(customer);

    Customer usbCustomer = usbRepository.getCustomer_USB(CUSTOMER_ID);
    Customer httpsCustomer = httpsRepository.getCustomer_HTTPS(CUSTOMER_ID);

    Assert.assertSame(customer, usbCustomer);
    Assert.assertSame(customer, httpsCustomer);
  }

  /**
   * Test that the adapter gets and prints correct customer data
   * using the USB interface and that the adapter is routing data
   * to the correct HTTPS repository
   */
  @Test
  public void testAdapter() {
    //set up streams to test print function
    PrintStream stdOut = System.out;
    ByteArrayOutputStream printedContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(printedContent));

    CustomerData_HTTPS httpsRepository = new HttpsCustomerDataRepository();
    CustomerData_USB adapter = new UsbToHttpsAdapter(httpsRepository);

    adapter.addCustomer_USB(customer);
    adapter.printCustomer(CUSTOMER_ID);
    Customer adapterCustomer = adapter.getCustomer_USB(CUSTOMER_ID);
    Customer httpsCustomer = httpsRepository.getCustomer_HTTPS(CUSTOMER_ID);

    Assert.assertEquals(customerString, printedContent.toString());
    Assert.assertSame(customer, adapterCustomer);
    Assert.assertSame(adapterCustomer, httpsCustomer);

    //restore output stream
    System.setOut(stdOut);
  }
}
