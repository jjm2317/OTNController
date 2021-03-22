package com.woorinet.plugin.demo.DTO.PORTAL;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortalMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;

    public PortalMember(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static PortalMember createMember(String email, String password) {
        return new PortalMember(email,password);
    }

}