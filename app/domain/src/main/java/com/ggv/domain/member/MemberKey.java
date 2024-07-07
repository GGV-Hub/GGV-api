package com.ggv.domain.member;

import java.util.UUID;

public class MemberKey {
    private final UUID key;

    private MemberKey(UUID key) {
        this.key = key;
    }

    public UUID getKey() {
        return key;
    }

    public static MemberKey from(UUID key) {
        return new MemberKey(key);
    }

    public static MemberKey create() {
        return new MemberKey(UUID.randomUUID());
    }
}
