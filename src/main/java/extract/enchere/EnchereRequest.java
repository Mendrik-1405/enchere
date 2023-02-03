package extract.enchere;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import lombok.Data;

@Data
public class EnchereRequest {
    Integer etat;
    String keys;
    Date date;
    int[] categorie;
    Double prixmin;
    Double prixmax;

    public void prepare(CriteriaQuery<Enchere> query, CriteriaBuilder builder, Root<Enchere> i) {
        List<Predicate> ans = new ArrayList<>();
        this.prepareEtat(query, builder, i,ans);
        this.prepareKey(query, builder, i,ans);
        this.prepareDate(query, builder, i,ans);
        this.prepareCategorie(query, builder, i,ans);
        this.preparePrix(query, builder, i,ans);
        query.where(builder.and(this.toPred(ans)));
    }

    public Predicate[] toPred(List<Predicate> pred) {
        Predicate[] ans = new Predicate[pred.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pred.get(i);
        }
        return ans;
    }

    public void preparePrix(CriteriaQuery<Enchere> query, CriteriaBuilder builder, Root<Enchere> i,List<Predicate> ans) {
        if (this.getPrixmin() != null) {
            ans.add(builder.greaterThanOrEqualTo(i.get("prixMin"), this.getPrixmin()));
        }
        if (this.getPrixmax() != null) {
            ans.add(builder.lessThanOrEqualTo(i.get("prixMin"), this.getPrixmin()));
        }
    }

    public void prepareCategorie(CriteriaQuery<Enchere> query, CriteriaBuilder builder, Root<Enchere> i,List<Predicate> ans) {
        if (this.getCategorie() != null) {
            ans.add(i.get("produit").get("categorie").get("id").in(this.getCategorie()));
        }
    }

    public void prepareDate(CriteriaQuery<Enchere> query, CriteriaBuilder builder, Root<Enchere> i,List<Predicate> ans) {
        if (this.getDate() != null) {
            ans.add(builder.greaterThanOrEqualTo(i.get("fin"), this.getDate()));
        }
    }

    public void prepareKey(CriteriaQuery<Enchere> query, CriteriaBuilder builder, Root<Enchere> i,List<Predicate> ans) {
        if (this.getKeys() != null) {
            String keys = "%" + this.getKeys() + "%";
            Predicate pred = builder.or(
                builder.like(i.get("designation"), keys),
                builder.like(i.get("produit").get("designation"), keys),
                builder.like(i.get("produit").get("description"), keys)
                );
            ans.add(pred);
        }
    }

    public void prepareEtat(CriteriaQuery<Enchere> query, CriteriaBuilder builder, Root<Enchere> i,List<Predicate> ans) {
        if (this.getEtat() != null) {
            ans.add(builder.equal(i.get("etat"), this.getEtat()));
        }
    }

}
