package extract.enchere;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import extract.auth.Login;
import extract.model.HElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class MiseMap extends HElement<Integer> {

    @OneToOne
    @JoinColumn(name = "enchereid")
    Enchere enchere;

    @OneToOne
    @JoinColumn(name = "loginid")
    Login login;

    double prix;

    Date datemise;


    public MiseMap() {
        this.setDatemise(Timestamp.valueOf(LocalDateTime.now()));
    }

    public void copy(MiseMap map) {
        this.setId(map.getId());
        this.setEnchere(map.getEnchere());
        this.setLogin(map.getLogin());
        this.setPrix(map.getPrix());
    }

}
