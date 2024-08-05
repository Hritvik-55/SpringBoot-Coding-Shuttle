package com.rivia.CurrencyConvertor.Controller;

import com.rivia.CurrencyConvertor.Services.CurrencyConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversion")
@RequiredArgsConstructor
public class CurrencyConverter {
    private final CurrencyConvertor currencyConvertor;

    @GetMapping
    private Double INDToUSD(@RequestParam String baseCurrency,@RequestParam String targetCurrency,@RequestParam Double amount){
        return currencyConvertor.convertINRToUSD(baseCurrency,targetCurrency,amount);
    }
}
