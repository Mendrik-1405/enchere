package extract.enchere.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import extract.enchere.Enchere;

public interface EnchereRepos extends JpaRepository<Enchere, Integer> {

    @Transactional
    @Modifying
    @Query(value = "call clotenchere(:id)", nativeQuery = true)
    public void cloture(@Param("id") Integer id);
}
