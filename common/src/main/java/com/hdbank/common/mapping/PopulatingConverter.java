package com.hdbank.common.mapping;

import com.hdbank.common.annotation.Application;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Application
@NoArgsConstructor
public class PopulatingConverter<SOURCE, TARGET> {

    private Class<TARGET> targetClass;

    private final List<Populator> populators = new ArrayList<>();

    public PopulatingConverter(Class<TARGET> targetClass) {
        this.targetClass = targetClass;
    }

    private TARGET createFromClass() {
        try {
            return targetClass.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <SOURCE, TARGET> PopulatingConverter<SOURCE, TARGET> of(Class<TARGET> targetClass) {
        return new PopulatingConverter<>(targetClass);
    }

    public TARGET convert(SOURCE source) {
        TARGET target = createFromClass();
        populators.forEach(populator -> populator.populate(source, target));
        return target;
    }

    public <SOURCE, TARGET> void addPopulator(Populator<SOURCE, TARGET> populator) {
        Optional.ofNullable(populator)
                .ifPresent(populators::add);
    }

    public <SOURCE, TARGET> PopulatingConverter<SOURCE, TARGET> withPopulator(Populator<SOURCE, TARGET> populator) {
        addPopulator(populator);
        return (PopulatingConverter<SOURCE, TARGET>) this;
    }
}
