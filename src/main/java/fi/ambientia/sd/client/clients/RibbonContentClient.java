package fi.ambientia.sd.client.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.client.RestTemplate;

@RibbonClient("content-repository")
public class RibbonContentClient {

    private static final String CONTENT_REPOSITORY_BASE = "http://content-repository/content";
    private static final String CONTENT_REPOSITORY_GET_BY_ID = CONTENT_REPOSITORY_BASE + "/id/";

    private RestTemplate restTemplate;

    public RibbonContentClient(@Autowired RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }

    public String getContents(String id){
        return this.restTemplate.getForObject(CONTENT_REPOSITORY_GET_BY_ID+id, String.class);
    }

}
