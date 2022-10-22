package ru.gb.jbulldog.units;

public class Human {
    private Profession profession;

    public Human(final Profession profession) {
        this.profession = profession;
    }

    public Profession getProfession() {
        return profession;
    }

    public enum Profession {
        /*
        * Не нарушает ли размещение перечисления здесь принцип открытость/закрытости,
        * т.к. делает невозможным добавление иной профессии,
        * нежели содержащиеся в перечислении? В т.ч у потомков Human.
        */
        NONE(0),
        TRADER(1),
        FARMER(2),
        BANKER(3);

        private final int code;

        Profession(final int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
