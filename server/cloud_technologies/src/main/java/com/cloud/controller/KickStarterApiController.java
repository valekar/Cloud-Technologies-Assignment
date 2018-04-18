package com.cloud.controller;

import com.cloud.ViewModel.ProjectVM;
import com.cloud.model.KickStarter;
import com.cloud.service.IKickStarterService;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.catalyst.plans.logical.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Callable;


@RestController
@RequestMapping("/api")
public class KickStarterApiController {

    private IKickStarterService starterService;

    @Autowired
    public KickStarterApiController(IKickStarterService kickStarterService){
        this.starterService = kickStarterService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    Callable<ResponseEntity<String>> testMe() {
        this.starterService.test();
        return () -> ResponseEntity.ok("test");
    }


    @RequestMapping(value = "/projects",method = RequestMethod.POST)
    Callable<ResponseEntity<List<KickStarter>>> getProjects(@RequestBody ProjectVM projectVM) {
        List<KickStarter> kickStarterList = this.starterService.findProjects(projectVM);
        /*for(Row row : kickStarterList){
            System.out.println(row);
        }*/
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(kickStarterList.size());
        return () -> ResponseEntity.ok(kickStarterList);
    }

}
