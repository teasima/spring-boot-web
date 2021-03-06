package guru.springframework.services;

import guru.springframework.domain.CarrierVehicle;
import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Product;
import guru.springframework.domain.Seller;
import guru.springframework.repositories.CarrierVehicleRepository;
import guru.springframework.repositories.ProductDAO;
import guru.springframework.repositories.ProductRepository;
import guru.springframework.repositories.ProfitJpaSpecificationExecutor;
import guru.springframework.repositories.SellerRepository;
import guru.springframework.util.BeanUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Log
@Service
@Getter
@Setter
public class CarrierVehicleServiceImpl implements CarrierVehicleService {
	@Autowired
	private CarrierVehicleRepository CarrierVehicleRepository;

	@Override
	public CarrierVehicle getById(Integer id) {
		// TODO Auto-generated method stub
		return CarrierVehicleRepository.findById(id).orElse(null);
	}

	@Override
	public CarrierVehicle save(CarrierVehicle CarrierVehicle) throws DataIntegrityViolationException {
		log.log(Level.INFO, "save");
		if (CarrierVehicle.getId() != null && CarrierVehicle.getId() > 0) {

			CarrierVehicle db = CarrierVehicleRepository.findById(CarrierVehicle.getId()).orElse(null);
			BeanUtils.copyPropertiesIgnoreNull(CarrierVehicle, db);
			return CarrierVehicleRepository.save(db);
		} else{
			return CarrierVehicleRepository.save(CarrierVehicle);
		}
	}

	@Override
	public void delete(Integer id) {
		log.log(Level.INFO, "deleteCarrierVehicle called");
		CarrierVehicleRepository.deleteById(id);
	}

	@Override
	public Page<CarrierVehicle> list(Pageable pageable) {
		// TODO Auto-generated method stub
		return CarrierVehicleRepository.findAll(pageable);
	}

}
