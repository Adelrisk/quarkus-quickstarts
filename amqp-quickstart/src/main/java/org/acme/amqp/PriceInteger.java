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
public class PriceInteger {

    private Integer price;

    public PriceInteger() {
    }

    public PriceInteger(Integer price) {
	this.price = price;
    }

    public Integer getPrice() {
	return price;
    }

    public void setPrice(Integer price) {
	this.price = price;
    }

}
