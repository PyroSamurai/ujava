package ujava;
/*
ubyte.java: this file is part of the ujava library.

Copyright (C) 2020 Sean Stafford (a.k.a. PyroSamurai)

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published
by the Free Software Foundation, either version 3 of the License,
or any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
*/
import java.io.*;
import java.nio.*;
import java.util.*;
import static java.lang.System.out;
//import ujava.*;
/**
Class Description:
This is the ubyte class. It mimics an unsigned byte. Hence the lowercase class.

Dev Notes:
Stored input and resulting output is Little-Endian.
*/
public class ubyte
{
    // class variables
    private static short ubyte=(byte)0x00;

    //==========================================================================
    // class constructor with no value.
    public ubyte() {}
    // class constructor with a byte value to be stored
    public ubyte(byte Int)
    {
        set(Int);
    }
    // class constructor with a short value to be stored (lossy)
    public ubyte(short Int)
    {
        set(Int);
    }
    // class constructor with a char value to be stored (lossy)
    public ubyte(char Int)
    {
        set(Int);
    }
    // class constructor with a int value to be stored (lossy)
    public ubyte(int Int)
    {
        set(Int);
    }
    // class constructor with a byte array value to be stored (lossy)
    public ubyte(byte[] ba, int offset, int bytesToRead, int byteOrder)
    {
        // ByteOrder: LITTLE_ENDIAN=0, BIG_ENDIAN=1
        set(ba,offset,bytesToRead,byteOrder);
    }

    //==========================================================================
    // get() function with a byte value to be returned
    public static byte get()
    {
        return (byte)ubyte;
    }
    // get() function with a short value to be returned
    public static short getShort()
    {
        return ubyte;
    }
    // get() function with a char value to be returned
    public static char getChar()
    {
        return (char)ubyte;
    }
    // get() function with a int value to be returned
    public static int getInt()
    {
        return (int)ubyte;
    }

    //==========================================================================
    // set() function with a byte value to be stored from a byte
    public static void set(byte Int)
    {
        ubyte = toUnsignedByte((int)Int);
    }
    // set() function with a byte value to be stored from a short (lossy)
    public static void set(short Int)
    {
        ubyte = toUnsignedByte((int)Int);
    }
    // set() function with a byte value to be stored from a char (lossy)
    public static void set(char Int)
    {
        ubyte = toUnsignedByte((int)Int);
    }
    // set() function with a byte value to be stored from a int (lossy)
    public static void set(int Int)
    {
        ubyte = toUnsignedByte(Int);
    }
    // set() function with a byte value to be stored from a byte array (lossy)
    public static void set(byte[] ba,int offset,int bytesToRead,int byteOrder)
    {
        int tmp = 0x00;
        ByteBuffer bb = ByteBuffer.wrap(ba);
        // byteOrder: LITTLE_ENDIAN=0, BIG_ENDIAN=1
        if(byteOrder==0)
            bb.order(ByteOrder.LITTLE_ENDIAN);
        else
            bb.order(ByteOrder.BIG_ENDIAN);

        bb.position(offset);
        if(bytesToRead==2)
        {
            tmp = (int)bb.getShort();
        }
        else // 4 or error
        {
            tmp = bb.getInt();
        }
        ubyte = toUnsignedByte(tmp);
    }

    // Underlying workhorse of all the set() functions
    public static short toUnsignedByte(int Int)
    {
        return (short)(java.lang.Byte.toUnsignedInt((byte)Int)&0x00FF);
    }
}

