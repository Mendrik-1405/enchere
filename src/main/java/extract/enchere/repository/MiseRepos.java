package extract.enchere.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import extract.enchere.Enchere;
import extract.enchere.Mise;

@Repository
@Qualifier("misepostgres")
public interface MiseRepos extends JpaRepository<Mise, Integer> {

    public List<Mise> findByEnchere(Enchere enchere);
}
