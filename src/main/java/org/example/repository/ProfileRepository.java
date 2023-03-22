package org.example.repository;

import org.example.entity.ProfileEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {
    @Autowired
    private SessionFactory sessionFactory;

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
}
