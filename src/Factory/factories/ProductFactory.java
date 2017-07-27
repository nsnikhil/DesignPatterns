/*
 * Copyright (C) 2017 nsnikhil
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package Factory.factories;

import Factory.products.AbstractProduct;
import Factory.products.ProductA;
import Factory.products.ProductB;
import Factory.products.ProductC;

public class ProductFactory implements AbstractFactory {
    @Override
    public AbstractProduct getProduct(int type) {
        switch (type) {
            case 0:
                return new ProductA();
            case 1:
                return new ProductB();
            case 2:
                return new ProductC();
            default:
                throw new IllegalArgumentException("Invalid choice " + type);
        }
    }
}
