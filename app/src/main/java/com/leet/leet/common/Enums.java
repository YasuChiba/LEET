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

    public enum MealTime {
        Breakfast("breakfastMenu"),
        Lunch("lunchMenu"),
        Dinner("dinnerMenu");

        private final String text;

        private MealTime(final String text) {
            this.text = text;
        }

        public String getString() {
            return this.text;
        }
    }

    public enum UserDataItem {
        Statistics("statistics"),
        UserProfile("user_profile"),
        CustomMenus("custom_menus");

        private final String text;
        private UserDataItem(final String text) {
            this.text = text;
        }

        public String getString() {
            return this.text;
        }
    }

    public enum Gender {
        Male("male"),
        Female("female"),
        Other("other");

        private final String text;
        private Gender(final String text) {
            this.text = text;
        }

        public String getString() {
            return this.text;
        }

    }
}