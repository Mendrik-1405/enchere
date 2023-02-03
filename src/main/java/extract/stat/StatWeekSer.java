package extract.stat;

import org.springframework.stereotype.Service;

import extract.model.HCrud;

@Service
public class StatWeekSer extends HCrud<StatWeek,Integer,StatWeekRepos> {

    public StatWeekSer(StatWeekRepos repos) {
        super(repos);
        //TODO Auto-generated constructor stub
    }
    
}
