package com.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.app.customer.service.CustomerCreateService;
import com.app.customer.service.CustomerLoginService;
import com.app.customer.service.CustomerSearchServices;
import com.app.customer.service.CustomerServicePlaceOrder;
import com.app.customer.service.CustomerUpdateStatusService;
import com.app.customer.service.CustomerViewOrderService;
import com.app.customer.service.impl.CustomerCreateServiceImpl;
import com.app.customer.service.impl.CustomerLoginServiceImpl;
import com.app.customer.service.impl.CustomerSearchServicesImpl;
import com.app.customer.service.impl.CustomerServicePlaceOrderImpl;
import com.app.customer.service.impl.CustomerUpdateStatusServiceImpl;
import com.app.customer.service.impl.CustomerViewOrderServiceImpl;
import com.app.dao.CustomerAddToCardDAO;
import com.app.dao.impl.CustomerAddToCartDAOImpl;
import com.app.employee.service.EmployeeAddNewProductService;
import com.app.employee.service.EmployeeLoginService;
import com.app.employee.service.EmployeeSearchServices;
import com.app.employee.service.EmployeeUpdateStatusService;
import com.app.employee.service.impl.EmployeeAddNewProductServiceImpl;
import com.app.employee.service.impl.EmployeeLoginServiceImpl;
import com.app.employee.service.impl.EmployeeSearchServicesImpl;
import com.app.employee.service.impl.EmployeeUpdateStatusServiceImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.Order;
import com.app.model.Product;
import com.app.resources.ProductResourceList;
//import com.app.util.MysqlDbConnection;
//import com.app.validation.Validation;
//import com.app.validationimpl.ValidationImpl;
//import com.mysql.cj.protocol.Resultset;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		log.info("Welcome Alpha Shopping...");
		log.info("===========================");
		int choiceOfMain = 0;
		do {
			log.info("1.) Customer Login");
			log.info("2.) Employee Login");
			log.info("3.) New Customer Signup ");
			log.info("4.) Exit");
			log.info("\nEnter Your Choice...");
			try {
				choiceOfMain = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException ex) {
				log.info("Only Integer values are allowed");
				continue;
			}

			switch (choiceOfMain) {
			case 1:
				log.info("Enter Your Username :");
				String email = scanner.nextLine();
				log.info("Enter Your Password :");
				String password = scanner.nextLine();

				try {
					Customer customer = null;
					List<Cart> cartList = new ArrayList<>();
					CustomerLoginService customerLogin = new CustomerLoginServiceImpl();
					customer = customerLogin.isUserExist(email, password);
					if (customer != null) {
						int choiceOfLoggedInCustomer;
						do {

							log.info("Hello " + customer.getFirstName().toUpperCase() + " Happy Shopping...");
							log.info("1.) Search Product");
							log.info("2.) View Cart");
							log.info("3.) view order");
							log.info("4.) update Status");
							log.info("5.) Logout");
							log.info("\nEnter Your Choice of logged In Customer");
							choiceOfLoggedInCustomer = Integer.parseInt(scanner.nextLine());
							switch (choiceOfLoggedInCustomer) {
							case 1:
								int ChoiceOfSearchProduct;
								do {
									log.info("How would you like to Search");
									log.info("1.) Search By Product Name");
									log.info("2.) Search By Product Branch/Company");
									log.info("3.) Search By Product Category");
									log.info("4.) Bach To Home Menu");
									log.info("\nEnter Your Choice Of Search Product");
									ChoiceOfSearchProduct = Integer.parseInt(scanner.nextLine());
									CustomerSearchServices customerSearchServices = new CustomerSearchServicesImpl();
									switch (ChoiceOfSearchProduct) {
									case 1:
										ProductResourceList.productListByName();
										log.info("Enter Name of the Product");
										String productName = scanner.nextLine();
										List<Product> productList = new ArrayList<>();
										productList = customerSearchServices.productSearchByName(productName);
										if (productList.size() == 0) {
											continue;
										}
										for (Product p : productList) {
											log.info(p);
										}
										log.info("***************************************************");
										int addToCartChoice;
										do {
											log.info("Add to cart ? ");
											log.info("1.)Yes");
											log.info("2.)No");
											addToCartChoice = Integer.parseInt(scanner.nextLine());
											switch (addToCartChoice) {
											case 1:
												try {
													log.info("Enter Product id");
													int productId = Integer.parseInt(scanner.nextLine());
													log.info("Enter Quantity");
													int quantity = Integer.parseInt(scanner.nextLine());
													CustomerAddToCardDAO addToCart = new CustomerAddToCartDAOImpl();
													Cart cart = new Cart();
													cart = addToCart.addToCart(productId, customer.getEmail(),
															quantity);
													log.info("Product added to cart successfully  :");
													log.info(
															"**********************************************************");
													cartList.add(cart);
												} catch (NumberFormatException e) {
													log.info(e.getMessage());
												}

												break;
											case 2:

												break;

											default:
												log.info("Enter Valid choice ");
												break;
											}
										} while (addToCartChoice != 2);
										break;
									case 2:
										ProductResourceList.productListByCompany();
										log.info("\n Enter Name of the Product Company");

										String productCompany = scanner.nextLine();
										List<Product> productList1 = new ArrayList<>();
										productList1 = customerSearchServices.productSearchByCompany(productCompany);
										if (productList1.size() == 0) {
											continue;
										}
										for (Product p : productList1) {
											log.info(p);
										}

										do {

											log.info("Add to cart ? ");
											log.info("1.)Yes");
											log.info("2.)No");
											addToCartChoice = Integer.parseInt(scanner.nextLine());
											switch (addToCartChoice) {
											case 1:
												try {
													log.info("Enter Product id");
													int productId = Integer.parseInt(scanner.nextLine());
													log.info("Enter Quantity");
													int quantity = Integer.parseInt(scanner.nextLine());
													CustomerAddToCardDAO addToCart = new CustomerAddToCartDAOImpl();
													Cart cart = new Cart();
													cart = addToCart.addToCart(productId, customer.getEmail(),
															quantity);
													cartList.add(cart);
													log.info("Product added to cart successfully  :");
													log.info(
															"**********************************************************");
												} catch (NumberFormatException e) {
													log.info(e.getMessage());
												}

												break;
											case 2:

												break;

											default:
												log.info("Enter Valid choice ");
												break;
											}
										} while (addToCartChoice != 2);

										break;
									case 3:
										ProductResourceList.productListByCategory();
										log.info("\nEnter Name of the Category");
										String productCategory = scanner.nextLine();
										List<Product> productList2 = new ArrayList<>();
										productList2 = customerSearchServices.productSearchByCategory(productCategory);
										if (productList2.size() == 0) {
											continue;
										}
										for (Product p : productList2) {
											log.info(p);
										}
										do {

											log.info("Add to cart ? ");
											log.info("1.)Yes");
											log.info("2.)No");
											addToCartChoice = Integer.parseInt(scanner.nextLine());
											switch (addToCartChoice) {
											case 1:
												try {
													log.info("Enter Product id");
													int productId = Integer.parseInt(scanner.nextLine());
													log.info("Enter Quantity");
													int quantity = Integer.parseInt(scanner.nextLine());
													CustomerAddToCardDAO addToCart = new CustomerAddToCartDAOImpl();
													Cart cart = new Cart();
													cart = addToCart.addToCart(productId, customer.getEmail(),
															quantity);
													if (cart == null) {
														log.info("Product Id Doesnot exist");
													}
													cartList.add(cart);
													log.info("Product added to cart successfully  :)");
													log.info(
															"**********************************************************");
												} catch (NumberFormatException e) {
													log.info("Only chice between 1 or 2 is valid Input");
												}

												break;
											case 2:

												break;

											default:
												log.info("Enter Valid choice ");
												break;
											}
										} while (addToCartChoice != 2);

										break;
									case 4:

										break;

									default:
										log.info("Provide Valid Input . Accepts only 1-4");
										break;
									}

								} while (ChoiceOfSearchProduct != 4);

								break;
							case 2:
								log.info("**********************************************************");
								log.info("                        YOUR CART                         ");
								log.info("**********************************************************");
								if (cartList.size() == 0) {
									log.info("\n\n  YOUR CART IS EMPTY  GO BACK AND ENJOY SHOPPING ;)");
									log.info("\n\n\n**********************************************************");
									continue;
								} else {
									double total = 0;
									for (Cart c : cartList) {

										System.out.printf("ID :%-4d PRODUCT :%-5s PRIZE :%-4.2f QUANTITY :%-2d\n",
												c.getCartId(), c.getCardProductName(), c.getCartProductPrice(),
												c.getQuantity());
										total = total + c.getQuantity() * c.getCartProductPrice();
									}
									log.info("\n**********************************************************");
									log.info("Total-                        " + total);
									log.info("Delivery charges-             " + 100);
									total = total + total * 0.05;
									log.info("Pay Now-                      " + total);
									log.info("**********************************************************");
								}
								int placeOrder = 0;
								try {
									log.info("Do You WANT TO PLACED ORDER");
									log.info("1.) YES");
									log.info("2.) NO");
									placeOrder = Integer.parseInt(scanner.nextLine());
								} catch (NumberFormatException e) {
									log.info(e.getMessage());
								}
								switch (placeOrder) {
								case 1:
									CustomerServicePlaceOrder place = new CustomerServicePlaceOrderImpl();
									if (cartList.size() == 0) {
										log.info("**********************************************************");
										log.info("                        YOUR CART                         ");
										log.info("**********************************************************");

										log.info("\n\n  YOUR CART IS EMPTY  GO BACK AND ENJOY SHOPPING ;)");
										log.info("\n\n\n**********************************************************");
										break;
									}

									int c = place.placeOrder(customer.getEmail());
									if (c > 0) {
										log.info("Your Order has been placed :)");
									}

									// delete from the cart table
									break;
								case 2:
									break;
								default:
									break;
								}

								break;
							case 3:
								log.info("YOUR ORDERS");
								List<Order> orderList = new ArrayList<>();
								orderList = null;
								CustomerViewOrderService viewOrder = new CustomerViewOrderServiceImpl();
								orderList = viewOrder.viewOrders(customer.getEmail());
								log.info("**********************************************************");
								log.info("                        YOUR ORDER                         ");
								log.info("**********************************************************\n");
								if (orderList.size() == 0) {
									log.info("\n\n  YOU HAVE NOT ORDER YET GO BACK AND ENJOY SHOPPING ;)");
									log.info("\n\n\n**********************************************************");
								} else {

									for (Order o : orderList) {
										System.out.printf(" ORDER ID  :  %d\n", o.getOrderid());
										System.out.printf(" PRODUCT   :  %s\n", o.getProductName());
										System.out.printf(" PRICE     :  %.2f\n", o.getProductPrice());
										System.out.printf(" QUANTITY  :  %d\n", o.getQuantity());
										System.out.printf(" STATUS    :  %s\n", o.getStatus());
										log.info("**********************************************************\n");

									}
								}

								break;
							case 4:
								int updateChoice;
								try {
									do {
										log.info("1.)UPDATE THE STATUS OF YOUR ORDER?");
										log.info("2.)BACK");
										updateChoice = Integer.parseInt(scanner.nextLine());
										switch (updateChoice) {
										case 1:
											log.info("ENTER THE ORDER ID OF RECEIEVED PRODUCT");
											int orderid = Integer.parseInt(scanner.nextLine());
											CustomerUpdateStatusService update = new CustomerUpdateStatusServiceImpl();
											int c = update.updateStatus(orderid);
											if (c == 0) {
												log.info("Invalid Order ID");
											}
											if (c > 0) {
												log.info("THANKYOU :)");
											}

											break;
										case 2:

											break;

										default:
											break;
										}

									} while (updateChoice != 2);
								} catch (NumberFormatException e) {
									log.warn("Only numbers are Allowed");
								}

								break;
							case 5:
								log.info("ThankYou For Shopping " + customer.getFirstName() + " Visit Again..:)");
								break;
							default:
								log.info("Invalid choice choose between 1-5");
								break;
							}
						} while (choiceOfLoggedInCustomer != 5); // logout and goto main main menu

					}
				} catch (BusinessException e) {
					log.info(e.getMessage());
				}

				break;
			case 2:
				log.info("                      EMPLOYEE LOGIN                     ");
				log.info("**********************************************************");
				log.info("Enter Your Email");
				String employeeEmail = scanner.nextLine();
				log.info("Enter Access Key");
				String employeePassword = scanner.nextLine();

				try {
					Employee employee = null;
					EmployeeLoginService employeeLoginService = new EmployeeLoginServiceImpl();
					employee = employeeLoginService.isEmployeeExist(employeeEmail, employeePassword);
					if (employee != null) {
						int employeeOperationChoice;
						do {
							log.info("Hii " + employee.getEmployeeName() + " ");
							log.info("What operation you have to perform");
							log.info("**********************************************************");
							log.info("1.) ADD NEW PRODUCT");
							log.info("2.) SEARCH CUSTOMER");
							log.info("3.) UPDATE ORDER STATUS");
							log.info("4.) LOGOUT");
							log.info("**********************************************************");
							log.info("\nENTER YOUR CHOICE");
							employeeOperationChoice = Integer.parseInt(scanner.nextLine());
							switch (employeeOperationChoice) {
							case 1:
								log.info("                       ADD NEW PRODUCT                    ");
								log.info("**********************************************************\n");
								Product product = new Product();
								log.info("ENTER PRODUCT ID");

								try {
									product.setProductId(Integer.parseInt(scanner.nextLine()));
								} catch (NumberFormatException e) {
									System.out.println(e.getMessage());
								}
								log.info("ENTER PRODUCT NAME");
								product.setProductName(scanner.nextLine());
								log.info("ENTER PRODUCT COMPANY");
								product.setProductCompany(scanner.nextLine());
								log.info("ENTER PRODUCT CATEGORY");
								product.setProducCategory(scanner.nextLine());
								log.info("ENTER PRODUCT PRICE");

								try {
									product.setProductPrice(Double.parseDouble(scanner.nextLine()));
								} catch (NumberFormatException e) {
									System.out.println(e.getMessage());
								}
								EmployeeAddNewProductService newProduct = new EmployeeAddNewProductServiceImpl();
								int c1 = newProduct.addNewProduct(product);
								if (c1 == 1) {
									log.info("PRODUCT ADDED SUCCESSFULLY.");
								}
								break;
							case 2:
								log.info("Search Customer");
								int employeesSearchOperationChoice;
								do {
									log.info("HOW WOULD YOU LIKE TO SEARCH");
									log.info("1.) SEARCH BY CUSTOMER Email");
									log.info("2.) SEARCH BY CUSTOMER ORDERID");
									log.info("4.) BACK");
									log.info("***********************************************************");
									log.info("\nENTER YOUR CHOICE");
									employeesSearchOperationChoice = Integer.parseInt(scanner.nextLine());
									switch (employeesSearchOperationChoice) {
									
										
									case 1:
										log.info("ENTER CUSTOMER EMAIL ID");
										List<Order> orderList1 = new ArrayList<>();
										String emailSearch = scanner.nextLine();
										EmployeeSearchServices employeeSearchServices = new EmployeeSearchServicesImpl();
										orderList1 = employeeSearchServices.searchCustomerByEmail(emailSearch);
										log.info("**********************************************************");
										log.info("                       YOUR SEARCH RESULT                         ");
										log.info("**********************************************************\n");
										if (orderList1.size() == 0) {
											log.info("\n\n  YOU HAVE SEARCHED WITH WRONG INPUTS ;)");
											log.info(
													"\n\n\n**********************************************************");
										} else {

											for (Order o : orderList1) {
												System.out.printf(" ORDER ID  :  %d\n", o.getOrderid());
												System.out.printf("USER ID    :  %s\n", o.getEmail());
												System.out.printf(" PRODUCT   :  %s\n", o.getProductName());
												System.out.printf(" PRICE     :  %.2f\n", o.getProductPrice());
												System.out.printf(" QUANTITY  :  %d\n", o.getQuantity());
												System.out.printf(" STATUS    :  %s\n", o.getStatus());
												log.info(
														"**********************************************************\n");
											}
										}
										break;
									case 2:
										log.info("ENTER THE ORDER ID");
										List<Order> orderList2 = new ArrayList<>();
										int orderidSearch=Integer.parseInt(scanner.nextLine());
										EmployeeSearchServices employeeSearchServices1= new EmployeeSearchServicesImpl();
										orderList2 = employeeSearchServices1.searchCustomerByOrderId(orderidSearch);
										log.info("**********************************************************");
										log.info("                       YOUR SEARCH RESULT                         ");
										log.info("**********************************************************\n");
										if (orderList2.size() == 0) {
											log.info("\n\n  YOU HAVE SEARCHED WITH WRONG INPUTS ;)");
											log.info(
													"\n\n\n**********************************************************");
										} else {

											for (Order o : orderList2) {
												System.out.printf(" ORDER ID  :  %d\n", o.getOrderid());
												System.out.printf("USER ID    :  %s\n", o.getEmail());
												System.out.printf(" PRODUCT   :  %s\n", o.getProductName());
												System.out.printf(" PRICE     :  %.2f\n", o.getProductPrice());
												System.out.printf(" QUANTITY  :  %d\n", o.getQuantity());
												System.out.printf(" STATUS    :  %s\n", o.getStatus());
												log.info(
														"**********************************************************\n");
											}
										}

										break;
									case 3:

										break;

									default:
										log.info("Invalid Choice Enter Between 1-4");
										break;
									}
								} while (employeesSearchOperationChoice != 4);

								break;
							case 3:log.info("Update status here");
							int updateChoice;
							try {
								do {
									log.info("1.)UPDATE THE STATUS OF ORDER?");
									log.info("2.)BACK");
									updateChoice = Integer.parseInt(scanner.nextLine());
									switch (updateChoice) {
									case 1:
										log.info("ENTER THE ORDER ID TO MARK AS SHIPPED");
										int orderid1 = Integer.parseInt(scanner.nextLine());
										EmployeeUpdateStatusService update=new EmployeeUpdateStatusServiceImpl();
										int c = update.updateStatusEMP(orderid1);
										if (c == 0) {
											log.info("Invalid Order ID");
										}
										if (c > 0) {
											log.info("THANKYOU :)");
										}

										break;
									case 2:

										break;

									default:
										break;
									}

								} while (updateChoice != 2);
							} catch (NumberFormatException e) {
								log.warn("Only numbers are Allowed");
							}

								break;
							case 4:
								log.info("ThankYou :)");

								break;

							default:
								log.info("Invalid choice Enter Choice between 1-4");
								break;
							}

						} while (employeeOperationChoice != 4);
					}

				} catch (BusinessException e1) {
					log.info(e1.getMessage());
				}

				break;
			case 3:
				log.info("        Sign Up        ");
				log.info("========================");
				Customer newCustomer = new Customer();
				log.info("Enter your Email");
				newCustomer.setEmail(scanner.nextLine());
				log.info("Enter your First Name");
				newCustomer.setFirstName(scanner.nextLine());
				log.info("Enter your Last Name ");
				newCustomer.setLastName(scanner.nextLine());
				log.info("Enter your City");
				newCustomer.setCity(scanner.nextLine());
				log.info("Enter Password of Your Choice");
				newCustomer.setPassword(scanner.nextLine());
				CustomerCreateService createCustomer = new CustomerCreateServiceImpl();
				try {
					int c = createCustomer.createNewCustomer(newCustomer);
					if (c == 1) {
						log.info("Hello " + newCustomer.getFirstName() + " your account has successfully created :)");
					}
				} catch (BusinessException e) {
					log.info(e.getMessage());
				}

				break;
			case 4:

				break;

			default:
				log.info("Invalid Choice . Try Again :)");
				break;
			}

		} while (choiceOfMain != 4); // Go out of AplhaShopping App

	}

}
