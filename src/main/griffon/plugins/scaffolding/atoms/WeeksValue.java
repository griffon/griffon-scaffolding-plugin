/*
 * Copyright 2009-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package griffon.plugins.scaffolding.atoms;

import org.joda.time.Weeks;

import static java.lang.Math.abs;

/**
 * @author Andres Almiray
 */
public class WeeksValue extends AbstractAtomicValue {
    public WeeksValue() {
    }

    public WeeksValue(Weeks arg) {
        setValue(arg);
    }

    public WeeksValue(Number arg) {
        setValue(arg);
    }

    public Weeks weeksValue() {
        return (Weeks) value;
    }

    @Override
    public void setValue(Object value) {
        if (value == null || value instanceof Weeks) {
            super.setValue(value);
        } else if (value instanceof Number) {
            super.setValue(Weeks.weeks(abs(((Number) value).intValue())));
        } else {
            throw new IllegalArgumentException("Invalid value " + value);
        }
    }

    public Class getValueType() {
        return Weeks.class;
    }
}
