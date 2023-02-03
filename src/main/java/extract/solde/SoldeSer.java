package extract.solde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import extract.model.HCrud;

@Service
public class SoldeSer extends HCrud<Soldelogin,Integer,SoldeRepos> {

    @Autowired
    public SoldeSer(SoldeRepos repos) {
        super(repos);
    }
    
}
