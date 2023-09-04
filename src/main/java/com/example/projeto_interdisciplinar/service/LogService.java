package com.example.projeto_interdisciplinar.service;

import com.example.projeto_interdisciplinar.entity.Log;

import java.util.List;

public interface LogService {
    List<Log> getLogs();
    Log generateLog(String desc, int userid);
}
