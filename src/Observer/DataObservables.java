/*
 * Copyright (C) 2017 nsnikhil
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package Observer;

import Observer.interfaces.Observables;
import Observer.interfaces.Observers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * THIS CLASS IS THE DATA PRODUCER, THE GENERATE DATA
 * METHOD PRODUCES A NEW RANDOM INTEGER EVERY ONE SECOND
 * AND THEN NOTIFIES ALL IS OBSERVERS THAT A NEW DATA IS
 * AVAILABLE
 */
public class DataObservables implements Observables {

    private List<Observers> mList;
    private Random mRandom;
    private int mData;

    DataObservables() {
        mList = new ArrayList<>();
        mRandom = new Random();
        generateData();
    }

    @Override
    public void registerObserver(Observers observers) {
        mList.add(observers);
    }

    @Override
    public void removeObserver(Observers observers) {
        mList.remove(observers);
    }

    @Override
    public void updateObservers() {
        for (Observers observers : mList) {
            observers.updateOperation();
        }
    }

    private void generateData() {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < 100) {
                i++;
                mData = mRandom.nextInt(100);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                updateObservers();
            }
        });
        thread.start();
    }

    int getData() {
        return mData;
    }
}
