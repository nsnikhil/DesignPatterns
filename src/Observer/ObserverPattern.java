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


/**
 * Observer pattern follows a push based architecture
 * where we have an observable which is the producer of data
 * and an observer which observes on a observable, it is the
 * responsibility of an observables to notify all its observer
 * of a change by using this mechanism we defer from polling
 * mechanism which required observers to continuously poll the
 * observable for data.
 * <p>
 * EXAMPLE USED HERE :  TWO INTERFACES WHICH REPRESENTS THE OBSERVER PATTERN,
 * FIRST THE OBSERVABLE WHICH IS AN ABSTRACTION, AND ITS CONCRETE
 * IMPLEMENTATION WILL BE THE PRODUCER OF DATA AND WILL BE
 * RESPONSIBLE FOR NOTIFYING ALL THE OBSERVERS THAT HAVE
 * REGISTERED TO LISTEN FOR CHANGES AND SECOND IS AN OBSERVER
 * WHICH IS ALSO AN ABSTRACTION WHOSE CONCRETE IMPLEMENTATION
 * CONTAINS UPDATE METHOD WHICH IS CALLED BY OBSERVABLE EVERY TIME
 * A NEW DATA/CHANGE IS PRODUCED.
 * <p>
 * HERE DATAOBSERVABLE PRODUCES RANDOM INTEGER EVERY SECOND AND THEN
 * CALLS UPDATEOBSERVERS WHICH NOTIFIES ALL THE OBSERVERS THAT WERE
 * REGISTERED USING THE REGISTEROBSERVER METHODS THAT NEW DATA
 * IS AVAILABLE WHICH THEN CALLS THE GETDATA ON THE OBSERVABLE TO
 * PRINT THE NEW DATA.
 */

public class ObserverPattern {

    public static void main(String... args) {
        ObserverPattern observerPattern = new ObserverPattern();
        observerPattern.observerData();
    }

    private void observerData() {
        DataObservables dataObservables = new DataObservables();

        DataObserver dataObserver = new DataObserver(dataObservables);

        dataObservables.registerObserver(dataObserver);
    }


}
