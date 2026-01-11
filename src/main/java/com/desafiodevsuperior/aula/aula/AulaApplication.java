// java
package com.desafiodevsuperior.aula.aula;

import com.desafiodevsuperior.aula.entities.Order;
import com.desafiodevsuperior.aula.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication(scanBasePackages = "com.desafiodevsuperior.aula")
public class AulaApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your order code: ");
		int code = Integer.parseInt(sc.nextLine().trim());
		System.out.print("Enter basic value: ");
		double basic = Double.parseDouble(sc.nextLine().trim().replace(",", "."));
		System.out.print("Enter discount value: ");
		double discount = Double.parseDouble(sc.nextLine().trim().replace(",", "."));

		Order order = new Order(code, basic, discount);
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order code: " + code);
		System.out.println("Total value: R$" + String.format("%.2f", orderService.total(order)));
		sc.close();
	}
}