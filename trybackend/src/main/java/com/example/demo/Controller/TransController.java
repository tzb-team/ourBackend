package com.example.demo.Controller;

import com.example.demo.Entity.Trans;
import com.example.demo.Enum.PatentKind;
import com.example.demo.Param.patentParam.patentStateChange;
import com.example.demo.Param.transParam.*;
import com.example.demo.Response.FundamentalResponse;
import com.example.demo.Response.transReponse.showAll;
import com.example.demo.Response.transReponse.showSelf;
import com.example.demo.Service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/transaction")
public class TransController {

    @Autowired
    TransService service;

    @PostMapping(value = "/transaction",
            consumes = {"application/json", "application/xml"})
    public FundamentalResponse trade(@RequestBody transaction trans) {
        service.transaction(trans.getPatentID(),trans.getFrom(),trans.getTo(),trans.getPrice());
        FundamentalResponse response=new FundamentalResponse(true);
        return response;
    }

    @GetMapping(value = "/showTrans",
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public showAll showtransactions() {
        List<Trans> trans = service.showTrans();
        showAll alls =new showAll(trans.size());
        for(int i=0;i<trans.size();i++){
            alls.trans[i] = trans.get(i);
        }
        return alls;
    }
    @GetMapping(value = "/kind")
    @ResponseBody
    public ResponseEntity<?> showTransByKind(@RequestBody Pkind kind){
        return ResponseEntity.ok(service.showTransByKind(Enum.valueOf(PatentKind.class,kind.getKind())));
    }

    @GetMapping(value = "/showTransSelf",
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public showSelf showselfTrans(@RequestBody from from) {
        List<Trans> trans = service.showSelfTrans(from.getFrom());
        showSelf selfs =new showSelf(trans.size());
        for(int i=0;i<trans.size();i++){
            selfs.trans[i] = trans.get(i);
        }
        return selfs;
    }
}
