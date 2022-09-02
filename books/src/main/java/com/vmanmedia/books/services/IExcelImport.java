package com.vmanmedia.books.services;

import com.vmanmedia.books.dtos.CoinPriceHistoryResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IExcelImport {

    List<CoinPriceHistoryResponseDTO> GenerateExcel(MultipartFile file);
}
