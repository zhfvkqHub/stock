package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public void decrease(Long id, Long quantity) {

        // get stock
        Stock stock = stockRepository.findById(id)
                .orElseThrow();
        // 재고 감소
        stock.decrease(quantity);
        // 저장
        stockRepository.saveAndFlush(stock);

    }

}
