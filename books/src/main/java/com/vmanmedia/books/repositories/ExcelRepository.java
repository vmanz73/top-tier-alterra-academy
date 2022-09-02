package com.vmanmedia.books.repositories;

import com.vmanmedia.books.entities.CoinPriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcelRepository extends JpaRepository<CoinPriceHistory, Long> {
}
