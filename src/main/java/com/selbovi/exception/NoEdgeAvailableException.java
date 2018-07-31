package com.selbovi.exception;

import com.selbovi.SearchDirectionEnum;

/**
 * These exception is thrown when no edge can be found. Such an edge so that a pit between hills can be formed.
 */
public class NoEdgeAvailableException extends Exception {
    public NoEdgeAvailableException(int hillIdx, int[] landscape, SearchDirectionEnum direction) {
    }
}
