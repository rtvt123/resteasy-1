package com.staleylabs.resteasy.api;

import com.staleylabs.resteasy.dto.ReservationTO;
import com.staleylabs.resteasy.exception.InsufficientInformationException;
import com.staleylabs.resteasy.service.ReservationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RESTful APIs for all things regarding the reservation system of the application.
 *
 * @author Sean M. Staley
 * @version 1.0 (9/2/13)
 */

@Controller
@RequestMapping(value = "/api/reservation")
public class ReservationApiController {

    private static final Logger LOGGER = Logger.getLogger(ReservationApiController.class.getName());

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewReservation(@RequestBody ReservationTO reservation, boolean sendEmail) {
        LOGGER.debug("Creating new reservation...");

        try {
            reservationService.createNewReservation(reservation);
        } catch (InsufficientInformationException e) {

        }
    }

}
