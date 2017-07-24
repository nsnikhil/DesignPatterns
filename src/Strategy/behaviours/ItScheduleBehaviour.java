/*
 * Copyright (C) 2017 nsnikhil
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package Strategy.behaviours;

import Strategy.interfaces.InterfaceSetSchedule;

/**
 * CONCRETE IMPLEMENTATION OF SCHEDULE FOR
 * AN IT PROFESSIONAL
 */
public class ItScheduleBehaviour implements InterfaceSetSchedule {
    @Override
    public void getYourSchedule() {
        System.out.println("You need to work from 10 - 6");
    }
}
