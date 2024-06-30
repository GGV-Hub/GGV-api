package com.ggv.domain.member;

public class MemberId {
    private final Long id;

    private MemberId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static MemberId from(Long id) {
        return new MemberId(id);
    }
}
