package com.Daniel.dog;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
/**
 * Created by Daniel on 12/13/16.
 */
public class DogTest {

    @Test
    public void whenFleasReceivedThenChangedFleaCount() throws Exception {
        //Arrange
        Dog d = new Dog("Fido");

        //Act
        d.changeFleas(4);

        //Assert
        assertThat(d.getNumFleas(), equalTo(4) );
    }

    @Test(expected = Exception.class)
    public void whenFleasAreTooMany() throws Exception {
        //Arrnage
        Dog d = new Dog("Jack");

        //Act
        d.changeFleas(6000);

    }
}
