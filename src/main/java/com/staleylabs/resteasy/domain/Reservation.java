package com.staleylabs.resteasy.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity that represents a reservation.
 *
 * @author Sean M. Staley
 * @version 1.0 (6/17/13)
 */

@Document(collection = "reservation")
public class Reservation implements Serializable {

    @Id
    private String reservationID;

    private String hotelID;

    private String customerID;

    private Date customerCheckIn;

    private Date customerCheckOut;

    private double baseCost;

    private double additionalCost;

    private double taxCost;

    private String additionalNotes;

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Date getCustomerCheckIn() {
        return customerCheckIn;
    }

    public void setCustomerCheckIn(Date customerCheckIn) {
        this.customerCheckIn = customerCheckIn;
    }

    public Date getCustomerCheckOut() {
        return customerCheckOut;
    }

    public void setCustomerCheckOut(Date customerCheckOut) {
        this.customerCheckOut = customerCheckOut;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public double getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(double additionalCost) {
        this.additionalCost = additionalCost;
    }

    public double getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(double taxCost) {
        this.taxCost = taxCost;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reservation)) {
            return false;
        }

        Reservation that = (Reservation) o;

        if (Double.compare(that.additionalCost, additionalCost) != 0) {
            return false;
        }
        if (Double.compare(that.baseCost, baseCost) != 0) {
            return false;
        }
        if (Double.compare(that.taxCost, taxCost) != 0) {
            return false;
        }
        if (!customerCheckIn.equals(that.customerCheckIn)) {
            return false;
        }
        if (!customerCheckOut.equals(that.customerCheckOut)) {
            return false;
        }
        if (!customerID.equals(that.customerID)) {
            return false;
        }
        if (!hotelID.equals(that.hotelID)) {
            return false;
        }
        if (reservationID != null ? !reservationID.equals(that.reservationID) : that.reservationID != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = reservationID != null ? reservationID.hashCode() : 0;
        result = 31 * result + hotelID.hashCode();
        result = 31 * result + customerID.hashCode();
        result = 31 * result + customerCheckIn.hashCode();
        result = 31 * result + customerCheckOut.hashCode();
        temp = Double.doubleToLongBits(baseCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(additionalCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(taxCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
