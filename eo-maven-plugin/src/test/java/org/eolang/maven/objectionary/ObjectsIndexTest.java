/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2024 Objectionary.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.eolang.maven.objectionary;

import com.yegor256.WeAreOnline;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import org.cactoos.scalar.ScalarOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Test for {@link ObjectsIndex}.
 *
 * @since 0.29
 */
class ObjectsIndexTest {

    @Test
    void contains() throws Exception {
        final AtomicInteger calls = new AtomicInteger(0);
        final String object = "org.eolang.io.stderr";
        final ObjectsIndex index = new ObjectsIndex(
            new ScalarOf<>(
                () -> {
                    calls.incrementAndGet();
                    return Collections.singleton(object);
                }
            )
        );
        MatcherAssert.assertThat(
            index.contains(object),
            Matchers.is(true)
        );
        MatcherAssert.assertThat(
            index.contains(object),
            Matchers.is(true)
        );
        MatcherAssert.assertThat(
            index.contains("unknown"),
            Matchers.is(false)
        );
        MatcherAssert.assertThat(
            calls.get(),
            Matchers.is(1)
        );
    }

    @Test
    @ExtendWith(WeAreOnline.class)
    void downloadsAndChecksFromRealSource() throws Exception {
        MatcherAssert.assertThat(
            new ObjectsIndex().contains("org.eolang.io.stdout"),
            Matchers.is(true)
        );
    }
}
