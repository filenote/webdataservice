package com.genrs.webdataservice.controller;

import com.genrs.webdataservice.model.web.entity.PublishedUpdate;
import com.genrs.webdataservice.service.PublishedUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v0/published-update")
public class PublishedUpdateController {

    @Autowired
    private PublishedUpdateService publishedUpdateService;

    @PostMapping(value = "/")
    public PublishedUpdate addPublishedUpdate(@RequestBody PublishedUpdate publishedUpdate) {
        System.out.println("[PublishedUpdateController] " + publishedUpdate);
        publishedUpdateService.addPublishedUpdate(publishedUpdate);
        return null;
    }

    @GetMapping(value = "/{amount}:{offset}")
    public ResponseEntity getPublishedUpdate(
            @PathVariable(value = "amount") Integer amount,
            @PathVariable(value = "offset") Integer offset
    ) {
        System.out.println("[PublishedUpdateController] getPublishedUpdate: " + amount + ":" + offset);
        List<PublishedUpdate> publishedUpdates = publishedUpdateService.getPublishedUpdates(amount, offset);
        return ResponseEntity.ok()
                .header("more", Boolean.toString(publishedUpdates.size() == 6))
                .body(publishedUpdates.stream().limit(5).collect(Collectors.toList()));
    }
}
