/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.dto;

import java.util.Objects;

/**
 * Generic class to build a Data transfer object. The data carried is known by
 * its key.
 *
 * @see
 * <a href="https://en.wikipedia.org/wiki/Data_transfer_object"> Wikipedia</a>
 * @author jlc
 * @param <K> key of the data.
 */
public class Dto<K> {
     /**
     * Key of the data.
     */
    protected K key;

    /**
     * Creates a new instance of <code>Dto</code> with the key of the data.
     *
     * @param key key of the data.
     */
    protected Dto(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Clé absente " + key);
        }
        this.key = key;
    }

    /**
     * Returns the key of the data.
     *
     * @return the key of the data.
     */
    public K getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.key);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dto<?> other = (Dto<?>) obj;
        return Objects.equals(this.key, other.key);
    }

}
