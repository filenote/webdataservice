package com.genrs.webdataservice.repository.web;

import com.genrs.webdataservice.model.web.entity.PublishedUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PublishedUpdateRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PublishedUpdate addPublishedUpdate(PublishedUpdate publishedUpdate) {
        String sql = "Call `genrs-web`.addPublishedUpdate(?, ?, ?, ?)";
        int rowsUpdated = jdbcTemplate.update(sql, preparedStatement -> {
            preparedStatement.setString(1, publishedUpdate.getId().toString());
            preparedStatement.setString(2, publishedUpdate.getUsername());
            preparedStatement.setString(3, publishedUpdate.getTitle());
            preparedStatement.setString(4, publishedUpdate.getMessage());
        });
        System.out.println(rowsUpdated);
        return null;
    }

    public List<PublishedUpdate> getPublishedUpdates(Integer amount, Integer offset) {
        String sql = "Call `genrs-web`.getPublishedUpdates(?, ?)";
        return jdbcTemplate.query(sql, preparedStatement -> {
            preparedStatement.setInt(1, amount + 1);
            preparedStatement.setInt(2, offset);
        }, (resultSet, i) -> new PublishedUpdate(
                UUID.fromString(resultSet.getString(1)),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                null,
                resultSet.getTimestamp(5).toLocalDateTime()));
    }
}
