package extract.enchere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import extract.auth.LoginRepos;
import extract.enchere.repository.EnchereRepos;
import extract.enchere.repository.MiseRepos;
import extract.model.HCrud;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Service
public class MiseSer extends HCrud<Mise, Integer, MiseRepos> {
    @Autowired
    MiseMongoRepos mongoRepos;

    @Autowired
    EnchereRepos eRepos;

    @Autowired
    LoginRepos lRepos;

    @Autowired
    public MiseSer(MiseRepos repos) {
        super(repos);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Mise create(Mise obj) {
        Mise mise = super.create(obj);
        mise.setLogin(this.getLRepos().findById(mise.getLogin().getId()).get());
        
        mise.setEnchere(this.getERepos().findById(mise.getEnchere().getId()).get());
        mise.getEnchere().setDebut(null);
        mise.getEnchere().setFin(null);
        MiseMongo hist = new MiseMongo();
        hist.copy(mise);
        this.getMongoRepos().save(hist);
        return mise;
    }

}
