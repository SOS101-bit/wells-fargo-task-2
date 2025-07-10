package com.wellsfargo.counselor;
import com.wellsfargo.counselor.entity.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Arrays;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Entrypoint {
    public static void main(String[] args) {
        SpringApplication.run(Entrypoint.class, args);
        Client client = new Client("Sourav", "sourav@email.com");
        Portfolio portfolio = new Portfolio("Growth Portfolio");

        Security security1 = new Security("TCS", "Stock", 1000.0);
        Security security2 = new Security("HDFC Bond", "Bond", 5000.0);

        security1.setPortfolio(portfolio);
        security2.setPortfolio(portfolio);

        portfolio.setClient(client);
        portfolio.setSecurities(Arrays.asList(security1, security2));

        client.setPortfolios(Arrays.asList(portfolio));

        // Print to console
        System.out.println("Client: " + client.getName());
        for (Portfolio p : client.getPortfolios()) {
            System.out.println("  Portfolio: " + p.getPortfolioName());
            for (Security s : p.getSecurities()) {
                System.out.println("    Security: " + s.getName() + " | Type: " + s.getType() + " | Value: ₹" + s.getValue());
            }
        }
    }
}
