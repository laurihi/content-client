package fi.ambientia.sd.client.controllers;

import fi.ambientia.sd.client.clients.ContentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ContentClientController {

    private ContentClient contentClient;

    public ContentClientController(@Autowired ContentClient contentClient){
        this.contentClient = contentClient;
    }
    @GetMapping("/feign")
    public String getContentUsingFeign() {
        return contentClient.getContent("Feign-client");
    }

}
