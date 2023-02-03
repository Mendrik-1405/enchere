package extract.enchere;

import java.security.Timestamp;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Mise extends MiseMap {
}