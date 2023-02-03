package extract.enchere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import extract.controller.Cnt;
import lombok.Data;
import lombok.EqualsAndHashCode;

@CrossOrigin("*")
@Data
@RestController
@RequestMapping("/historique")
@EqualsAndHashCode(callSuper = false)
public class Historique extends Cnt {
    @Autowired
    MiseMongoRepos mRepos;

    @GetMapping("/{id}")
    public ResponseEntity<?> getByEnchere(@PathVariable("id") int id) {
        try {
            return this.returnSuccess(this.getMRepos().findByEnchereid(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return this.returnError(e, HttpStatus.NOT_FOUND);
        }
    }
}
