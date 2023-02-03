package extract.enchere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import extract.controller.CrudController;
import extract.enchere.repository.MiseRepos;

@CrossOrigin("*")
@RestController
@RequestMapping("/mise")
public class MiseCnt extends CrudController<Mise, Integer, MiseRepos, MiseSer> {

    @Autowired
    public MiseCnt(MiseSer service) {
        super(service);
    }

    @GetMapping("/enchere/{id}")
    public ResponseEntity<?> getByEnchere(@PathVariable("id") int idEnchere) {
        try {
            Enchere enchere = new Enchere();
            enchere.setId(idEnchere);
            Mise mise = this.getService().getRepos().findByEnchere(enchere).get(0);
            return this.returnSuccess(mise, HttpStatus.OK);
        } catch (IndexOutOfBoundsException e) {
            return this.returnError(new Exception("L'enchere n'est pas en cours"), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return this.returnError(e, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> create(@RequestBody Mise obj,
            @RequestParam(name = "idUser", required = false) Integer id) throws Exception {
        try {
            return this.returnSuccess(service.create(obj), HttpStatus.CREATED);
        } catch (Exception e) {
            return this.returnError(e, HttpStatus.NOT_FOUND);
        }
    }
}
