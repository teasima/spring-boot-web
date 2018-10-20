package guru.springframework.controllers;

import guru.springframework.domain.Order;
import guru.springframework.domain.Product;
import guru.springframework.repositories.OrderRepository;
import guru.springframework.services.OrderService;
import guru.springframework.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Getter
@Setter
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@ApiOperation(value = "Search a product with an ID", response = Product.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public Order showProduct(@PathVariable Integer id, Model model) {
		Order product = orderService.getOrderById(id);
		return product;
	}

	@ApiOperation(value = "Add a product")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveProduct(@RequestBody Order product) {
		orderService.saveOrder(product);
		return new ResponseEntity("Product saved successfully", HttpStatus.OK);
	}

}