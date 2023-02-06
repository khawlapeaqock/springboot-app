package com.example.demo.controlleur;

import com.example.demo.entities.Produit;
import com.example.demo.service.produitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produit")
@AllArgsConstructor
public class ProduitControlleur {
    private final produitService ProduitService;

    @PostMapping("/create")
    public Produit create(@RequestBody Produit produit) {
        return ProduitService.creer(produit);
    }

    @GetMapping("/read")
    public List<Produit> read() {

        return ProduitService.lire();
    }

    @PutMapping("/update/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit produit) {
        return ProduitService.modifier(id, produit);
    }

    @DeleteMapping("/Delete/{id}")
    public String delete(@PathVariable Long id) {
        return ProduitService.supprimer(id);

    }


}
