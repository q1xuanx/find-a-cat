package com.game.find_a_cat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.random.RandomGenerator;

@Component
@Slf4j
public class CatPositionGenerateService {

    private final RandomGenerator rng = RandomGenerator.of("Xoshiro256PlusPlus");

    public int[] generateIndexOfCat(int n) {
        int x = rng.nextInt(0, n);
        int y = rng.nextInt(0, n);
        log.info("Generate index of cat {} {}", (x + 215), (y + 210));
        return new int[]{x, y};
    }
}
