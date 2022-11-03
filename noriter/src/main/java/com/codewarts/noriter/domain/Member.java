package com.codewarts.noriter.domain;

import com.codewarts.noriter.domain.article.Article;
import com.codewarts.noriter.oauth.ResourceServer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "writer")
    private final List<Article> articles = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private ResourceServer resourceServer;
    private Long resourceServerId;
    private String nickname;
    private String email;
    private String profileImageUrl;

    @Builder
    public Member(ResourceServer resourceServer, Long resourceServerId, String nickname, String email, String profileImageUrl) {
        this.resourceServer = resourceServer;
        this.resourceServerId = resourceServerId;
        this.nickname = nickname;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
    }
}
