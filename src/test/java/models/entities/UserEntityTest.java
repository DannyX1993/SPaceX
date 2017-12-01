package models.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Date;

public class UserEntityTest {

    @Test
    public void testUser() {
        Date date = new Date();
        User user = new User("test", "1234", Role.ADMIN, date);
        assertEquals("test", user.getNickname());
        assertEquals(Role.ADMIN, user.getRole());
        assertEquals(date, user.getLastAccess());
    }

}
