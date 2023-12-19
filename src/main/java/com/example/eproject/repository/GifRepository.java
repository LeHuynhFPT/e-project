package com.example.eproject.repository;

import com.example.eproject.entity.Gif;
import com.example.eproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GifRepository extends JpaRepository<Gif, Long> {
    Gif findGifByUrl(String imageUrl);
    Gif findGifById(Long id);

    Gif findGifByIdAndUser(Long id, User user);

    List<Gif> findByUser(User currentUser);
}
