package com.rivia.CurrencyConvertor.Services.Impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rivia.CurrencyConvertor.Services.CurrencyConvertor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
@Service
@Slf4j
public class CurrencyConvertorImpl implements CurrencyConvertor {
    private final RestClient currencyRestClient;
    @Value("${api.key}")
    private String API_KEY;



    @Override
    public Double convertINRToUSD(String baseCurrency, String convertedCurrency, Double units) {
        ResponseEntity<String> response = currencyRestClient.get().uri(uriBuilder ->
                        uriBuilder.queryParam("apikey", API_KEY)
                                .queryParam("base_currency", baseCurrency)
                                .queryParam("currencies", convertedCurrency).build())
                .retrieve()
                .toEntity(String.class);
        log.info(String.valueOf(response));

        if(response.getStatusCode().is2xxSuccessful()){
            String responseBody=response.getBody();
            try{
                ObjectMapper objectMapper=new ObjectMapper();
                JsonNode rootNode=objectMapper.readTree(responseBody);
                JsonNode dataNode=rootNode.get("data");
                if(dataNode!=null){
                    JsonNode usdNode=dataNode.get(convertedCurrency);
                    if(usdNode!=null && usdNode.isDouble()){
                        Double conversionRate=usdNode.asDouble();
                        return conversionRate*units;
                    }
                }


            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }


        return null;
    }
}
