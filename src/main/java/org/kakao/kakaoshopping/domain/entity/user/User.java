package org.kakao.kakaoshopping.domain.entity.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.kakao.kakaoshopping.domain.entity.BaseEntity;
import org.kakao.kakaoshopping.domain.entity.embedded.PhoneNumber;
import org.kakao.kakaoshopping.domain.enums.UserType;

@Entity
@Table(name = "USER_TB")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String password;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
    private String nickname;

    @Embedded
    private PhoneNumber phoneNumber;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Builder
    public User(String email, String password, String name, String nickname, PhoneNumber phoneNumber, UserType userType) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
    }
}
