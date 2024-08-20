package com.miraijr.examing.modules.user.domain;

import java.util.Arrays;
import java.util.List;

import com.miraijr.examing.modules.user.domain.exceptions.InvalidGender;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Gender {
    private static final List<Integer> ACCEPTANCE_GENDER = Arrays.asList(0, 1);
    private Integer value;

    public Gender(Integer value) {
        this.setValue(value);
    }

    private void setValue(Integer value) {
        if (!ACCEPTANCE_GENDER.contains(Integer.valueOf(value))) {
            throw new InvalidGender();
        }

        this.value = Integer.valueOf(value);
    }
}
