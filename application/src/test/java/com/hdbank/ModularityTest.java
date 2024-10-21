package com.hdbank;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityTest {

    private final ApplicationModules modules = ApplicationModules.of(NotificationServiceApplication.class);

    @Test
    void testModularity() {
        System.out.println(modules);
        modules.verify();
    }

    @Test
    void createDocumentation() {
        new Documenter(modules).writeDocumentation();
    }

}
