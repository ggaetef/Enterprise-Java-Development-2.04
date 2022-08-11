package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    Person person1;
    Person person2;

    //Antes de ejecutar el test, se crea el objeto persona
    @BeforeEach
    public void setUp() throws Exception {
       person1 = new Person(100, "Gonzalo", 30, "Marketing");
       person2 = new Person(102,"Andres", 40, "Ventas");
    }

    //Acertar, si no dará fallo
    @Test
    public void testPerson1(){
        assertEquals(100,person1.getId());
        assertEquals("Gonzalo",person1.getName());
        assertEquals(30,person1.getAge());
        assertEquals("Marketing",person1.getOccupation());
        try {
            person1.setAge(31);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(31,person1.getAge());
        person1.setOccupation("Developer");
        assertEquals("Developer",person1.getOccupation());

    }

    @Test
    public void testPerson2(){
        assertEquals(102,person2.getId());
        assertEquals("Andres",person2.getName());
        assertEquals(40,person2.getAge());
        assertEquals("Ventas",person2.getOccupation());

        //Cuando seteo un negativo, lanza una exception
        Exception exception = assertThrows(Exception.class, () -> person2.setAge(-4));
        assertEquals("Edad debe ser mayor a 0", exception.getMessage());

        //Vuelo a test para que la edad se mantuvo y no cambió por valor negativo.
        assertEquals(40,person2.getAge());
        person2.setOccupation("Developer");
        assertEquals("Developer",person2.getOccupation());

    }



}