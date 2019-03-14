package com.example.demo.Controller;

import com.example.demo.Dao.UserRepo;
import com.example.demo.Entity.Patent;
import com.example.demo.Entity.User;
import com.example.demo.Param.patentParam.*;
import com.example.demo.Response.patentResponse.*;
import com.example.demo.Response.patentResponse.patentState;
import com.example.demo.Service.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/patent")
public class PatentController {
    @Autowired
    PatentService service;

    @PostMapping(value = "/patRegister")
    public void test(@RequestBody patentReg patentReg){
        service.patentRegister(patentReg.ID,patentReg.name,patentReg.owner,patentReg.walletaddress,patentReg.type,patentReg.pool,patentReg.content,patentReg.state);
    }



//    @PostMapping(value = "/test")
//    public void patentReg(@RequestBody patReg patents){
//        service.patentRegister(patents.getID(),patents.getName(),patents.getOwner());
//    }

    @Autowired
    UserRepo repo;
    @GetMapping(value = "/patCheck",
           produces = {"application/json", "application/xml"})
    public uncheckedList patentReg(){
        List<Patent> list = service.getUncheckList();
        uncheckedList list1 = new uncheckedList();
        for(int i=0;i<list.size();i++){
            User user = list.get(i).getOwner();
            list1.unchecks.put(list.get(i).getPatentID(),user.getRealname());
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
        service.changePatentNum(patents.getpatentID(),patents.getNum());
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
