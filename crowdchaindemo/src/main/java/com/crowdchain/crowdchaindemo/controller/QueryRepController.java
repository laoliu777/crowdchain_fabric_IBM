package com.crowdchain.crowdchaindemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.crowdchain.crowdchaindemo.model.PlayerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import com.crowdchain.crowdchaindemo.chaincode.invocation.QueryChaincode;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class QueryRepController {
    @RequestMapping(value = "/queryReport",method = RequestMethod.GET)
    public List<PlayerItem> deleteApprovalContentLog(HttpServletRequest httpServletRequest){
        JSONObject returnObj = new JSONObject();
        List<PlayerItem> res=new QueryChaincode().queryRep("1000010");

        //returnObj.put("queryRep",res);
        //return returnObj.toJSONString();
        return res;
    }
}
