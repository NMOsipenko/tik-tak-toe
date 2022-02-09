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

package com.github.nmosipenko.tiktaktoe.component;

import com.github.nmosipenko.tiktaktoe.model.Cell;
import com.github.nmosipenko.tiktaktoe.model.GameTable;

import java.util.Scanner;

/**
 * @author NMOsipenko
 * @link https://github.com/NMOsipenko/
 */
public class UserMove {
    public void make(GameTable gameTable) {

        while(true) {

            System.out.print("Please type number between 1 and 9:");

            int action = getUserAction();

            if (action < 1 || action > 9)
                continue;

            final Cell cell = MoveConveter.getCellByKey(action);
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, 'X');
                return;
            }

            System.out.println("Can't make a move, because the cell is not free! Try again!");
        }
    }

    private int getUserAction() {

        int action = 0;
        Scanner console = new Scanner(System.in);

        try {
            action = console.nextInt();
        } catch (Exception e) {

        }

        return action;
    }
}
