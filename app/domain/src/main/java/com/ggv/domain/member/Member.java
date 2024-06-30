package com.ggv.domain.member;

import com.ggv.domain.resource.Image;

import java.time.ZonedDateTime;

public class Member {
    private final MemberId id;
    private final MemberKey key;
    private final String name;
    private final Image profileImage;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
    private final ZonedDateTime deletedAt;

    public MemberId getId() {
        return id;
    }

    public MemberKey getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public Image getProfileImage() {
        return profileImage;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public ZonedDateTime getDeletedAt() {
        return deletedAt;
    }

    private Member(MemberId id, MemberKey key, String name, Image profileImage, ZonedDateTime createdAt, ZonedDateTime updatedAt, ZonedDateTime deletedAt) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.profileImage = profileImage;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Member create(
            String name,
            String profileImage
    ) {
        return new Member(null, MemberKey.create(), name, Image.from(profileImage), ZonedDateTime.now(), ZonedDateTime.now(), null);
    }
}
