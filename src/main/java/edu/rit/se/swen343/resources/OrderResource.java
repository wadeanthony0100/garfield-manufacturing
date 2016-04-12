package edu.rit.se.swen343.resources;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import edu.rit.se.swen343.api.Order;
import edu.rit.se.swen343.api.Order.ModelType;

/**
 * Provides endpoints related to orders for manufacturing.
 *
 * @author Brian Besmanoff (bbesmanoff)
 */
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {
	/**
	 * Gets all orders currently being processed by the system.
	 *
	 * @return all orders currently being processed by the system
	 */
	@GET
	public List<Order> getOrders() {
		return Arrays.asList(new Order(1, ModelType.BASIC), new Order(2,
				ModelType.HIGHEND));
	}

	/**
	 * Get a particular order as referenced by an id.
	 *
	 * @param id
	 *            the id of the order to search for
	 * @return the order whose id matches the provided input or an error
	 */
	@GET
	@Path("/{id}")
	public Order getOrder(@PathParam("id") int id) {
		if (id == 404) {
			throw new WebApplicationException("order not found for id=" + id, 404);
		}
		return new Order(id, ModelType.BASIC);
	}
}