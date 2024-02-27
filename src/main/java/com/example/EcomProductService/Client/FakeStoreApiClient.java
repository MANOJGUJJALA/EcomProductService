package com.example.EcomProductService.Client;


import com.example.EcomProductService.dto.FakeStoreProductRequestDTO;
import com.example.EcomProductService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreApiClient {

        RestTemplateBuilder restTemplateBuilder;

        @Value("${fakestore.api.path.product}")
        private String fakeStorePthProduct;
        private String fakeStoreApiUrl;

    public FakeStoreApiClient(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}")String fakeStoreApiUrl) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreApiUrl=fakeStoreApiUrl;
    }

    public FakeStoreProductResponseDTO getProductById(int id){

        String url=fakeStoreApiUrl+fakeStorePthProduct+"/"+id;
        System.out.println("url is "+url);
        RestTemplate restTemplate=restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductResponseDTO> singleProduct=restTemplate
                .getForEntity(url,FakeStoreProductResponseDTO.class);

        return singleProduct.getBody();

        }
        public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
            String url=fakeStoreApiUrl+fakeStorePthProduct;

            RestTemplate restTemplate=restTemplateBuilder.build();
            ResponseEntity<FakeStoreProductResponseDTO>createdProduct= restTemplate.postForEntity(url,fakeStoreProductRequestDTO,FakeStoreProductResponseDTO.class);
        return createdProduct.getBody();
        }

        public List<FakeStoreProductResponseDTO> getAllProducts(){
            String url=fakeStoreApiUrl+fakeStorePthProduct;

            RestTemplate restTemplate=restTemplateBuilder.build();
          ResponseEntity<FakeStoreProductResponseDTO[]>allprodcts=  restTemplate.getForEntity(url,FakeStoreProductResponseDTO[].class);

          return List.of(allprodcts.getBody());

        }

        public boolean deleteProductById(int id){
            String url=fakeStoreApiUrl+fakeStorePthProduct+"/"+id;

            RestTemplate restTemplate=restTemplateBuilder.build();
            restTemplate.delete(url);
            return  true;
        }


}
