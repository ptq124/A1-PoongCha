package com.poongcha.recommend.domain.lifestylepersona;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LifestylePersonaProfile {
    @Column("profile_image_url")
    private String imageUrl;

    @Column("profile_name")
    private String name;

    @Column("profile_introduction")
    private String introduction;
}
