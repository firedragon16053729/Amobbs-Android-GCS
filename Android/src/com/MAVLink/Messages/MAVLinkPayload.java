/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

package com.MAVLink.Messages;

import java.nio.ByteBuffer;

public class MAVLinkPayload {

    private static final byte UNSIGNED_BYTE_MIN_VALUE = 0;
    private static final short UNSIGNED_BYTE_MAX_VALUE = Byte.MAX_VALUE - Byte.MIN_VALUE;

    private static final short UNSIGNED_SHORT_MIN_VALUE = 0;
    private static final int UNSIGNED_SHORT_MAX_VALUE = Short.MAX_VALUE - Short.MIN_VALUE;

    private static final int UNSIGNED_INT_MIN_VALUE = 0;
    private static final long UNSIGNED_INT_MAX_VALUE = (long) Integer.MAX_VALUE - Integer.MIN_VALUE;

    private static final long UNSIGNED_LONG_MIN_VALUE = 0;

    public final ByteBuffer payload;
    public int index;

    public MAVLinkPayload(int payloadSize) {
        //Payload size should be less than 512.
        payload = ByteBuffer.allocate(payloadSize);
    }

    public ByteBuffer getData() {
        return payload;
    }

    public int size() {
        return payload.position();
    }

    public void add(byte c) {
        payload.put(c);
    }

    public void resetIndex() {
        index = 0;
    }

    public byte getByte() {
        byte result = 0;
        result |= (payload.get(index + 0) & 0xFF);
        index += 1;
        return result;
    }

    public short getUnsignedByte() {
        short result = 0;
        result |= payload.get(index + 0) & 0xFF;
        index += 1;
        return result;
    }

    public short getShort() {
        short result = 0;
        result |= (payload.get(index + 1) & 0xFF) << 8;
        result |= (payload.get(index + 0) & 0xFF);
        index += 2;
        return result;
    }

    public int getUnsignedShort() {
        int result = 0;
        result |= (payload.get(index + 1) & 0xFF) << 8;
        result |= (payload.get(index + 0) & 0xFF);
        index += 2;
        return result;
    }

    public int getInt() {
        int result = 0;
        result |= (payload.get(index + 3) & 0xFF) << 24;
        result |= (payload.get(index + 2) & 0xFF) << 16;
        result |= (payload.get(index + 1) & 0xFF) << 8;
        result |= (payload.get(index + 0) & 0xFF);
        index += 4;
        return result;
    }

    public long getUnsignedInt() {
        long result = 0;
        result |= (payload.get(index + 3) & 0xFFFFL) << 24;
        result |= (payload.get(index + 2) & 0xFFFFL) << 16;
        result |= (payload.get(index + 1) & 0xFFFFL) << 8;
        result |= (payload.get(index + 0) & 0xFFFFL);
        index += 4;
        return result;
    }

    public long getLong() {
        long result = 0;
        result |= (payload.get(index + 7) & 0xFFFFL) << 56;
        result |= (payload.get(index + 6) & 0xFFFFL) << 48;
        result |= (payload.get(index + 5) & 0xFFFFL) << 40;
        result |= (payload.get(index + 4) & 0xFFFFL) << 32;
        result |= (payload.get(index + 3) & 0xFFFFL) << 24;
        result |= (payload.get(index + 2) & 0xFFFFL) << 16;
        result |= (payload.get(index + 1) & 0xFFFFL) << 8;
        result |= (payload.get(index + 0) & 0xFFFFL);
        index += 8;
        return result;
    }

    public long getUnsignedLong() {
        return getLong();
    }

    public long getLongReverse() {
        long result = 0;
        result |= (payload.get(index + 0) & 0xFFFFL) << 56;
        result |= (payload.get(index + 1) & 0xFFFFL) << 48;
        result |= (payload.get(index + 2) & 0xFFFFL) << 40;
        result |= (payload.get(index + 3) & 0xFFFFL) << 32;
        result |= (payload.get(index + 4) & 0xFFFFL) << 24;
        result |= (payload.get(index + 5) & 0xFFFFL) << 16;
        result |= (payload.get(index + 6) & 0xFFFFL) << 8;
        result |= (payload.get(index + 7) & 0xFFFFL);
        index += 8;
        return result;
    }

    public float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public void putByte(byte data) {
        add(data);
    }

    public void putUnsignedByte(short data) {
        if (data < UNSIGNED_BYTE_MIN_VALUE || data > UNSIGNED_BYTE_MAX_VALUE) {
            throw new IllegalArgumentException("Value is outside of the range of an unsigned byte: " + data);
        }

        putByte((byte) data);
    }

    public void putShort(short data) {
        add((byte) (data >> 0));
        add((byte) (data >> 8));
    }

    public void putUnsignedShort(int data) {
        if (data < UNSIGNED_SHORT_MIN_VALUE || data > UNSIGNED_SHORT_MAX_VALUE) {
            throw new IllegalArgumentException("Value is outside of the range of an unsigned short: " + data);
        }

        putShort((short) data);
    }

    public void putInt(int data) {
        add((byte) (data >> 0));
        add((byte) (data >> 8));
        add((byte) (data >> 16));
        add((byte) (data >> 24));
    }

    public void putUnsignedInt(long data) {
        if (data < UNSIGNED_INT_MIN_VALUE || data > UNSIGNED_INT_MAX_VALUE) {
            throw new IllegalArgumentException("Value is outside of the range of an unsigned int: " + data);
        }

        putInt((int) data);
    }

    public void putLong(long data) {
        add((byte) (data >> 0));
        add((byte) (data >> 8));
        add((byte) (data >> 16));
        add((byte) (data >> 24));
        add((byte) (data >> 32));
        add((byte) (data >> 40));
        add((byte) (data >> 48));
        add((byte) (data >> 56));
    }

    public void putUnsignedLong(long data) {
        if (data < UNSIGNED_LONG_MIN_VALUE) {
            throw new IllegalArgumentException("Value is outside of the range of an unsigned long: " + data);
        }

        putLong(data);
    }

    public void putFloat(float data) {
        putInt(Float.floatToIntBits(data));
    }

}
