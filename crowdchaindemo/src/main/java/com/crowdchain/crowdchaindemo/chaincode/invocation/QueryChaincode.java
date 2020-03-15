package com.crowdchain.crowdchaindemo.chaincode.invocation;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crowdchain.crowdchaindemo.client.CAClient;
import com.crowdchain.crowdchaindemo.client.ChannelClient;
import com.crowdchain.crowdchaindemo.client.FabricClient;
import com.crowdchain.crowdchaindemo.config.Config;
import com.crowdchain.crowdchaindemo.model.PlayerItem;
import com.crowdchain.crowdchaindemo.user.UserContext;
import com.crowdchain.crowdchaindemo.util.Util;
import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.EventHub;
import org.hyperledger.fabric.sdk.Orderer;
import org.hyperledger.fabric.sdk.Peer;
import org.hyperledger.fabric.sdk.ProposalResponse;

/**
 *
 * @author Balaji Kadambi
 *
 */

public class QueryChaincode {

    private static final byte[] EXPECTED_EVENT_DATA = "!".getBytes(UTF_8);
    private static final String EXPECTED_EVENT_NAME = "event";

    //public static void main(String args[]) {
    public List<PlayerItem> queryRep(String testid){
        JSONObject returnObj = new JSONObject();
        try {
            Util.cleanUp();
            String caUrl = Config.CA_ORG1_URL;
            CAClient caClient = new CAClient(caUrl, null);
            // Enroll Admin to Org1MSP
            UserContext adminUserContext = new UserContext();
            adminUserContext.setName(Config.ADMIN);
            adminUserContext.setAffiliation(Config.ORG1);
            adminUserContext.setMspId(Config.ORG1_MSP);
            caClient.setAdminUserContext(adminUserContext);
            adminUserContext = caClient.enrollAdminUser(Config.ADMIN, Config.ADMIN_PASSWORD);

            FabricClient fabClient = new FabricClient(adminUserContext);

            ChannelClient channelClient = fabClient.createChannelClient(Config.CHANNEL_NAME);
            Channel channel = channelClient.getChannel();
            Peer peer = fabClient.getInstance().newPeer(Config.ORG1_PEER_0, Config.ORG1_PEER_0_URL);
            EventHub eventHub = fabClient.getInstance().newEventHub("eventhub01", "grpc://localhost:7053");
            Orderer orderer = fabClient.getInstance().newOrderer(Config.ORDERER_NAME, Config.ORDERER_URL);
            channel.addPeer(peer);
            channel.addEventHub(eventHub);
            channel.addOrderer(orderer);
            channel.initialize();

            Logger.getLogger(QueryChaincode.class.getName()).log(Level.INFO, "Querying for all cars ...");
            Collection<ProposalResponse>  responsesQuery = channelClient.queryByChainCode("fabcar", "queryAllCars", null);
            for (ProposalResponse pres : responsesQuery) {
                String stringResponse = new String(pres.getChaincodeActionResponsePayload());
                Logger.getLogger(QueryChaincode.class.getName()).log(Level.INFO, stringResponse);
                //stringResponse解析一下，时间戳（不行的话存储一个）
                System.out.println(stringResponse);
            }
            //return  stringResponse;


            Thread.sleep(10000);
            String[] args1 = {"1000011"};
            Logger.getLogger(QueryChaincode.class.getName()).log(Level.INFO, "Querying for a car - " + args1[0]);

            List<PlayerItem> list = new ArrayList<>();
            PlayerItem playerItem = null;
            JSONObject jsonObject = null;
            Collection<ProposalResponse>  responses1Query = channelClient.queryByChainCode("fabcar", "queryCar", args1);
            for (ProposalResponse pres : responses1Query) {
                String stringResponse = new String(pres.getChaincodeActionResponsePayload());
                Logger.getLogger(QueryChaincode.class.getName()).log(Level.INFO, stringResponse);
                jsonObject = (JSONObject) JSONObject.parse(stringResponse);
                playerItem = new PlayerItem();
                playerItem.setHashv(jsonObject.getString("hashv"));
                playerItem.setName(jsonObject.getString("name"));
                playerItem.setSign(jsonObject.getString("sign"));
                playerItem.setTestID(jsonObject.getString("testID"));

                list.add(playerItem);
            }

            return list;
            //returnObj.put("status","success");
            //return returnObj.toJSONString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
