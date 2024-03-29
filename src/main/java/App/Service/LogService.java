package App.Service;

import App.Entities.Accounts.OperationsLogs.Log;
import App.Service.repository.LogRepository;

import java.util.List;

public class LogService {

    private final LogRepository repo = new LogRepository();

    public boolean registerLogs(List<Log> logs){
        return repo.insert(logs);
    }

    public List<Log> findAllByNumber(String number){
        return repo.search(number);
    }
}
