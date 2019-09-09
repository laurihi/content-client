package fi.ambientia.sd.client.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("content-repository")
public interface ContentClient {

    static final String CONTENT_REPO_BASE_MAPPING = "/content";
    static final String CONTENT_REPO_ID_URL = CONTENT_REPO_BASE_MAPPING + "/id/{identifier}";

    @RequestMapping(method = RequestMethod.GET, value = CONTENT_REPO_ID_URL)
    String getContent(@PathVariable("identifier") String identifier);

}