package au.com.ds.ef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface Transition {

    class Repository{
        private final static ThreadLocal<List<Transition>> transitions = new ThreadLocal<List<Transition>>(){{
            set(new ArrayList<>());
        }};

        static List<Transition> get(){
            return transitions.get();
        }

        static List<Transition> consume() {
            List<Transition> ts = transitions.get();
            transitions.set(new ArrayList<>());
            return ts;
        }
    }

    default EventEnum getEvent(){
        throw new UnsupportedOperationException();
    }

    default StateEnum getStateFrom(){
        throw new UnsupportedOperationException();
    }

    default StateEnum getStateTo(){
        throw new UnsupportedOperationException();
    }

    default boolean isFinal(){
        throw new UnsupportedOperationException();
    }

    default void setStateFrom(StateEnum stateFrom){
        throw new UnsupportedOperationException();
    }

    default void propagateStateFrom(StateEnum stateFrom){
        throw new UnsupportedOperationException();
    }

    default List<Transition> getDerivedTransitions(){
        return Collections.emptyList();
    }

    Transition transit(Transition... transitions);
}
