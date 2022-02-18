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

/**
 * @author NMOsipenko
 * @link https://github.com/NMOsipenko/
 */
public class MoveConveter {

    public static Cell getCellByKey (int key) {

        switch (key) {
            case (1):
                return new Cell(2, 0);
            case (2):
                return new Cell(2, 1);
            case (3):
                return new Cell(2, 2);
            case  (4):
                return new Cell(1, 0);
            case  (5):
                return new Cell(1, 1);
            case  (6):
                return new Cell(1, 2);
            case  (7):
                return new Cell(0, 0);
            case  (8):
                return new Cell(0, 1);
            case  (9):
                return new Cell(0, 2);
            default:
                return null;
        }

    }
}
