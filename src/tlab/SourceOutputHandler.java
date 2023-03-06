package tlab;

import tlab.Interfaces.IEvOutputConsole;

public class SourceOutputHandler {
    IEvOutputConsole iEvOutputConsole;
    SourceOutputHandler(IEvOutputConsole iEvOutputConsole) {
        this.iEvOutputConsole = iEvOutputConsole;
    }

    void genEv(){
        iEvOutputConsole.Handler();
    }
}
