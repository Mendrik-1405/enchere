package extract.enchere;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import extract.auth.Login;
import extract.enchere.product.Produit;
import extract.model.HElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Enchere extends HElement<Integer> {
    String designation;
    @Column(name = "datedebut")
    Timestamp debut;
    @Column(name = "datefin")
    Timestamp fin;
    @Column(name = "prixminmise")
    double prixMin;
    int etat;
    @OneToOne
    @JoinColumn(name = "loginid")
    Login login;
    @Column(name = "prixmin")
    double minimum;

    @OneToOne
    @JoinColumn(name = "Produitid")
    Produit produit;
}
