package com.leet.leet.common;

/**
 * Created by YasuhiraChiba on 2017/11/04.
 */


public class Enums {

    public enum RestaurantName {
        Degrees("64 Degrees (Revelle College)"),
        CafeVentanas("Cafe Ventanas (Roosevelt College)"),
        Canyon("Canyon Vista (Warren College)"),
        Foodworx("Foodworx (Sixth College)"),
        OceanView("OceanView (Marshall College)"),
        Pines("Pines (Muir College)"),
        ;

        private final String text;

        private RestaurantName(final String text) {
            this.text = text;
        }

        public String getString() {
            return this.text;
        }
    }
}