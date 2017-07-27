/*
 * Copyright (C) 2017 nsnikhil
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package Factory;

import Factory.factories.ProductFactory;
import Factory.products.AbstractProduct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * FACTORY METHOD PATTERN IS A PROCESS OF DECLARING
 * A FACTORY THAT CONSTRUCTS OBJECTS FOR YOU, ITS USEFUL
 * WHEN YOU DON'T KNOW WHICH FACTORY TO USE TO CREATE THE
 * OBJECT OR WHICH VARIATION OF OBJECT YOU WANT AT
 * RUNTIME, AND ALSO ENCAPSULATES ANY WHICH LOGIC YOU
 * REQUIRE TO CONSTRUCTS THE OBJECT.
 * <p>
 * HERE WE HAVE AN ABSTRACTION OF PRODUCT WE WANT TO CREATE
 * AND AN ABSTRACTION OVER FACTORY THAT CREATES THAT PRODUCT
 * TO GENERATE RUNTIME VARIATION ON CREATION OF THAT OBJECT.
 * <p>
 * EXAMPLE USED HERE :  WE WANT TO GENERATE ABSTRACT PRODUCT
 * BUT THE IMPLEMENTATION OF THE PRODUCT
 * WILL VARY DEPENDING ON THE USER INPUT
 * THE PRODUCT FACTORY CLASS GENERATES THE
 * APPROPRIATE OBJECT DEPENDING UPON THE
 * USER INPUT.
 */
public class FactoryPattern {

    public static void main(String... args) throws IOException {
        FactoryPattern factoryPattern = new FactoryPattern();
        factoryPattern.generateProduct();
    }

    private void generateProduct() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        ProductFactory productFactory = new ProductFactory();

        System.out.println("Enter 0 to get product of type A" +
                "\nEnter 1 to get product of type B" +
                "\nEnter 2 to get product of type C");

        System.out.println("\nEnter your choice");

        int choice = Integer.parseInt(bufferedReader.readLine());

        AbstractProduct product = productFactory.getProduct(choice);
        System.out.println();
        product.getProductType();
    }

}
