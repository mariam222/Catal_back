package grgid.catservices;

import grgid.catservices.Dao.ProduitRepository;
import grgid.catservices.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatServicesApplication implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(CatServicesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Produit.class);
        produitRepository.save(new Produit(null,"Ordinateur Lx 45",5000,2));
        produitRepository.save(new Produit(null,"Imprimante",1500,3));
        produitRepository.save(new Produit(null,"Smart phone S7",8000,12));

        produitRepository.findAll().forEach(p->
        {System.out.println(p.toString());
        });
    }
}
