package com.game.find_a_cat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class CatHidingService {

    private final CatPositionGenerateService catPosService;

    private int n;
    private int winTurn;
    private int[][] board;

    public CatHidingService(CatPositionGenerateService catPosService) {
        this.catPosService = catPosService;

        n = 3;
        winTurn = 0;
        board = new int[n][n];

        Arrays.fill(board[0], 0);
        assignCatIndex();
    }

    // winTurn = 0, n = 3
    // win first = 1 * (3 + 3) = 6
    // second = 2 * (6 + 6) = 24
    // third = 3 * (24 + 24) = 48 * 3 :)
    public boolean checkResult(int x, int y) {
        log.info("Checking result for x={} y={}", x, y);
        if (board[x][y] == 1) {
            winTurn = (winTurn + 1) % 4;
            n = calculateN();
            reGenerateBoard(n);
            return true;
        }
        return false;
    }

    public int getN() {
        log.info("Win turn {} current n={}", winTurn, n);
        return this.n;
    }

    private int calculateN() {
        log.info("Calculating n={} and win turn={}", n, winTurn);
        if (winTurn == 0) {
            n = 3;
        } else {
            n = winTurn * (n + n);
        }
        return n;
    }

    private void reGenerateBoard(int n) {
        this.board = new int[n][n];
        Arrays.fill(this.board[0], 0);
        assignCatIndex();
    }

    private void assignCatIndex() {
        int[] pos = catPosService.generateIndexOfCat(n);
        board[pos[0]][pos[1]] = 1;
    }
}
