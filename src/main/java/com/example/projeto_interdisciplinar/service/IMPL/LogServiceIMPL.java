package com.example.projeto_interdisciplinar.service.IMPL;

import com.example.projeto_interdisciplinar.entity.Log;
import com.example.projeto_interdisciplinar.repo.LogsRepo;
import com.example.projeto_interdisciplinar.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class LogServiceIMPL implements LogService {
    @Autowired
    private LogsRepo logsRepo;
    public List<Log> getLogs() {
        return logsRepo.findAll();
    }

    @Override
    public Log generateLog(String desc, int userid) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        Log log = new Log(uuidAsString,desc,userid, LocalDateTime.now());
        return logsRepo.save(log);
    }
}
