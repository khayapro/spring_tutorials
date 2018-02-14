package com.example.events.model;

import org.junit.Before;
import org.junit.Test;
import java.util.UUID;
import static org.assertj.core.api.Assertions.*;

public class UserTest {

    User user;

    @Before
    public void setup(){
       user = new User(UUID.randomUUID());
    }

    @Test
    public void should_change_name_on_activated() {
        user.activate();
        user.changeName("Khaya");
        assertThat(user.getName()).isEqualTo("Khaya");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_change_name_on_deactivated() {
        user.deactivate();
        user.changeName("Boitumelo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_deactivate_a_deactivated_user() {
        user.deactivate();
        user.changeName("Boitumelo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_activate_an_activated() {
        user.deactivate();
        user.changeName("Boitumelo");
    }

    @Test
    public void should_activate_user_that_is_deactivated() {
        //given
        user.deactivate();
        assertThat(user.isDeactivated()).isTrue();
        //when
        user.activate();
        //then
        assertThat(user.isActivated()).isTrue();
    }

    @Test
    public void should_deactivate_user_that_is_activated() {
        //given
        user.activate();
        assertThat(user.isActivated()).isTrue();
        //when
        user.deactivate();
        //then
        assertThat(user.isDeactivated()).isTrue();
    }

    @Test
    public void getName() {
        user.changeName("Greg");
        assertThat(user.getName()).isEqualTo("Greg");
    }
}