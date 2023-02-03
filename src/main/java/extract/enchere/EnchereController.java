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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import extract.auth.NoAuth;
import extract.auth.TokenSer;
import extract.controller.CrudController;
import extract.enchere.repository.EnchereRepos;
import lombok.Data;
import lombok.EqualsAndHashCode;

@CrossOrigin("*")
@Data
@RestController
@RequestMapping("/enchere")
@EqualsAndHashCode(callSuper = false)
public class EnchereController extends CrudController<Enchere, Integer, EnchereRepos, EnchereService> {

    @Autowired
    TokenSer tokenSer;

    @Autowired
    public EnchereController(EnchereService service) {
        super(service);
    }

    @PostMapping("/search")
    public ResponseEntity<?> search(@RequestBody EnchereRequest eRequest) {
        try {
            return this.returnSuccess(this.getService().search(eRequest), HttpStatus.OK);
        } catch (Exception e) {
            return this.returnError(e, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> create(@RequestBody Enchere obj,
            @RequestParam(name = "idUser", required = false) Integer id)
            throws Exception {
        if (id != null && this.getTokenSer().canAccess(id)) {
            return super.create(obj, id);
        }
        return this.returnError(new NoAuth(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cloture/{id}")
    public ResponseEntity<?> cloture(@PathVariable("id") Integer id) {
        try {
            this.getService().getRepos().cloture(id);
            return this.returnSuccess("ok", HttpStatus.OK);
        } catch (Exception e) {
            return this.returnError(e, HttpStatus.NOT_FOUND);
        }
    }
}
