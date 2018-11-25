package com.genrs.webdataservice.model.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "published_update")
public class PublishedUpdate {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Column(name = "published")
    private LocalDateTime published;

    @Override
    public String toString() {
        return "PublishedUpdate{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", published=" + published +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LocalDateTime getPublished() {
        return published;
    }

    public void setPublished(LocalDateTime published) {
        this.published = published;
    }

    public PublishedUpdate() {
    }

    public PublishedUpdate(UUID id, String username, String title, String message, LocalDateTime lastUpdate, LocalDateTime published) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.message = message;
        this.lastUpdate = lastUpdate;
        this.published = published;
    }
}
