/*
 * Copyright (C) 2017 nsnikhil
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package Decorator;

import Decorator.decorators.CaptainDecorator;
import Decorator.decorators.MonitorDecorator;
import Decorator.decorators.PrefectDecorator;
import Decorator.interfaces.StudentDetails;

/**
 * DYNAMICALLY ATTACHING NEW BEHAVIOUR TO A OBJECT
 * IS THE CORE LOGIC OF DECORATOR PATTERN, I.E. AN
 * ANY BEHAVIOUR OF A OBJECT IS WRAPPED/DECORATED
 * IN A A NEW OBJECT THAT PROVIDES THAT NEW BEHAVIOUR.
 * <p>
 * HERE WE HAVE A COMPONENT THAT ACTS AS AN ABSTRACTION
 * TO BUILD STUFF BUT IS ALSO USED TO BUILD DECORATORS
 * WHICH IT SELF ARE ABSTRACTION AND WHICH ARE USED BUILD
 * SUB DECORATORS AND THOSE DECORATORS DECORATES THE STUFF
 * TO GET MODIFIED BEHAVIOURS
 * <p>
 * A DECORATOR IS A COMPONENT AND HAS A COMPONENT.
 * THIS PATTERN ALLOWS THE CLASS TO KEEP ITS BEHAVIOUR
 * <p>
 * EXAMPLE WOULD BE DRAWING A SHAPE AND DECORATING IT
 * WITH A BORDER OR A SHADOW AT RUNTIME OR DRAWING A
 * WINDOW AND DECORATING WINDOW WITH A HORIZONTAL OR
 * VERTICAL SCROLLBAR OR BREWING A COFFEE AND ADDING
 * SUGAR OR SUGAR AT RUNTIME
 * <p>
 * HERE DECORATIONS ARE BEHAVIOURS.
 * <p>
 * EXAMPLE USED HERE :  A NEW STUDENT IS CREATED BY INSTANTIATING
 * NEW STUDENT MAKER AND THEN THE STUDENT IS
 * DECORATED/WRAPPED WITH NEW OBJECT THAT PROVIDE
 * ADDITIONAL FUNCTIONALITY TO THE STUDENT OBJECT
 * <p>
 * THE EXAMPLE CHOSEN HERE IS NOT THAT GOOD AS ALL ADDITIONAL BEHAVIOUR
 * COULD HAVE BEEN ADDEDD VIA PASSING A COLLECTION TO A STUDENT MAKER
 * AND APPENDING THOSE TO THE STUDENT NAME, I WILL UPDATE THIS EXAMPLE
 * ONCE I COME UP WITH SOMETHING MORE USEFUL AND SUITABLE FOR THIS PATTERN.
 */

public class DecoratorPattern {

    public static void main(String... args) {
        DecoratorPattern pattern = new DecoratorPattern();
        pattern.createStudents();
    }

    private void createStudents() {
        StudentDetails studentDetails = new StudentMaker("Nikhil");
        System.out.println(studentDetails.getStudentDetail());

        System.out.println();

        StudentDetails studentDetails1 = new MonitorDecorator(studentDetails);
        System.out.println(studentDetails1.getStudentDetail());

        System.out.println();

        StudentDetails studentDetails2 = new PrefectDecorator(studentDetails);
        System.out.println(studentDetails2.getStudentDetail());

        System.out.println();

        StudentDetails studentDetails3 = new CaptainDecorator(studentDetails);
        System.out.println(studentDetails3.getStudentDetail());

        System.out.println();

        StudentDetails studentDetails4 = new CaptainDecorator(new PrefectDecorator(studentDetails));
        System.out.println(studentDetails4.getStudentDetail());
    }

}
