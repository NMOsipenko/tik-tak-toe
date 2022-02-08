/*
 * Copyright (c) 2022. http://github.com/NMOsipenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.nmosipenko.tiktaktoe;

import java.util.Random;

/**
 * @author NMOsipenko
 * @link https://github.com/NMOsipenko/
 */
public class Game {

    private final DataPrinter dataPrinter;
    private final ComputerMove computerMove;
    private final UserMove userMove;
    private final WinnerVerifier winnerVerifier;
    private final DrawVerifier drawVerifier;

    public Game(
            DataPrinter dataPrinter,
            ComputerMove computerMove,
            UserMove userMove,
            WinnerVerifier winnerVerifier,
            DrawVerifier drawVerifier) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerVerifier = winnerVerifier;
        this.drawVerifier = drawVerifier;
    }

    public void play() {

        final GameTable gameTable = new GameTable();
        System.out.println(
                "Use the following mapping table to specify a cell using numbers from 1 to 9:");
        dataPrinter.printMappingTable();

        if (new Random().nextBoolean()) {
            computerMove.make();
            dataPrinter.printGameTable();
        }

        while (true) {
            userMove.make();
            dataPrinter.printGameTable();
            if (winnerVerifier.isUserWin(gameTable)) {
                System.out.println("YOU WIN!");
                break;
            }

            if (drawVerifier.isDraw()) {
                System.out.println("Sorry, DRAW!");
                break;
            }

            computerMove.make();
            dataPrinter.printGameTable();
            if (winnerVerifier.isComputerWin(gameTable)) {
                System.out.println("YOU WIN!");
                break;
            }

            if (drawVerifier.isDraw()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }

        System.out.println("GAME OVER!");

    }
}