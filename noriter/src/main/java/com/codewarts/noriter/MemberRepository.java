package com.codewarts.noriter;

import com.codewarts.noriter.domain.Member;
import com.codewarts.noriter.oauth.ResourceServer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByResourceServerAndResourceServerId(ResourceServer resourceServer, Long resourceServerId);
}
