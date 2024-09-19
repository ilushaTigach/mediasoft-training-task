package org.telatenko.EqualsAndHashCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/*
Реализовать класс,
описывающий человека (имя, дата рождения, пол),
переопределить методы equals и
hashCode и написать unit-тесты для метода equals.
*/
@ToString
@Getter
@Setter
@AllArgsConstructor
 public class Human {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;


    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Human human = (Human) o;
        return Objects.equals(name, human.name) &&
                Objects.equals(dateOfBirth, human.dateOfBirth) &&
                gender == human.gender;
    }

    public int hashCode() {
        return Objects.hash(name, dateOfBirth, gender);
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
