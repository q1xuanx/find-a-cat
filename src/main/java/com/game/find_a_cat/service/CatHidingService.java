package com.game.find_a_cat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.random.RandomGenerator;

@Service
@Slf4j
public class CatHidingService {

    private final RandomGenerator rng = RandomGenerator.of("Xoshiro256PlusPlus");

    private int n;
    private int winTurn;
    private int[][] board;

    public CatHidingService() {
        n = 3;
        winTurn = 0;
        board = new int[n][n];
        Arrays.fill(board[0], 0);
        generateIndexOfCat(board);
    }

    // winTurn = 0, n = 3
    // win first = 1 * (3 + 3) = 6
    // second = 2 * (6 + 6) = 24
    // third = 3 * (24 + 24) = 48 * 3 :)
    public boolean checkResult(int x, int y) {
        log.info("Checking result for x={} y={}", x, y);
        if (board[x][y] == 1) {
            winTurn = (winTurn + 1) % 3;
            if (winTurn == 0) {
                n = 3;
            } else {
                n = (winTurn + 1) * (n + n);
            }
            reGenerateBoard(n);
            return true;
        }
        return false;
    }

    public int getN() {
        log.info("Current n={}", n);
        return this.n;
    }

    private void generateIndexOfCat(int[][] board) {
        int x = rng.nextInt(0, board.length);
        int y = rng.nextInt(0, board[0].length);
        log.info("Generate index of cat {} {}", (x + 215), (y + 210));
        board[x][y] = 1;
    }

    private void reGenerateBoard(int n) {
        this.board = new int[n][n];
        Arrays.fill(this.board[0], 0);
        generateIndexOfCat(this.board);
    }
}
