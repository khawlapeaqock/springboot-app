package com.example.demo.service;
import com.example.demo.entities.Produit;
import com.example.demo.repository.produitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ProduitServiceImplement implements produitService {
    private final produitRepository produitRepository;

    @Override
    public Produit creer(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll();
    }

    @Override
    public Produit modifier(Long id, Produit produit) {
        return produitRepository.findById(id).map(p -> {
            p.setPrix(produit.getPrix());
            p.setNom(produit.getNom());
            p.setDescription(produit.getDescription());
            return produitRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Produit non trouvé !"));
    }

    @Override
    public String supprimer(Long id) {
        produitRepository.deleteById(id);
        return "produit supprimé";
    }
}