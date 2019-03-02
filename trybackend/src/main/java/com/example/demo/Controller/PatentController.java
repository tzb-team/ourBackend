package com.example.demo.Controller;

import com.example.demo.Entity.Patent;
import com.example.demo.Param.patentParam.*;
import com.example.demo.Response.patentResponse.*;
import com.example.demo.Response.patentResponse.patentState;
import com.example.demo.Service.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patent")
public class PatentController {

    @Autowired
    PatentService service;

    @PostMapping(value = "/patRegister",
            consumes = {"application/json", "application/xml"})
    public void patentReg(@RequestBody patentReg patents){
        service.patentRegister(patents.getID(),patents.getName(),patents.getOwner(),patents.getWalletaddress(),patents.getType(),patents.getPool(),patents.getContent(),patents.getState());
    }

    @GetMapping(value = "/patCheck",
           produces = {"application/json", "application/xml"})
    public uncheckedList patentReg(){
        List<Patent> list = service.getUncheckList();
        uncheckedList list1 = new uncheckedList();
        for(int i=0;i<list.size();i++){
            list1.unchecks.put(list.get(i).getPatentID(),list.get(i).getOwner());
        }
        return list1;
    }

    @GetMapping(value = "/patRegCheck",
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public patentState patentGetState(@RequestBody patentStatep statep){
        patentState state = new patentState();
        state.num = service.showNum(statep.getPatentID());
        return state;
    }


    @PostMapping(value = "/patStaChange",
            consumes = {"application/json", "application/xml"})
    public void patentSetState(@RequestBody patentStateChange patents) {
        service.changePatentNum(patents.getID(),patents.getNum());
    }

    @GetMapping(value = "/showPatent",
            produces = {"application/json", "application/xml"})
    public patentAll patentAll() {
        List<Patent> list = service.showAllPatent();
        patentAll all = new patentAll(list.size());
        for (int i = 0; i < list.size(); i++) {
            all.patents[i] = list.get(i);
        }
        return all;
    }
}
