package extract.solde;

import javax.persistence.Entity;

import extract.model.HElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Soldelogin extends HElement<Integer> {
    double solde;
}
