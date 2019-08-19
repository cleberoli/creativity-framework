package parser;

import data.Instance;

public interface Parser<T> {

    Instance getInstance(T artifact);
    Integer getNumberOfAttributes();

}
