package extract.enchere;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document("mise")
public class MiseMongo extends MiseMap {
    int enchereid;

    @Override
    public void setEnchere(Enchere enchere) {
        super.setEnchere(enchere);
        this.setEnchereid(this.getEnchere().getId());
    }

    @Override
    public void copy(MiseMap map) {
        // TODO Auto-generated method stub
        super.copy(map);
    }

}
