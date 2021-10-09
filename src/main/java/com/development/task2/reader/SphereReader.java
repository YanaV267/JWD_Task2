package com.development.task2.reader;

import com.development.task2.exception.SphereException;

public interface SphereReader {
    String[] readParameters(String path) throws SphereException;
}
