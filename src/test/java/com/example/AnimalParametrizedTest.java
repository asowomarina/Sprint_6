package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)

public class AnimalParametrizedTest {
    private final String animalKind;
    private final List<String> expectedListOfFood;

    public AnimalParametrizedTest(String animalKind, List<String> expectedListOfFood) {
        this.animalKind = animalKind;
        this.expectedListOfFood = expectedListOfFood;
    }

    @Parameterized.Parameters
    public static Object[][] setTestsParams() {
        return new Object[][] {
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")}
        };
    }

    @Test
    public void getFoodTest() throws Exception {
        MatcherAssert.assertThat("Неправильный набор еды",
                new Animal().getFood(animalKind),
                equalTo(this.expectedListOfFood)
        );
    }

}