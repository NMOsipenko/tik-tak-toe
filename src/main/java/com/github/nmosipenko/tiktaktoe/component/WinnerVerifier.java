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

/**
 * @author NMOsipenko
 * @link https://github.com/NMOsipenko/
 */
public class WinnerVerifier {
    public boolean isUserWin(GameTable gameTable) {
        return isWinner(gameTable, 'X');
    }

    public boolean isComputerWin(GameTable gameTable) {
        return isWinner(gameTable, '0');
    }

    public boolean isWinner(GameTable gameTable, char ch) {

        //coll check
        for (int i = 1; i < 4; i++) {
            Cell cell = MoveConveter.getCellByKey(i);
            if (gameTable.getSign(cell) == ch) {
                Cell cell2 = MoveConveter.getCellByKey(i + 3);
                if (gameTable.getSign(cell2) == ch) {
                    Cell cell3 = MoveConveter.getCellByKey(i + 6);
                    if (gameTable.getSign(cell3) == ch) {
                        return true;
                    }
                }
            }
        }

        //row check
        for (int i = 1; i < 8; i += 3) {
            Cell cell = MoveConveter.getCellByKey(i);
            if (gameTable.getSign(cell) == ch) {
                Cell cell2 = MoveConveter.getCellByKey(i + 1);
                if (gameTable.getSign(cell2) == ch) {
                    Cell cell3 = MoveConveter.getCellByKey(i + 2);
                    if (gameTable.getSign(cell3) == ch) {
                        return true;
                    }
                }
            }
        }

        // x chech
        Cell cell = MoveConveter.getCellByKey(5);
        if(gameTable.getSign(cell) == ch) {

            Cell cell2 = MoveConveter.getCellByKey(1);
            if (gameTable.getSign(cell2) == ch) {
                Cell cell3 = MoveConveter.getCellByKey(9);
                if (gameTable.getSign(cell3) == ch) {
                    return true;
                }
            }

            cell2 = MoveConveter.getCellByKey(3);
            if (gameTable.getSign(cell2) == ch) {
                Cell cell3 = MoveConveter.getCellByKey(7);
                if (gameTable.getSign(cell3) == ch) {
                    return true;
                }
            }
        }

        return false;
    }
}

