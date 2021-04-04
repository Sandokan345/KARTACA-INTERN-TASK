package com.kartaca.task.Service;

import com.kartaca.task.Entity.Data;
import com.kartaca.task.Repository.DataDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DataService {

    private final DataDao dataDao;

    public List<Data> findAll(){
        return dataDao.findAll();
    }

}
