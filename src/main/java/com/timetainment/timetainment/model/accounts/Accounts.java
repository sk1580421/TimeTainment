package com.timetainment.timetainment.model.accounts;

import com.timetainment.timetainment.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity {

    @Column(name="user_id")
    private Long userId;

    @Column(name="account_number")
    @Id
    private Long accountNumber;

    @Column(name="account_type")
    private String accountType;

    @Column(name="branch_address")
    private String branchAddress;

}