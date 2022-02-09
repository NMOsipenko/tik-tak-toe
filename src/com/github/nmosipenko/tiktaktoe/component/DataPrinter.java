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
public class DataPrinter {

    final String line = "-------------";
    final String row = "| %s | %s | %s |";

    public void printMappingTable() {
        System.out.println(line);
        System.out.println(String.format(row, 7, 8, 9));
        System.out.println(line);
        System.out.println(String.format(row, 4, 5, 6));
        System.out.println(line);
        System.out.println(String.format(row, 1, 2, 3));
        System.out.println(line);

    }

    public void printGameTable(GameTable gameTable) {
        System.out.println(line);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + gameTable.getSign(new Cell(i, j)) + " ");
            }
            System.out.println("|");
            System.out.println(line);
        }
    }
}
