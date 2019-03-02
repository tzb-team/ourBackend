package Dao.service;

import entity.Captcha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface CaptchaRespository extends JpaRepository<Captcha,String> {

    @Query(value = "SELECT * from captcha where email=?1",nativeQuery = true)
    Captcha findByEmail (String email);

    @Transactional
    @Modifying
    @Query(value = "update captcha set captcha=?2 where email=?1",nativeQuery = true)
    void updateCaptcha(String email, String captcha);

    @Transactional
    @Modifying
    @Query(value = "insert into captcha(email,captcha)values(?1,?2)",nativeQuery = true)
    void insertCaptcha(String email, String captcha);
}
