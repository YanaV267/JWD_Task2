package com.development.task2.parser;

import com.development.task2.entity.Sphere;
import com.development.task2.exception.SphereException;

public interface SphereParser {
    Sphere parseParameters(String[] parameterValues) throws SphereException;
}
