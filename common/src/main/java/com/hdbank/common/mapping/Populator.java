package com.hdbank.common.mapping;

public interface Populator <SOURCE, TARGET> {
    void populate(SOURCE source, TARGET target);
}
