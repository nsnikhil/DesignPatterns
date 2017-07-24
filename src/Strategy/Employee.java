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
 * USING BUILDER PATTERN TO GENERATE A POJO FOR
 * EMPLOYEE
 */

import Strategy.interfaces.InterfaceSetJob;
import Strategy.interfaces.InterfaceSetSalary;
import Strategy.interfaces.InterfaceSetSchedule;

public class Employee {

    private InterfaceSetJob mInterfaceSetJob;
    private InterfaceSetSalary mInterfaceSetSalary;
    private InterfaceSetSchedule mInterfaceSetSchedule;

    Employee(EmployeeBuilder employeeBuilder) {
        mInterfaceSetJob = employeeBuilder.mInterfaceSetJob;
        mInterfaceSetSalary = employeeBuilder.mInterfaceSetSalary;
        mInterfaceSetSchedule = employeeBuilder.mInterfaceSetSchedule;
    }

    void doJob() {
        mInterfaceSetJob.doYourJob();
    }

    public void getPaid() {
        mInterfaceSetSalary.getYourSalary();
    }

    void getSchedule() {
        mInterfaceSetSchedule.getYourSchedule();
    }

    static class EmployeeBuilder {

        private InterfaceSetJob mInterfaceSetJob;
        private InterfaceSetSalary mInterfaceSetSalary;
        private InterfaceSetSchedule mInterfaceSetSchedule;

        EmployeeBuilder setJob(InterfaceSetJob interfaceSetJob) {
            mInterfaceSetJob = interfaceSetJob;
            return this;
        }

        EmployeeBuilder setSal(InterfaceSetSalary interfaceSetSalary) {
            mInterfaceSetSalary = interfaceSetSalary;
            return this;
        }

        EmployeeBuilder setSchedule(InterfaceSetSchedule interfaceSetSchedule) {
            mInterfaceSetSchedule = interfaceSetSchedule;
            return this;
        }

        Employee build() {
            return new Employee(this);
        }

    }

}
