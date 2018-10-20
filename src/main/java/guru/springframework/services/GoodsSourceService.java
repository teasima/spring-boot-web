package guru.springframework.services;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Order;

public interface GoodsSourceService {

	GoodsSource getById(Integer id);

	GoodsSource save(GoodsSource Order) throws Exception;

    void delete(Integer id);
    
   Page<GoodsSource> list(Pageable pageable);


}
