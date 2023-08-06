package com.example.lms;

import com.example.lms.domain.entity.User;
import com.example.lms.domain.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.test.context.support.WithMockUser;

@DataJpaTest
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = AuditorAware.class))
public class AuditorAwareTest {

    @Autowired
    private UserRepository userRepository;

    private static final String email = "test@example.com";

    @Test
    @WithMockUser(value = email)
    void testAuditorAware() {
        // Given
        User user = User.createUser(email, "1234", "test");

        // When
        userRepository.save(user);

        // Then
        Assertions.assertEquals(email, user.getCreatedBy());
        Assertions.assertEquals(email, user.getUpdatedBy());
        Assertions.assertEquals(user.getCreatedAt(), user.getUpdatedAt());
    }
}
