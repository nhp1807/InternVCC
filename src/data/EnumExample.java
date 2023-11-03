package data;

public class EnumExample {
    enum Seasons{
        SRPING, SUMMER, FALL, WINTER
    }

    enum WeekDay{
        MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6);

        private int value;
        WeekDay(int value){
            this.value = value;
        }

        public static WeekDay getWeekDayByValue(int value) {
            for (WeekDay d : WeekDay.values()) {
                if (d.value == value) {
                    return d;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            if(value == 2){
                return "This is Monday";
            }else if(value == 3){
                return "This is Tuesday";
            }

            return "Other days";
        }
    }
    public static void main(String[] args) {
//        for(Seasons season : Seasons.values()){
//            System.out.println(season);
//        }

        WeekDay day = WeekDay.getWeekDayByValue(3);
//        System.out.println(day.toString());
        System.out.println(day);
    }
}
