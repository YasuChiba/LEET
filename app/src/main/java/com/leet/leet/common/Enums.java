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

        public int getIndex() {
            if(this.text == "breakfastMenu") {
                return 0;
            } else if(this.text == "lunchMenu") {
                return 1;
            } else if(this.text == "dinnerMenu") {
                return 2;
            } else {
                return -1;
            }

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
    public enum UserProfile{
        goals("goals"),
        info("info");

        private final String text;
        private UserProfile(final String text) {
            this.text = text;
        }

        public String getString() {
            return this.text;
        }
    }

    public enum Week {
        Monday(1),
        Tuesday(2),
        Wednesday(3),
        Thursday(4),
        Friday(5),
        Saturday(6),
        Sunday(7);

        private final int val;
        private Week(final int val) {
            this.val = val;
        }

        public static Week create(int val) {
            switch(val) {
                case 1:
                    return Week.Monday;
                case 2:
                    return Week.Tuesday;
                case 3:
                    return Week.Wednesday;
                case 4:
                    return Week.Thursday;
                case 5:
                    return Week.Friday;
                case 6:
                    return Week.Saturday;
                case 7:
                    return Week.Sunday;
            }
            return Week.Monday;
        }

        public String getString() {
            switch(this.val) {
                case 1:
                    return "Monday";
                case 2:
                    return "Tuesday";
                case 3:
                    return "Wednesday";
                case 4:
                    return "Thursday";
                case 5:
                    return "Friday";
                case 6:
                    return "Saturday";
                case 7:
                    return "Sunday";
            }
            return "";
        }
    }


    public enum GraphElements {

        Calorie,
        Price,
        Protein,
        Fat,
        Carb;

    }

}