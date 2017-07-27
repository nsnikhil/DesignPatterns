/*
 * Copyright (C) 2017 nsnikhil
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package Singleton;

/**
 * SINGLETON PATTERN HAS ONLY TWO CONSTRAINTS
 * FIRST THAT THEIR SHOULD BE ONLY ONE INSTANCE
 * OF THAT CLASS AND SECOND IS THAT ITS INSTANCE
 * SHOULD HAVE A GLOBAL INSTANCE
 * <p>
 * WE CAN ACHIEVE THIS BY MAKING THE CONSTRUCTOR
 * PRIVATE SO NO ONE OUTSIDE THAT CLASS CAN CREATE ITS
 * INSTANCE AND NEXT WE CREATE A STATIC METHOD THAT
 * STORES A NEW INSTANCE OF THAT CLASS IN A FIELD
 * AND RETURNS THAT OBJECT WHEN EVER IT IS CALLED
 */

public class SingletonPattern {

    public static void main(String... args) {
        SingletonPattern singletonPattern = new SingletonPattern();
        singletonPattern.getSingletonInstances();
    }

    private void getSingletonInstances() {
        SingletonObject object1 = SingletonObject.getInstance();
        SingletonObject object2 = SingletonObject.getInstance();

        /*
         * AFTER EXECUTION OF BOTH FUNCTION THE
         * OBJECT1 & OBJECT2 SETTER WILL HAVE
         * SONI SINCE THEY BOTH OPERATE ON
         * SINGLE OBJECT
         */
        object1.setSetter("Nikhil");
        object2.setSetter("Soni");

        /*
         * == CHECKS IF BOTH OBJECT POINTS TO SAME OBJECT
         * IN HEAP HERE SINCE BOTH VARIABLE POINTS TO
         * THE SAME OBJECT IN HEAP IT RETURNS TRUE
         */
        if (object1 == object2) {
            System.out.println("Points to same object");
        } else {
            System.out.println("Points to different object");
        }

        /*
         * EQUALS COMPARES WHAT IS WRITTEN TO COMPARES
         * NOTHING MORE OR LESS HERE WE ARE COMPARING
         * THE CONTENT OF BOTH OBJECT WHCIH ARE SAME
         */
        if (object1.equals(object2)) {
            System.out.println("Contents of the object are same");
        } else {
            System.out.println("Contents of the object are different");
        }

        /*
         * HERE ALSO TRUE IS RETURNED SINCE BOTH
         * SETTER HAS THE SAME VALUE AS DISCUSSED
         * ABOVE
         */
        if (object1.getSetter().equals(object2.getSetter())) {
            System.out.println("Contents of the string are same");
        } else {
            System.out.println("Contents of the string are different");
        }
    }

}
