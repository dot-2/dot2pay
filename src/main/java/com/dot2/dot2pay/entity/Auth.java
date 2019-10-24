package com.dot2.dot2pay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auth extends AuditModel {

    private static final long serialVersionUID = -6085376378706176626L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private AuthType authType;

    // 账号，比如 手机号 邮箱账号 用户名 等等
    @Column(length = 32,nullable = false)
    private String name;

    // 密码 或者 第三方登陆的 token
    @Column(length = 100,nullable = false)
    private String hash;

    // 账号是否验证，第三方登陆总是已验证
    private Boolean verify = false;

    // 是否是第三方登陆
    private Boolean third = false;

    private Long ip = 0L;

    // 属于某个用户的授权
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE) // 用户信息删除，自动删除授权信息
    private User user;

    public enum AuthType {
        Username(1),
        Email(2),
        Phone(3),
        WeChat(4),
        Qq(5),
        WeiBo(6),
        ;

        private Integer code;

        AuthType(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

    }
}
