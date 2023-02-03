package extract.enchere;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MiseMongoRepos extends MongoRepository<MiseMongo,Integer> {
    public List<MiseMongo> findByEnchereid(int enchere);
}
