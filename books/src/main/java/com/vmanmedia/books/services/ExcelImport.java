package com.vmanmedia.books.services;

import com.vmanmedia.books.dtos.CoinPriceHistoryResponseDTO;
import com.vmanmedia.books.entities.CoinPriceHistory;
import com.vmanmedia.books.repositories.ExcelRepository;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ExcelImport implements IExcelImport{
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ExcelRepository excelRepository;

    @Override
    public List<CoinPriceHistoryResponseDTO> GenerateExcel(MultipartFile file) {
        System.out.println(file.getContentType());
        List<CoinPriceHistoryResponseDTO> result = new ArrayList<>();
        try(InputStream inputStream = file.getInputStream()){
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet1 = workbook.getSheet("schedule_coin_price_history (2)");
            Iterator<Row> it  = sheet1.iterator();
            while (it.hasNext()){
                Row row = it.next();
                if(row.getRowNum()==0){
                    continue; //just skip the rows if row number is 0 or 1
                }
                result.add(GenerateToDTO(row));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @SneakyThrows
    private CoinPriceHistoryResponseDTO GenerateToDTO(Row row){
        CoinPriceHistoryResponseDTO data = new CoinPriceHistoryResponseDTO();
        long id = (int)Double.parseDouble(row.getCell(0).toString());
        long coin_id = (int)Double.parseDouble(row.getCell(3).toString());
        int invalid = (int)Double.parseDouble(row.getCell(6).toString());
        int record_time = (int)Double.parseDouble(row.getCell(7).toString());
        int hsn = (int)Double.parseDouble(row.getCell(10).toString());

        data.setData_import_id(id);
        data.setName(String.valueOf(row.getCell(1)));
        data.setTicker(String.valueOf(row.getCell(2)));
        data.setCoin_id(coin_id);
        data.setCode(String.valueOf(row.getCell(4)));
        data.setExchange(row.getCell(5).toString());
        data.setInvalid(invalid);
        data.setRecord_time(record_time);
        long usd = (int)Double.parseDouble(row.getCell(8).toString());
        long idr = (int)Double.parseDouble(row.getCell(9).toString());
        data.setUsd(usd);
        data.setIdr(idr);
        data.setHnst(hsn);

        long eth = (int)Double.parseDouble(row.getCell(11).toString());
        long btc = (int)Double.parseDouble(row.getCell(12).toString());
        data.setEth(eth);
        data.setBtc(btc);
        Date created_at=new SimpleDateFormat("dd-MMM-yyyy").parse(row.getCell(13).toString());
        data.setCreated_at(created_at);
        Date update_at=new SimpleDateFormat("dd-MMM-yyyy").parse(row.getCell(13).toString());
        data.setUpdated_at(update_at);
        CoinPriceHistory coin = convertToEntity(data);
        excelRepository.save(coin);

        return data;
    }

    private CoinPriceHistory convertToEntity(CoinPriceHistoryResponseDTO resquestDTO) {
        return modelMapper.map(resquestDTO, CoinPriceHistory.class);
    }

    private CoinPriceHistoryResponseDTO convertToDto(CoinPriceHistory author) {
        return modelMapper.map(author, CoinPriceHistoryResponseDTO.class);
    }
}
