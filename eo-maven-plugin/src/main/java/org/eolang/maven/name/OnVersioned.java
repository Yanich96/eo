/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2023 Objectionary.com
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
package org.eolang.maven.name;

import org.eolang.maven.hash.CommitHash;

/**
 * Object name versioned.
 * This is object name that parses raw sting like:
 * - "org.eolang.text#0.1.0" into "org.eolang.text" and "a1b2c3d"
 * - "org.eolang.string#a1b2c3d" into "org.eolang.string" and "b2c3d4e"
 * Pay attention that versions transformed into hashes.
 * If a version is not provided - behaves like {@link OnUnversioned}.
 *
 * @since 0.30
 * @todo #2281:30min Implement OnVersioned class.
 *  This class should parse raw string into object name and hash from object name with semver
 *  version. In other words this class should replace the behavior of
 *  {@link org.eolang.maven.VersionsMojo} class. When this class is implemented,
 *  remove the {@link org.eolang.maven.VersionsMojo class}.
 *  Don't forget to add tests for this class.
 */
public final class OnVersioned implements ObjectName {

    /**
     * Raw string.
     * Examples:
     * - "org.eolang.text#0.1.0"
     * - "org.eolang.string#1.23.1"
     * - "org.eolang.math#3.3.3"
     */
    private final String raw;

    /**
     * Constructor.
     * @param origin Raw string.
     */
    public OnVersioned(final String origin) {
        this.raw = origin;
    }

    @Override
    public String value() {
        throw new UnsupportedOperationException(
            "This 'value()' method is not supported for OnVersioned yet"
        );
    }

    @Override
    public CommitHash hash() {
        throw new UnsupportedOperationException(
            "The 'hash()' method is not supported for OnVersioned yet"
        );
    }

    @Override
    public String toString() {
        return this.raw;
    }
}
