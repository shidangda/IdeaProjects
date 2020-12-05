/*
 * Copyright (c) 2009, 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package jdk.nio.zipfs;

import java.nio.file.attribute.BasicFileAttributes;

/**
 * The attributes of a file stored in a zip file.
 *
 * @author Xueming Shen, Rajendra Gutupalli,Jaya Hangal
 */
interface ZipFileAttributes extends BasicFileAttributes {
    public long compressedSize();
    public long crc();
    public int method();
    public byte[] extra();
    public byte[] comment();
    public String toString();
}
