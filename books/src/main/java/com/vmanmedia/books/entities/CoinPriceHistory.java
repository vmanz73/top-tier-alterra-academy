package com.vmanmedia.books.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

@Entity(name = "CoinPriceHistory")
@Table(name = "coin")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class CoinPriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long data_import_id;

    private String name;

    private String ticker;

    private Long coin_id;

    private String code;

    private String exchange;

    private Integer invalid;

    private Integer record_time;

    private BigDecimal usd;

    private BigDecimal idr;

    private Integer hnst;

    private BigDecimal eth;

    private BigDecimal btc;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @CreationTimestamp
    private Date imported_at;
}
