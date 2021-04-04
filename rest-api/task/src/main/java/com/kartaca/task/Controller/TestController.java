package com.kartaca.task.Controller;

import com.kartaca.task.Entity.Data;
import com.kartaca.task.Service.DataService;
import com.kartaca.task.Service.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class TestController {

    private final ProducerService producerService;

    private final DataService dataService;

    public void process(long res, String mappingType){
        File file = new File("text.log");
        StringBuilder temp = new StringBuilder();

        try(Scanner line = new Scanner(file)){
            while (line.hasNext()){
                temp.append(line.nextLine());
                temp.append("\n");
            }
        } catch (NoSuchElementException | FileNotFoundException noSuchElementException){
            //System.out.println("err");
        }

        try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
            br.write( temp + mappingType + "," + (res) + "," + System.currentTimeMillis());
        } catch (IOException e) {
            //System.out.println("Unable to read file " +file.toString());
        }
    }
    @GetMapping("/")
    public String test(Model model){
        model.addAttribute("hello");
        return "index";
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get")
    public List<Data> getRequest(){

        StopWatch watch = new StopWatch();
        watch.start();
        watch.stop();
        long res = watch.getTotalTimeNanos();

        process(res, "Get");

        producerService.send();

        return dataService.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/post")
    public void postRequest(@RequestBody(required = false) Data data){
        StopWatch watch = new StopWatch();
        watch.start();
        watch.stop();
        long res = watch.getTotalTimeNanos();

        process(res, "Post");

        producerService.send();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/put")
    public void putRequest(@RequestBody(required = false) Data data){
        StopWatch watch = new StopWatch();
        watch.start();
        watch.stop();
        long res = watch.getTotalTimeNanos();

        process(res, "Put");

        producerService.send();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete")
    public void deleteRequest(){
        StopWatch watch = new StopWatch();
        watch.start();
        watch.stop();
        long res = watch.getTotalTimeNanos();

        process(res, "Delete");

        producerService.send();
    }
}
