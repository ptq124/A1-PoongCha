package com.poongcha.recommend.domain.lifestylepersona;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class RepresentativePhrase {
    @Column("representative_phrase")
    private String value;
}
