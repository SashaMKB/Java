package tlab;

import tlab.Interfaces.IEvFileOutput;

public class SourceFileOutput {
    IEvFileOutput iEvFileOutput;

    public SourceFileOutput(IEvFileOutput iEvFileOutput) {
        this.iEvFileOutput = iEvFileOutput;
    }

    void genEv(){
        iEvFileOutput.Handler();
    }
}
