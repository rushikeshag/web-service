package com.lotusstack.webservices.jpa;

import com.lotusstack.webservices.db.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<Post, Integer> {
}
