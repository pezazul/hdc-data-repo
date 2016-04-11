package org.bjc.hi.hdc.data;

import org.bjc.hi.hdc.data.bean.DocumentIndex;
import org.bjc.hi.hdc.data.repository.DocumentIndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by Kevin on 4/10/2016.
 */
    @SpringBootApplication
    public class Application {

    private static final Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(DocumentIndexRepository documentIndexRepository) {
        final DocumentIndexRepository repository = documentIndexRepository;
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                // save a couple of customers
                repository.save(new DocumentIndex("doc1", "pat1", 1234, new Date(System.currentTimeMillis())));
                repository.save(new DocumentIndex("doc2", "pat1", 456, new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 5)));
                repository.save(new DocumentIndex("doc3", "pat2", 789, new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 8)));


                // fetch all customers
                log.info("Customers found with findAll():");
                log.info("-------------------------------");
                for (DocumentIndex doc : repository.findAll()) {
                    log.info(doc.toString());
                }
                log.info("");

                // fetch an individual customer by ID
                DocumentIndex doc = repository.findOne("doc1");
                log.info("Document found with findOne(doc1):");
                log.info("--------------------------------");
                log.info(doc.toString());
                log.info("");

                // fetch customers by last name
                log.info("Document found with findByUpiAndEventTsBetween(....):");
                log.info("--------------------------------------------");
                for (DocumentIndex doc2 : repository.findByUpiAndEventTsBetween("pat1", new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 90L)), new Date(System.currentTimeMillis()))) {
                    log.info(doc2.toString());
                }
                log.info("");
            }

        };
    }


}

