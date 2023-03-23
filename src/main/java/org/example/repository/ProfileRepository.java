package org.example.repository;

import org.example.entity.ProfileEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(ProfileEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public ProfileEntity getById(int id) {
        Session session = sessionFactory.openSession();
        ProfileEntity profile = session.find(ProfileEntity.class, id);
        session.close();
        return profile;
    }
    public ProfileEntity getByPhone(String phone) {
        String sql = String.format("Select * from profile where phone ='%s';", phone);
        List<ProfileEntity> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProfileEntity.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
