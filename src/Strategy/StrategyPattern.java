/*
 * Copyright (C) 2017 nsnikhil
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package Strategy;

/*
 *IN STRATEGY PATTERN WE DECOUPLE THE BEHAVIOR OR A STRATEGY FROM A CLIENT
 *I.E. ANY BEHAVIOUR OR STRATEGY THAT A CLIENT MIGHT NEED CAN BE CHANGED
 *OR SWAPPED FOR ANOTHER ONE WITHOUT AFFECTING THE CLIENT.
 *
 * EXAMPLE :  A CLASS MIGHT HAVE SOME BEHAVIOUR INSTEAD OF PROVIDING
 *            IMPLEMENTATION FOR EACH OF ITS BEHAVIOUR FOR ITS CHILDREN WE CAN
 *            CHANGE BEHAVIOUR FOR AN INTERFACE AND HAVE CUSTOM IMPLEMENTATIONS
 *            OF THOSE INTERFACES AND THEN IN CHILDREN CLASS WE MIGHT USE A
 *            SPECIFIC VERSION OF IMPLEMENTATION INSTEAD OF WRITING A CONCRETE ONE
 *            OUR SELF AND IF MIGHT BE USEFUL IF TWO CHILDREN HAVE SAME BEHAVIOUR
 *            FOR A PARTICULAR THING.
 *
 *      AND WHERE IT SHINES IS THAT WE DO NOT ANY CHILD OF THAT CLASS TO FORM
 *      A CUSTOM IMPLEMENTATION OF THAT CLASS WE COULD JUST PASS THE COMBINATION OF
 *      THOSE INTERFACE METHODS IN RIGHT WAY TO GET WHAT WE DESIRE
 */

/*
 * EXAMPLE USED HERE :  WE HAVE AN EMPLOYEE CLASS THAT HAS THREE METHODS : TO GET THE SCHEDULE,
 *                      TO PERFORM GIVEN JOB AND TO GET THE SALARY, NORMALLY WE WOULD HAVE A
 *                      EMPLOYEE INTERFACE AND THE DERIVE EMPLOYEES LIKE : IT EMPLOYEE OR AN
 *                      ACCOUNTANT EMPLOYEE BUT INSTEAD WE REPLACE THE METHODS WITH AND INTERFACES
 *                      AND DEFINE AN CUSTOM IMPLEMENTATION FOR THOSE INTERFACES AND THEN PASS THEM
 *                      IN RIGHT COMBINATION IN THE EMPLOYEE CONSTRUCTOR OR SETTER OT GET ANY EMPLOYEE
 *                      WE WANT.
 *
 *                      JOB A + TIME A = IT EMPLOYEE
 *                      JOB A + TIME B = IT JUNIOR EMPLOYEE
 *                      JOB B + TIME A = ACCOUNTANT EMPLOYEE
 */

import Strategy.behaviours.*;

public class StrategyPattern {

    private Employee mItEmployee, mAcEmployee;

    public static void main(String... args) {
        StrategyPattern pattern = new StrategyPattern();
        pattern.createEmployees();
        pattern.startJobs();
    }

    private void createEmployees() {
        mItEmployee = new Employee.EmployeeBuilder()
                .setJob(new ItJobBehaviour())
                .setSal(new SalaryBehaviour())
                .setSchedule(new ItScheduleBehaviour())
                .build();

        mAcEmployee = new Employee.EmployeeBuilder()
                .setJob(new AccountantJobBehaviour())
                .setSal(new SalaryBehaviour())
                .setSchedule(new AccountantScheduleBehaviour())
                .build();
    }

    private void startJobs() {
        mItEmployee.getSchedule();
        mItEmployee.doJob();

        System.out.println();

        mAcEmployee.getSchedule();
        mAcEmployee.doJob();
    }

}
