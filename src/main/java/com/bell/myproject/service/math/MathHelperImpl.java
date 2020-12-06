package com.bell.myproject.service.math;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MathHelperImpl implements MathHelper{
    private int RANDOM_MIN = 1000;
    private int RANDOM_MAX = 10000;

    @Override
    public String createRandomUuidAsString() {
        int uuid = RANDOM_MIN + (int)(Math.random() * ((RANDOM_MAX - RANDOM_MIN) + 1));
        return Integer.toString(uuid);
    }
}
