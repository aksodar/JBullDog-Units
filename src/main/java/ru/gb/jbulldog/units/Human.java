package ru.gb.jbulldog.units;

public class Human {
    private Profession profession; // думаю здесь нарушен принцип Dependency inversion, т.к. "внешний" класс
                                   // высокого уровня не должен зависеть от внутреннего класса низкого уровня
    public Human(final Profession profession) {
        this.profession = profession;
    }

    public Profession getProfession() {
        return profession;
    }

    public enum Profession {
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
