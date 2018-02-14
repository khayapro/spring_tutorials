package com.example.events.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class UserTest {

    User user;

    @Before
    public void setup(){
       user = new User(UUID.randomUUID());
    }

    @Test
    public void should_change_name_on_activated() {
        user.changeName("Khaya");
        user.activate();
        assertThat(user.getName()).isEqualTo("Khaya");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_change_name_on_deactivated() {
        user.deactivate();
        user.changeName("Boitumelo");
    }

    @Test
    public void isActivated() {
    }

    @Test
    public void isDeactivated() {
    }

    @Test
    public void changeName() {
    }

    @Test
    public void getName() {
    }
}