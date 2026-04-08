package com.game.find_a_cat;

import com.game.find_a_cat.service.CatHidingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class FindACatApplication {

	public static void main(String[] args) {
        SpringApplication.run(FindACatApplication.class, args);
        log.info("{} started complete", CatHidingService.class.getName());
	}

}
