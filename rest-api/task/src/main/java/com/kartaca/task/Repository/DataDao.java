package com.kartaca.task.Repository;

import com.kartaca.task.Entity.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataDao extends MongoRepository<Data, Long> {
}
