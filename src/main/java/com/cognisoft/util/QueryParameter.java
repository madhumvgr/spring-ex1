package com.cognisoft.util;

import java.util.HashMap;
import java.util.Map;

/**
 * A parameter that can be used in a query. This is a builder style pattern that uses <code>with</code> to build the parameters
 * and <code>and</code> to build additional parameters.
 */
public final class QueryParameter {

    private Map<String, Object> parameters = null;

    private QueryParameter(String name, Object value) {
        this.parameters = new HashMap<String, Object>();
        this.parameters.put(name, value);
    }

    /**
     * Builds a new QueryParameter with the parameter name and value.
     * 
     * @param name the name of the parameter
     * @param value the value of the parameter
     * @return a new instance of QueryParameter with the parameter name and value set
     */
    public static QueryParameter with(String name, Object value) {
        return new QueryParameter(name, value);
    }

    /**
     * Adds a parameter name and value to the query parameters.
     * 
     * @param name the name of the parameter
     * @param value the value of the parameter
     * @return an instance of QueryParameter with the parameter names and values
     */
    public QueryParameter and(String name, Object value) {
        this.parameters.put(name, value);
        return this;
    }

    /**
     * @return the map of parameters with the key being the parameter name
     */
    public Map<String, Object> parameters() {
        return this.parameters;
    }
}
