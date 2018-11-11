package com.diploma.edbot.bot.core.model.domain;

import com.diploma.edbot.bot.core.model.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class DomainUser {

    @Id
    @Column(name = "guid", updatable = false, unique = true, nullable = false)
    private UUID guid;

    @Column(name = "viber_id")
    private String viberId;

    @Column(name = "viber_name")
    private String viberName;

    @Column(name = "viber_avatar")
    private String viberAvatar;

    @Column(name = "viber_country")
    private String viberCountry;

    @Column(name = "viber_language")
    private String viberLanguage;

    @Column(name = "viber_api_version")
    private String viberApiVersion;

    @Column(name = "grade_book_number")
    private String gradeBookNumber;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "subscribed")
    private Boolean subscribed;

    public void setUser(User user) {
        this.viberId = user.getId();
        this.viberName = user.getName();
        this.viberAvatar = user.getAvatar();
        this.viberCountry = user.getCountry();
        this.viberLanguage = user.getLanguage();
        this.viberApiVersion = user.getApiVersion();
    }
}
