package extract.enchere;

import javax.persistence.MappedSuperclass;

import extract.model.HElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class Apropos extends HElement<Integer> {

    String designation;
}
