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

import java.util.Random;

/**
 * @author NMOsipenko
 * @link https://github.com/NMOsipenko/
 */
public class ComputerMove {

    public void make(GameTable gameTable) {

        final Random rand = new Random();

        while (true) {
            int number = rand.nextInt(9) + 1;
            final Cell cell = MoveConveter.getCellByKey(number);
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, '0');
                return;
            }
        }
    }

}
