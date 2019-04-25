package se.jobtech.taxonomy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.jobtech.taxonomy.controller.TaxonomyController;


@SpringBootApplication
public class JsontodbApplication implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("JsontodbApplication");

  private  final TaxonomyController taxonomyController;

    @Autowired
    public JsontodbApplication( TaxonomyController taxonomyController ) {
        this.taxonomyController = taxonomyController;
    }

    public static void main(String[] args) {
        SpringApplication.run(JsontodbApplication.class, args);
    }
    @Override
    public void run(String... args)  {








    }
}



