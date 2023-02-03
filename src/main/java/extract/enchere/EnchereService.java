package extract.enchere;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import extract.enchere.repository.EnchereRepos;
import extract.model.HCrud;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Service
public class EnchereService extends HCrud<Enchere, Integer, EnchereRepos> {
    @Autowired
    EntityManager entityManager;

    @Autowired
    public EnchereService(EnchereRepos repos) {
        super(repos);
    }

    public List<Enchere> search(EnchereRequest eRequest) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Enchere> query = builder.createQuery(Enchere.class);
        Root<Enchere> i = query.from(Enchere.class);
        query.select(i);
        eRequest.prepare(query, builder, i);
        List<Enchere> result = entityManager.createQuery(query).getResultList();
        return result;
    }

}
