package fi.ambientia.sd.client.controllers;

import fi.ambientia.sd.client.clients.FeignContentClient;
import fi.ambientia.sd.client.clients.RibbonContentClient;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api
@RestController
@RequestMapping
public class ContentClientController {

    private FeignContentClient feignContentClient;
    private RibbonContentClient ribbonContentClient;

    public ContentClientController(@Autowired FeignContentClient feignContentClient,
                                   @Autowired RibbonContentClient ribbonContentClient){
        this.feignContentClient = feignContentClient;
        this.ribbonContentClient = ribbonContentClient;
    }
    @GetMapping("/feign")
    public String getContentUsingFeign() {
        return feignContentClient.getContent("Feign-client");
    }

    @GetMapping("/ribbon")
    public String getContentUsingRibbon() {
        return ribbonContentClient.getContents("Ribbon-client");
    }
}
