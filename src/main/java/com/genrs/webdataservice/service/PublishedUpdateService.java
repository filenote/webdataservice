package com.genrs.webdataservice.service;

import com.genrs.webdataservice.model.web.entity.PublishedUpdate;
import com.genrs.webdataservice.repository.web.PublishedUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PublishedUpdateService {
    @Autowired
    private PublishedUpdateRepository publishedUpdateRepository;

    public PublishedUpdate addPublishedUpdate(PublishedUpdate publishedUpdate) {
        publishedUpdate.setId(UUID.randomUUID());
        System.out.println("[PublishedUpdateService] " + publishedUpdate);
        publishedUpdateRepository.addPublishedUpdate(publishedUpdate);
        return null;
    }

    public List<PublishedUpdate> getPublishedUpdates(Integer amount, Integer offset) {
        System.out.println("[PublishedUpdateService] getPublishedUpdate: " + amount + ":" + offset);
        return publishedUpdateRepository.getPublishedUpdates(amount, offset);
    }
}
