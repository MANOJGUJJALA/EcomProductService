package com.example.EcomProductService.service;

import com.example.EcomProductService.modal.Product;
import com.example.EcomProductService.modal.SortParam;
import com.example.EcomProductService.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PageRanges;
import java.util.List;

@Service
public class SearchService {

    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> searchProducts(String query, int pageNumber, int pageSize, List<SortParam> sortParams){

        Sort sort=null;
        if(sortParams.get(0).getSortType().equals("ASC")){

        sort=Sort.by(sortParams.get(0).getSortParamName()).ascending();
        }
        else{
            sort=Sort.by(sortParams.get(0).getSortParamName()).descending();
        }

        for(int i=1;i<sortParams.size();i++){
            if(sortParams.get(0).getSortType().equals("ASC")){

                sort.and(Sort.by(sortParams.get(i).getSortParamName()).ascending());
            }
            else{
                sort.and(Sort.by(sortParams.get(i).getSortParamName()).descending());
            }
        }
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
       List<Product>products= productRepository.findAllByTitle(query,  pageable);

       return products;
    }
}
