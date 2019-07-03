package com.example.jungho.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder // builder를 사용할수 있게 합니다.
@Entity // jpa entity임을 알립니다.
@Getter // user 필드값의 getter를 자동으로 생성합니다.
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성합니다.
public class User implements UserDetails {


    @Id // primaryKey임을 알립니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  pk생성전략을 DB에 위임한다는 의미입니다. mysql로 보면 pk 필드를 auto_increment로 설정해 놓은 경우로 보면 됩니다.
    private int msrl;

    @Column(nullable = false, unique = true, length = 30) // uid column을 명시합니다. 필수이고 유니크한 필드이며 길이는 30입니다.
    private String uid;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100) // name column을 명시합니다. 필수이고 길이는 100입니다.
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)   // json결과로 출력 안 할 데이터는 어노테이션 선언
    @Override
    public String getUsername() { //security에서 사용하는 회원 구분 id 여기서는 uid로 변경
        return this.uid;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {  //계정이 만료가 안되었는지
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {  //계정이 잠기지 않았는지
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {  //계정 패스워드가 만료 안됬는지
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() { //계정이 사용 가능한지
        return true;
    }
}