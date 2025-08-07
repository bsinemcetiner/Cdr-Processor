package com.Argela.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import com.Argela.enums.Direction;
import com.Argela.enums.Result;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cdr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startTime;
    private Date endTime;
    private String imsi;
    private String imei;
    private Integer cellId;
    private Integer lacId;
    private String aNumber;
    private String bNumber;
    private Long setupDuration;
    private Long conversationDuration;
    @Enumerated(EnumType.STRING)
    private Direction direction;
    @Enumerated(EnumType.STRING)
    private Result result;
}