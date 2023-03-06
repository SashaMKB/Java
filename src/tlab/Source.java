package tlab;

import tlab.Interfaces.IEv;

public class Source {
    IEv iEv;

    Source(IEv iEv) {
        this.iEv = iEv;
    }

    void genEv(){
        iEv.Handler();
    }
}
