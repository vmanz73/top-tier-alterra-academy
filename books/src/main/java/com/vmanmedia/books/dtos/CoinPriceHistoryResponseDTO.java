package com.vmanmedia.books.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(value = {"imported_at"}, allowGetters = true)
public class CoinPriceHistoryResponseDTO {

    private Long data_import_id;

    private String name;

    private String ticker;

    private Long coin_id;

    private String code;

    private  String exchange;

    private Integer invalid;

    private Integer record_time;
//
    private Long usd;
//
    private Long idr;
//
    private Integer hnst;
//
    private Long eth;
//
    private Long btc;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
    private Date created_at;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
    private Date updated_at;
}
