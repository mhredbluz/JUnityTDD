package br.com.marcos;

import static org.junit.jupiter.api.Assertions.*;
import br.com.marcos.model.Person;
import br.com.marcos.service.IPersonService;
import br.com.marcos.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    Person person;
    IPersonService service;

    @BeforeEach
    void setUp(){
        service = new PersonService();
        person = new Person(
            "Marcos", "Henrique", "Brazil", "Male", "mhredbluz@gmail.com"
        );
    }

 // test[System Under Test]_[Condition or State Change]_[Expected Result]
     @DisplayName("When create a person with success should return a person object")
     @Test
     void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {

         //Given / Arrange
         //When / Act
         Person actual = service.createPerson(person);

         //Then / Assert
         assertNotNull(actual, () -> "The createPerson() should not have returned null!");
     }
     @DisplayName("When create a person with success should contains firstName in returned person Object")
     @Test
     void testCreatePerson_WhenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {

         //Given / Arrange
         //When / Act
         Person actual = service.createPerson(person);

         //Then / Assert
         assertNotNull(person.getId(), () -> "Person Id is missing");
         assertEquals(person.getFirstName(),actual.getFirstName(), () -> "The firstName is different");
         assertEquals(person.getLastName(),actual.getLastName(), () -> "The lastName is different");
         assertEquals(person.getAddress(),actual.getAddress(), () -> "The lastName is different");
         assertEquals(person.getEmail(),actual.getEmail(), () -> "The Email is different");
         assertEquals(person.getGender(),actual.getGender(), () -> "The lastName is different");
     }

      // test[System Under Test]_[Condition or State Change]_[Expected Result]
          @DisplayName("When create a person with null email should throw exception")
          @Test
          void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {
              //Given / Arrange
              person.setEmail(null);
              var expectedMessage = "The person email is null or is empty";
              //When / Act
              //Then / Assert
              IllegalArgumentException exception = assertThrows(
                      IllegalArgumentException.class,
                      () -> service.createPerson(person),
                      () -> "Empty email should have cause an IllegalArgumentException");
              System.out.print(exception.getMessage());

              assertEquals(expectedMessage, exception.getMessage(), ()-> "Exception error message is incorrect");
          }
}
