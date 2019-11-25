/*
 * Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.dynamodb.demo;

import java.util.Random;

enum Province {

    // Source: https://en.wikipedia.org/wiki/List_of_Canadian_provinces_and_territories_by_population_growth_rate
    ON("Lorem ipsum dolor sit amet, uam felis, ultricies n, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifendhar ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas ntincidun, met", 13_448_494),
    QC("Sed ut perspiciatis um,ae dicta sunt explicaboquo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omniutem quibusdam et auet vo", 8_164_361),
    BC("BC Sed ut perspiciatis um,ae dicta sunt explicaboquo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omniutem quibusdam et auet vo", 4_648_055),
    AB("AB Sed ut perspiciatis um,ae dicta sunt explicaboquo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omniutem quibusdam et auet vo", 4_067_175),
    MB("Manitoba", 1_278_365),
    SK("Saskatchewan", 1_098_352),
    NS("Nova Scotia", 923_598),
    NB("New Brunswick", 747_101),
    NL("Newfoundland and Labrador", 519_716),
    PE("Prince Edward Island", 142_907),
    NT("Northwest Territories", 41_786),
    NU("Nunavut", 35_944),
    YT("Yukon", 35_874);

    static final int TOTAL_POPULATION = 35_151_728;
    static final Random random = new Random();

    int population;
    String name;

    Province(String name, int population) {
        this.name = name;
        this.population = population;
    }

    static Province getRandom() {
        int count = random.nextInt(Province.TOTAL_POPULATION);
        for (Province province : Province.values()) {
            count -= province.population;
            if (count <= 0) {
                return province;
            }
        }
        return ON;
    }

}