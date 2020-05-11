/****************************************************************************
 * Copyright (C) 2020 ecsec GmbH.
 * All rights reserved.
 * Contact: ecsec GmbH (info@ecsec.de)
 *
 * This file may be used in accordance with the terms and conditions
 * contained in a signed written agreement between you and ecsec GmbH.
 *
 ************************************************************************** */
package org.acme.amqp;

/**
 *
 * @author Neil Crossley
 */
public class PriceDouble {

    private Double price;

    public PriceDouble() {
    }

    public PriceDouble(Double price) {
	this.price = price;
    }


    public Double getPrice() {
	return price;
    }

    public void setPrice(Double price) {
	this.price = price;
    }

}
