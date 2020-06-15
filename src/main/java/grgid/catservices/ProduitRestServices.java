package grgid.catservices;

import grgid.catservices.Dao.ProduitRepository;
import grgid.catservices.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitRestServices {
    @Autowired
    private ProduitRepository produitRepository;
    @GetMapping(value="/listProduits")
    public List<Produit> listProduit(){
        return produitRepository.findAll();
    }
    @GetMapping(value="/listProduits/{id}")
    public Produit listProduit(@PathVariable(name = "id") Long id){
        return produitRepository.findById(id).get();
    }
    @PutMapping(value="/listProduits/{id}")
    public Produit update(@PathVariable(name = "id") Long id, @RequestBody Produit p){
        p.setId(id);
        return produitRepository.save(p);
    }
    @PostMapping (value="/listProduits")
    public Produit save(@RequestBody Produit p){
        return produitRepository.save(p);
    }
    @DeleteMapping(value="/listProduits/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        produitRepository.deleteById(id);
    }
}
