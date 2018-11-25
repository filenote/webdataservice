package com.genrs.webdataservice.repository.server;

import com.genrs.webdataservice.model.server.entity.PlayerCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PlayerCredentialsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<PlayerCredentials> findPlayerByUsername(String username) {
        String sql = "SELECT BIN_TO_UUID(id), username, password FROM user WHERE user.username = ?";
        List<PlayerCredentials> credentialsList = jdbcTemplate.query(sql,
                preparedStatement -> preparedStatement.setString(1, username),
                (resultSet, i) -> new PlayerCredentials(
                        UUID.fromString(resultSet.getString(1)),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
        return credentialsList.size() == 1 ? Optional.of(credentialsList.get(0)) : Optional.empty();
    }
}
