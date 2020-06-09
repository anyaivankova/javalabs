package com.company;

import java.util.*;

public class CoffeeSet implements Set<Coffee> {
    private int size = 0;
    private Coffee[] coffeesArray = new Coffee[15];
    private int maxSize = 15;

    public CoffeeSet() {
    }

    public CoffeeSet(Coffee coffee){
        coffeesArray[0] = coffee;
        size = 1;
    }

    public CoffeeSet(Collection<? extends Coffee> c){
        addAll(c);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i =0; i < size; i++){
            if (coffeesArray[i].equals(o)){
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<Coffee>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public Coffee next() {
                return coffeesArray[cursor++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(coffeesArray, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(coffeesArray, size, a.getClass());
        } else {
            System.arraycopy(coffeesArray, 0, a, 0, size);
            if (a.length > size) {
                a[size] = null;
            }

            return a;
        }
    }

    @Override
    public boolean add(Coffee coffee) {
        if (contains(coffee)){
            return false;
        }
        if(size >= maxSize){
            int newSize = maxSize + (int) Math.round(maxSize*0.3);
            coffeesArray = Arrays.copyOf(coffeesArray, newSize);
            maxSize = newSize;
        }

        coffeesArray[size] = coffee;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Object[] es = coffeesArray;
        int size = this.size;
        int i = 0;
        if (o == null) {
            while (true) {
                if (i >= size) {
                    return false;
                }

                if (es[i] == null) {
                    break;
                }

                ++i;
            }
        } else {
            while (true) {
                if (i >= size) {
                    return false;
                }

                if (o.equals(es[i])) {
                    break;
                }

                ++i;
            }
        }

        this.fastRemove(es, i);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o: c){
            if(!this.contains(o)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Coffee> c) {
        Object[] collection = c.toArray();
        if (collection.length == 0) {
            return false;
        }
        for(Object item: collection){
            add( (Coffee)item );
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return this.batchRemove(collection, false, 0, this.size);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return this.batchRemove(collection, true, 0, this.size);
    }

    @Override
    public void clear() {
        coffeesArray = new Coffee[maxSize];
        size = 0;
    }

    boolean batchRemove(Collection<?> c, boolean complement, int from, int end) {
        Objects.requireNonNull(c);
        Coffee[] es = coffeesArray;

        for (int r = from; r != end; ++r) {
            if (c.contains(es[r]) != complement) {
                int w = r++;

                try {
                    for (; r < end; ++r) {
                        Coffee e;
                        if (c.contains(e = es[r]) == complement) {
                            es[w++] = e;
                        }
                    }
                } catch (Throwable var12) {
                    System.arraycopy(es, r, es, w, end - r);
                    w += end - r;
                    throw var12;
                } finally {
                    this.shiftTailOverGap(es, w, end);
                }

                return true;
            }
        }

        return false;
    }

    private void shiftTailOverGap(Object[] es, int lo, int hi) {
        System.arraycopy(es, hi, es, lo, this.size - hi);
        int to = this.size;

        for (int i = this.size -= hi - lo; i < to; ++i) {
            es[i] = null;
        }

    }

    private void fastRemove(Object[] es, int i) {
        int newSize = this.size - 1;

        if (newSize > i) {
            System.arraycopy(es, i + 1, es, i, newSize - i);
        }

        es[this.size = newSize] = null;
    }
}
