package extract.solde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import extract.controller.CrudController;

@CrossOrigin("*")
@RequestMapping("/solde")
@RestController
@Controller
public class SoldeCnt extends CrudController<Soldelogin,Integer,SoldeRepos,SoldeSer> {

    @Autowired
    public SoldeCnt(SoldeSer service) {
        super(service);
    }
    
}
