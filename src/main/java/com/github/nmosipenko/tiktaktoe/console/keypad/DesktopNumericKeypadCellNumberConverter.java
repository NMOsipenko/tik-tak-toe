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

package com.github.nmosipenko.tiktaktoe.console.keypad;

import com.github.nmosipenko.tiktaktoe.console.CellNumberConverter;
import com.github.nmosipenko.tiktaktoe.model.Cell;

import static java.lang.String.format;

/**
 * @author NMOsipenko
 * @link https://github.com/NMOsipenko/
 */
public class DesktopNumericKeypadCellNumberConverter implements CellNumberConverter {

    private final char[][] mapping = {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'}
    };

    @Override
    public Cell toCell(final char number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mapping[i][j] == number) {
                    return new Cell(i, j);
                }
            }
        }
        throw new IllegalArgumentException(
                format("Number parameter must be between '1' and '9'! Current value is '%s'!", number)
        );
    }

    @Override
    public char toNumber(final Cell cell) {
        try {
            return mapping[cell.getRow()][cell.getCol()];
        } catch (final ArrayIndexOutOfBoundsException ignore) {
            throw new IllegalArgumentException(
                    format(
                            "Row and col indexes must be between 0 and 2! Current row is %s, current col is %s!",
                            cell.getRow(), cell.getCol()
                    )
            );
        }
    }
}
