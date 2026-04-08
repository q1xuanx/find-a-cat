package com.game.find_a_cat.controller;

import com.game.find_a_cat.dto.CatIndexPredictRequest;
import com.game.find_a_cat.service.CatHidingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cat")
public class CatHidingController {

    private final CatHidingService catHide;

    public CatHidingController(CatHidingService catHide) {
        this.catHide = catHide;
    }

    @GetMapping("/draw-board")
    public ResponseEntity<Integer> drawBoard () {
        return ResponseEntity.ok(catHide.getN());
    }

    @PostMapping("/check-result")
    public ResponseEntity<Map<String, Object>> checkResult(@RequestBody CatIndexPredictRequest request) {
        boolean status = catHide.checkResult(request.x, request.y);
        if (status) {
            Map<String, Object> result = Map.of(
                    "status", true,
                    "message", "You find the cat, go to next round"
            );
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.ok(Map.of(
                "status", false,
                "message", "Please try again, cat not here")
        );
    }

}
