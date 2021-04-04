package com.kartaca.task.Service;

import com.kartaca.task.Entity.Data;
import com.kartaca.task.Repository.DataDao;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ConsumerService {

    private final DataDao dataDao;

    @KafkaListener(topics = "TransactionEvent",containerFactory = "kafkaListenerContainerFactory",groupId = "group-id")
    public void consume(String test){
        String [] temp = test.split(",");

        Data data = new Data();
        data.setRequestType(temp[0]);
        data.setResponseTime(temp[1]);
        data.setTimestamp(temp[2]);
        dataDao.save(data);
    }
}
