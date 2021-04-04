package com.kartaca.task.Service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

@AllArgsConstructor
@Service
public class ProducerService {

    private static final String TOPIC_NAME ="TransactionEvent";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(){
        File file = new File("text.log");
        String data= null;
        try(Scanner line = new Scanner(file)){
            while(line.hasNextLine()){
                data= line.nextLine();
            }
        } catch (NoSuchElementException | FileNotFoundException noSuchElementException){
            //System.out.println("err");
        }
        kafkaTemplate.send(TOPIC_NAME,data);
    }
}
