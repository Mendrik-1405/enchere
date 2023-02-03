package extract.enchere.product;

import org.springframework.stereotype.Service;

import extract.enchere.repository.ProduitRepos;
import extract.model.HCrud;

@Service
public class ProductService extends HCrud<Produit, Integer, ProduitRepos> {

    public ProductService(ProduitRepos repos) {
        super(repos);
    }

}
